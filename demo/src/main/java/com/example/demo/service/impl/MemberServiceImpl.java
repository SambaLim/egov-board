package com.example.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import com.example.demo.service.NotificationService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private NotificationService smsService;
	
	@Resource(name="KakaoService")
    private NotificationService kakaoService;
	
	@Override
	public boolean subscribe(Member member) {
		
		if (member == null) throw new IllegalArgumentException("Member is null");
		
        if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty()) {
            smsService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
        }

        if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty()) {
            kakaoService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
        }
		
		
		return true;
	}

}
