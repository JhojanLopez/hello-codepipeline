package com.example.hellocodepipeline.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloCodePipelineServiceImpl implements HelloCodePipelineService {
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.profiles.active}")
    private String environment;

    @Override
    public String greeting(String name) {
        return "Hello " + name + ", have a good day. "+ applicationName + " greets you. ";
    }

    @Override
    public String environment() {
        if (environment.equals("prod")) {
            return "production";
        }
        return "development";
    }
}
