package com.example.demo.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

	// PointCut: com.example.demo 패키지와 하위 패키지의 모든 메소드 실행
	@Around("execution(* com.example.demo..*.*(..))")
	public Object printTime(ProceedingJoinPoint proceedingJointPoint) throws Throwable {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		System.out.println(proceedingJointPoint.getSignature().getName() + " [실행 전 시간] " + simpleDateFormat.format(new Date()));
		Object result = proceedingJointPoint.proceed();
		System.out.println(proceedingJointPoint.getSignature().getName() + " [실행 후 시간:] " + simpleDateFormat.format(new Date()));
		
		return result;
	}
}
