package com.ttmo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@EnableEurekaServer
@SpringBootApplication
public class Eureka {

    public static void main(String[] args) {
        SpringApplication.run(Eureka.class, args);
    }

}
