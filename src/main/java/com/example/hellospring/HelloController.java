package com.example.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    public HelloController() {
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Azure Spring Cloud team!";
    }

    @GetMapping("/microsoft")
	public String makeRequest() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("https://www.bing.com", String.class);
		return "GET Microsoft " + response.getStatusCode();
	}
}