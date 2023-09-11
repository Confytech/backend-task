package com.example.demo.controller;

import com.example.demo.entities.InfoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@RestController
public class InfoController {

    @GetMapping("/api")
    public InfoResponse getInfo(
            @RequestParam String slack_name,
            @RequestParam String track
    ) {
        // Get the current day of the week and UTC time
        // Get the current UTC time in the desired format
        ZonedDateTime now = ZonedDateTime.now();
        DateTimeFormatter utcFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String utcTime = now.format(utcFormatter);

        // Get the current day
        String currentDay = now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        // Create and return the response object
        InfoResponse response = new InfoResponse(
                slack_name,
                currentDay,
                utcTime,
                track,
                "https://github.com/Confytech/backend-task/blob/master/src/main/java/com/example/demo/controller/InfoController.java",
                "https://github.com/Confytech/backend-task",
                200
        );
        return response;
    }
}
