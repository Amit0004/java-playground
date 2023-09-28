package com.experiment;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
        public static void main(String[] args) {
            long epochMillis = 1683313972274L; // example epoch milliseconds
            Instant instant = Instant.ofEpochMilli(epochMillis);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
            System.out.println("UTC localDateTime time: " + localDateTime.toString());
            System.out.println("UTC instant time: " + instant.toString());
        }
}