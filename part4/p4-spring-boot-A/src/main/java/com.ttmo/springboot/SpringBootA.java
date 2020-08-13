package com.ttmo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@EnableEurekaClient
@SpringBootApplication
public class SpringBootA {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootA.class, args);
    }

}
