package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.Config;
import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class)) {
            
        	// GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("applicationContext.xml")
        	
        	MemberService memberService = applicationContext.getBean(MemberService.class);
        	MemberService memberService2 = applicationContext.getBean(MemberService.class);
        	
        	System.out.println(memberService);
        	System.out.println(memberService2);
        	
            memberService.subscribe(new Member("임성호", "01036155931"));
        }
	}

}