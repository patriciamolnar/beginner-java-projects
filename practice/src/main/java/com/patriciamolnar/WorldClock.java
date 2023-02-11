package com.patriciamolnar;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class WorldClock {
    public static void main(String[] args) {
        WorldClock clock = new WorldClock(); 
        clock.getUserInput();
    }


    void getUserInput() {
        try(Scanner input = new Scanner(System.in)) {
            System.out.println("Welcome! Enter time in format YYYY/MM/DD HH:MM");
            String timeInput = input.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d HH:mm");
            LocalDateTime time = LocalDateTime.parse(timeInput, formatter);
            // ZonedDateTime current = ZonedDateTime.of(time, ZoneId.systemDefault()); 
            // ZonedDateTime hongKong = ZonedDateTime.of(time, ZoneId.of("Hongkong"));
            // ZonedDateTime shangHai = ZonedDateTime.of(time, ZoneId.of("Asia/Shanghai"));
            // ZonedDateTime losAngeles = ZonedDateTime.of(time, ZoneId.of("America/Los_Angeles"));
            // ZonedDateTime berlin = ZonedDateTime.of(time, ZoneId.of("Europe/Berlin"));
            // ZonedDateTime moscow = ZonedDateTime.of(time, ZoneId.of("Europe/Moscow"));

            System.out.println("You're current time is " + time);
            System.out.println("In 香港, that's: " + time.atZone(ZoneId.of("Hongkong")));
            // System.out.println("In 上海, that's: " + shangHai);
            // System.out.println("In Los Angeles, that's: " + losAngeles);
            // System.out.println("In Berlin, that's: " + berlin);
            // System.out.println("In Moscow, that's: " + moscow);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}


/**
 * steps: 
 * get input from user
 * read time
 * convert it different city times. 
 */