package com.gc.reactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class ReactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactorApplication.class, args);
	}

	@GetMapping("/hello")
	public Mono<String> hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return Mono.just(String.format("Hello %s!", name));
	}

}
