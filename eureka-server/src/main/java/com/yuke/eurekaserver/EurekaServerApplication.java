package com.yuke.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }


   /* server:
    port: 8761
    eureka:
    instance:
    hostname: eureka-server
    prefer-ip-address: true
    client:
    register-with-eureka: false
    fetch-registry: false
    defaultZone: http://192.168.40.128:8761/eureka/*/


}
