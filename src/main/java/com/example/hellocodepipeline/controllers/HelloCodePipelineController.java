package com.example.hellocodepipeline.controllers;

import com.example.hellocodepipeline.services.HelloCodePipelineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class HelloCodePipelineController {
    private final HelloCodePipelineService service;

    @GetMapping("/greeting/{name}")
    public ResponseEntity<?> greeting(@PathVariable String name) {
        try {
            return ResponseEntity.ok(service.greeting(name));
        } catch (Exception e) {
            log.error("There was an error in the controller (greeting(@PathVariable String name)) "+ e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/environment")
    public ResponseEntity<?> getEnvironment() {
        try {
            return ResponseEntity.ok("App is running in the environment " + service.environment());
        } catch (Exception e) {
            log.error("There was an error in the controller (getEnvironment()) "+ e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
