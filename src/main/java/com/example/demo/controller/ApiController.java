package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class ApiController {

    @GetMapping("/dashboard/summary")
    public Map<String, Object> dashboardSummary() {
        return Map.of(
            "status",  "ok",
            "total",   0,
            "message", "Dashboard summary"
        );
    }

    @GetMapping("/pagination")
    public Map<String, Object> pagination() {
        return Map.of(
            "page",  0,
            "size",  10,
            "total", 0
        );
    }
}
