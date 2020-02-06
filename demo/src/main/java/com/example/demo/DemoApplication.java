package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.demo.config.Config;
import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;

@EnableAspectJAutoProxy
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class)) {
            
        	// GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("applicationContext.xml")
        	
        	MemberService memberService = applicationContext.getBean(MemberService.class);
        	
            memberService.subscribe(new Member("임성호", "01036155931"));
        }
	}

}