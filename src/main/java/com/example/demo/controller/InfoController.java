package com.example.demo.controller;

import com.example.demo.entities.InfoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class InfoController {

    @GetMapping("/api")
    public InfoResponse getInfo(
            @RequestParam String slack_name,
            @RequestParam String track
    ) {
        // Get the current day of the week and UTC time
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        String utcTime = now.format(dateTimeFormatter);

        // Create and return the response object
        InfoResponse response = new InfoResponse(
                slack_name,
                dayOfWeek.toString(),
                utcTime,
                track,
                "https://github.com/username/repo/blob/main/file_name.ext",
                "https://github.com/username/repo",
                200
        );
        return response;
    }
}
