package com.confident.silverconnect.service;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class RequestSMSDto {

    String title;
//    본문 내용
    String body;
//    발신번호
    String sendNo;
//
    List<RecipientDto> recipientList;

    static class RecipientDto {
        String recipientNo;
        String countryCode;

        public RecipientDto(String recipientNo) {
            this.recipientNo = recipientNo;
            this.countryCode = "82";
        }
    }

    public RequestSMSDto(String title, String body, String sendNo, List<String> recipientNo) {
        this.title = title;
        this.body = body;
        this.sendNo = sendNo;
        this.recipientList = new ArrayList<>();
        for (String no : recipientNo) {
            this.recipientList.add(new RecipientDto(no));
        }
    }
}
