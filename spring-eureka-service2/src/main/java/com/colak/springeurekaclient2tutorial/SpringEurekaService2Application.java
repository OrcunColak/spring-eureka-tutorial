package com.colak.springeurekaclient2tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringEurekaService2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringEurekaService2Application.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // If this was an API Gateway, it could be like this
    // @Bean
    // @LoadBalanced
    // WebClient webClient() {
    //     return WebClient.builder().build();
    // }

}
