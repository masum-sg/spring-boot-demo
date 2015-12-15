package com.example.spring.boot;

import net.sf.aspect4log.Log;
import net.sf.aspect4log.Log.Exceptions;
import net.sf.aspect4log.Log.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring.boot.aop.service.HelloWorldService;

@Controller
@Log
public class WebController {
	@Autowired
	private HelloWorldService helloWorldService;

	@RequestMapping(value = "/")
	@Log(enterLevel = Level.INFO, exitLevel = Level.INFO, on = @Exceptions(level = Level.INFO))
	public String index() {
		System.out.println("Home Page");
		this.helloWorldService.getHelloMessage("Suma", 26);
		return "index";
	}
}