package com.confident.silverconnect.service;

import com.confident.silverconnect.domain.Household.Household;
import com.confident.silverconnect.domain.Household.Risk;
import com.confident.silverconnect.domain.Schedule.TimeTable;
import com.confident.silverconnect.domain.User.User;
import com.confident.silverconnect.dto.schedule.ScheduleCreateDto;
import com.confident.silverconnect.util.EpochTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SchedulingService {

    private static final String SMS_REQUEST_URL = "https://api-sms.cloud.toast.com/sms/v3.0/appKeys/OwIeztV5gkkBodex/sender/sms";
    private final ScheduleService scheduleService;
    private final HouseholdService householdService;
    private final UserService userService;

    private static final String RISK_AI_URL = "http://133.186.219.125:7000/predict";

    private static final String LOCAL_DATA_DIR = new File("").getAbsolutePath() + "/src/main/data/";

    private List<List<String>> householdsData = new ArrayList<>();
    private int localDataIndex = 0;

    private List<String> parseData(String path) throws IOException {
        List<String> data = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(path));
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            data.add(line);
        }

        return data;
    }

    public SchedulingService(ScheduleService scheduleService, HouseholdService householdService, UserService userService) throws IOException {
        this.scheduleService = scheduleService;
        this.householdService = householdService;
        this.userService = userService;

        householdsData.add(parseData(LOCAL_DATA_DIR + "1.csv"));
        householdsData.add(parseData(LOCAL_DATA_DIR + "2.csv"));
        householdsData.add(parseData(LOCAL_DATA_DIR + "3.csv"));
        householdsData.add(parseData(LOCAL_DATA_DIR + "4.csv"));
        householdsData.add(parseData(LOCAL_DATA_DIR + "5.csv"));
        householdsData.add(parseData(LOCAL_DATA_DIR + "6.csv"));
        householdsData.add(parseData(LOCAL_DATA_DIR + "7.csv"));
        householdsData.add(parseData(LOCAL_DATA_DIR + "8.csv"));
    }


    //    @Scheduled(cron = "0 0 0 * * *")
//    public void startScheduling() {
//    }


    private int requestPredictRisk(String data) {
        String predictedRisk = WebClient.create(RISK_AI_URL)
                .post()
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(data))
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return Integer.parseInt(predictedRisk);
    }

    @Scheduled(cron = "0 0/10 * * * *")
    @Transactional
    public void updateRisks() {
        System.out.println("   _____ _ _                   _____                            _              _____ \n" +
                "  / ____(_) |                 / ____|                          | |       /\\   |_   _|\n" +
                " | (___  _| |_   _____ _ __  | |     ___  _ __  _ __   ___  ___| |_     /  \\    | |  \n" +
                "  \\___ \\| | \\ \\ / / _ \\ '__| | |    / _ \\| '_ \\| '_ \\ / _ \\/ __| __|   / /\\ \\   | |  \n" +
                "  ____) | | |\\ V /  __/ |    | |___| (_) | | | | | | |  __/ (__| |_   / ____ \\ _| |_ \n" +
                " |_____/|_|_| \\_/ \\___|_|     \\_____\\___/|_| |_|_| |_|\\___|\\___|\\__| /_/    \\_\\_____|\n" +
                "                                                                                     \n" +
                "                                                                                     ");
        for (int i = 0; i < 8; i++) {
            int riskIndex = requestPredictRisk(householdsData.get(i).get(localDataIndex));
            System.out.println("[Daily Scheduling] Household " + i + " Risk level : " + Risk.valueOfIndex(riskIndex).toString());

            Household household = householdService.getHouseholdById(i + 1);

            if(household.getRisk().equals(Risk.EMERGENCY)){
                sendSMS(household);
            }
            household.updateRisk(Risk.valueOfIndex(riskIndex));
        }

        localDataIndex++;
    }

    private void sendSMS(Household household){
        RequestSMSDto requestSMSDto = new RequestSMSDto(household.getResidentName() + "님의 상태가 : " + household.getRisk() + "하오니 방문이 시급한 상태입니다.",
                "010-1234-5678",
                Arrays.asList("821087979301", "821027526203", "821077413701", "821087999941"));
        String requestUrl = WebClient.create(SMS_REQUEST_URL)
                .post()
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(requestSMSDto))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

//    {
//        "templateId":"TemplateId",
//            "body":"본문",
//            "sendNo":"15446859",
//            "requestDate":"2018-08-10 10:00",
//            "senderGroupingKey":"SenderGroupingKey",
//            "recipientList":[
//        {
//            "recipientNo":"01000000000",
//                "countryCode":"82",
//                "internationalRecipientNo":"821000000000",
//                "templateParameter":{
//            "key":"value"
//        },
//            "recipientGroupingKey":"recipientGroupingKey"
//        }
//   ],
//        "userId":"UserId",
//            "statsId":"statsId"
//    }

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void startSchedulingByLocalData() {
        updateRisks();

        List<Long> userIds = userService.getAll().stream().map(User::getId).collect(Collectors.toList());
        List<Long> sortedHouseholdIds = householdService.getAll().stream().map(Household::getId).collect(Collectors.toList());

        int userIndex = 0;
        int timeIndex = 0;
        for (Long householdId : sortedHouseholdIds) {
            LocalDateTime time = TimeTable.getTime(timeIndex);
            LocalDateTime date = LocalDateTime.now();
            LocalDateTime scheduleDateTime = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), time.getHour(), time.getMinute());

            ScheduleCreateDto scheduleCreateDto = ScheduleCreateDto.builder()
                    .userId(userIds.get(userIndex))
                    .householdId(householdId)
                    .epochSecond(EpochTime.toEpochSecond(scheduleDateTime))
                    .build();
            scheduleService.createSchedule(scheduleCreateDto);

            userIndex++;
            userIndex %= userIds.size();
            timeIndex++;
            timeIndex %= TimeTable.size();
        }
    }
}
