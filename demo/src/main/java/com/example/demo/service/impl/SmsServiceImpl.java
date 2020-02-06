package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.NotificationService;

@Service("smsService")
public class SmsServiceImpl implements NotificationService {

	@Override
	public boolean sendNotification(String phoneNumber, String message) {
		
        System.out.println("Trying to send message via SMS center. phoneNumber: " + phoneNumber);
        System.out.println(message);

        return true;
	}

}