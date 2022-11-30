package com.confident.silverconnect.service;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RequestSMSDto {
//    본문 내용
    String body;
//    발신번호
    String sendNo;
//
    List<String> recipientNo;
}
