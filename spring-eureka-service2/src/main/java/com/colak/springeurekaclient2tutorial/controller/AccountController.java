package com.colak.springeurekaclient2tutorial.controller;

import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final RestTemplate restTemplate;
    private final EurekaClient discoveryClient;

    // http://localhost:9002/account/user
    @GetMapping("/user")
    public ResponseEntity<String> user() {
        // http://172.31.96.1:9001/user/normal
        String baseUrl = discoveryClient.getNextServerFromEureka("service1", false)
                                 .getHomePageUrl() + "user/normal";

        return restTemplate.getForEntity(baseUrl, String.class);

    }

    // http://localhost:9002/account/normal
    @GetMapping("/normal")
    public ResponseEntity<String> normalUser() {
        return ResponseEntity.ok("Yes, this is a normal account.");
    }
}
