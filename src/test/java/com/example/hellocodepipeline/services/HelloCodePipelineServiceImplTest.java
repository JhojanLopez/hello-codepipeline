package com.example.hellocodepipeline.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HelloCodePipelineServiceImplTest {
    @InjectMocks
    HelloCodePipelineServiceImpl service;

    @Test
    void testGreeting() {
        ReflectionTestUtils.setField(service, "applicationName", "MyApp");
        String result = service.greeting("John");
        assertEquals("Hello John, have a good day. MyApp greets you. ", result);
    }

    @Test
    void testEnvironment() {
        ReflectionTestUtils.setField(service, "environment", "prod");
        String result = service.environment();
        assertEquals("production", result);
    }

}