package dev.prometheus.exptracker.utils;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class Date {
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-d HH:mm:ss");
    private String formattedDate = myDateObj.format(myFormatObj);
}
