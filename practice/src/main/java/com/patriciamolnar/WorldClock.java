package com.patriciamolnar;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
            System.out.println(time);
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