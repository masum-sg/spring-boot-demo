package com.example.spring.boot.aop.service;

import net.sf.aspect4log.Log;
import net.sf.aspect4log.Log.Exceptions;
import net.sf.aspect4log.Log.Level;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {

	@Value("${name:World}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Log(enterLevel=Level.INFO, exitLevel=Level.INFO, on=@Exceptions(level=Level.ERROR))
	public String getHelloMessage(String name, int age) {
		return "Hello " + this.name;
	}
}