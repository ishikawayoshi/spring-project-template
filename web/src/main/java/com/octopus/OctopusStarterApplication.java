package com.octopus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.octopus"})
public class OctopusStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(OctopusStarterApplication.class);
    }
}
