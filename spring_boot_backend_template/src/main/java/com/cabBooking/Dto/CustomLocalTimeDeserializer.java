package com.cabBooking.Dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CustomLocalTimeDeserializer extends JsonDeserializer<LocalTime> {

    @Override
    public LocalTime deserialize(JsonParser p, com.fasterxml.jackson.databind.DeserializationContext ctxt) throws IOException {
        String timeStr = p.getText().trim();
        
        LocalTime time;
        try {
            // Try parsing 12-hour format (e.g., 01:15 PM)
            DateTimeFormatter formatter12Hour = DateTimeFormatter.ofPattern("hh:mm a");
            time = LocalTime.parse(timeStr, formatter12Hour);
        } catch (Exception e) {
            // If parsing 12-hour format fails, try parsing 24-hour format (e.g., 15:00)
            DateTimeFormatter formatter24Hour = DateTimeFormatter.ofPattern("HH:mm");
            time = LocalTime.parse(timeStr, formatter24Hour);
        }
        
        return time;
    }
}


