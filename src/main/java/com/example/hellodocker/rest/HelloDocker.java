package com.example.hellodocker.rest;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDocker {
	
	@Value("${message}")
	String message;

	@GetMapping("hello")
	public String hello() {
		StringBuilder message = new StringBuilder("Hello Docker!");		
		try {
			InetAddress ip = InetAddress.getLocalHost();
			String hostName = InetAddress.getLocalHost().getHostName();
			message.append(" From host: " + ip + ", " + ", hostName : " + hostName + ", "+ message);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return message.toString();
	}
}
