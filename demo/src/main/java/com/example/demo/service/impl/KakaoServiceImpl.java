package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.NotificationService;

@Service("KakaoService")
public class KakaoServiceImpl implements NotificationService {

	@Override
	public boolean sendNotification(String phoneNumber, String message) {
		
		System.out.println("Trying to send message via Kakao. phoneNumber: " + phoneNumber);
        System.out.println("Success to send message");
		
		return true;
	}

}