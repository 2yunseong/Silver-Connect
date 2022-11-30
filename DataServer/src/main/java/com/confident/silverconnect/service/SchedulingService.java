package com.confident.silverconnect.service;

import com.confident.silverconnect.domain.Household.Household;
import com.confident.silverconnect.domain.Household.Risk;
import com.confident.silverconnect.domain.Schedule.TimeTable;
import com.confident.silverconnect.domain.User.User;
import com.confident.silverconnect.dto.schedule.ScheduleCreateDto;
import com.confident.silverconnect.util.EpochTime;
import org.springframework.http.HttpStatus;
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
public class SchedulingService {

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

    private void updateRisks() {
        for (int i = 0; i < 8; i++) {
            int riskIndex = requestPredictRisk(householdsData.get(i).get(localDataIndex));
            System.out.println(i + " : riskIndex " + riskIndex);

            Household household = householdService.getHouseholdById(i + 1);
            household.updateRisk(Risk.valueOfIndex(riskIndex));
        }

        localDataIndex++;
    }

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
