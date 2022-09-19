package br.inatel.labs.lab_rest_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@GetMapping
	public MyMessage processarGetHelloMessage() {
		MyMessage message = new MyMessage();
		message.setInfo("asd");
		return message;
	}
}
