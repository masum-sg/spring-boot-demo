package com.example.spring.boot.aop.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.spring.boot.aop.service.HelloWorldService;

//@Aspect
@Component
public class ServiceMonitor {

//	@Before("execution(public String getHelloMessage())")
	public void logServiceAccess(JoinPoint joinPoint) {
		HelloWorldService helloWorldService = (HelloWorldService)joinPoint.getThis();
		System.out.println("Completed: " + helloWorldService.getName());
	}

}
