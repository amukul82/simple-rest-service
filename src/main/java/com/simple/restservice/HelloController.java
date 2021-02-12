package com.simple.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/hello")
	public HelloModel hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new HelloModel(counter.incrementAndGet(), String.format(template, name));
	}
}