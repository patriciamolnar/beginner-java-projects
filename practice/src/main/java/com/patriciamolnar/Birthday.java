package com.patriciamolnar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Scanner;

public class Birthday {
    private LocalDate birthday; 
    public static void main(String[] args) {
        Birthday program = new Birthday();
        program.getBirthdayInfo(); 
    }

    private void learningFormatterBuilder() {
        LocalDate date = LocalDate.now();
        System.out.println(date.getDayOfWeek());
        // DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        // DateTimeFormatter formatter = builder
        //     .appendLiteral("You were born on a: ")
        //     .appendValue(date.getDayOfWeek())
        //     .toFormatter();
    }

    private String getDayOfBirthday() {
        DayOfWeek dayOfWeek = birthday.getDayOfWeek();
        String day = dayOfWeek.toString().toLowerCase();
        return day.substring(0, 1).toUpperCase() + day.substring(1);
    }

    private void getBirthdayInfo() {
        try(Scanner input = new Scanner(System.in);) { 
            System.out.println("Welcome! Please enter your birth date (DD MM YYYY)");
            String answer = input.nextLine();
            birthday = convertStringToDate(answer);
            String day = getDayOfBirthday();
            System.out.println("You were born on a " + Ansi.ANSI_GREEN + day + Ansi.ANSI_RESET + '.');
            // formatDate(birthday);

            // if user inputs incorrect value
        } catch (DateTimeParseException dte) {
            System.out.println("Invalid input. Please enter your birthdate in the format DD MM YYYY");
            System.out.println("The error: " + dte.getMessage());
            System.out.println(dte.getStackTrace());

            // cannot format birthdate
        } catch (IllegalArgumentException iae) {
            System.out.println("The developer messed up something.");
            System.out.println("The error: " + iae.getMessage());
            System.out.println(iae.getStackTrace());

            // generic error
        } catch(Exception ex) {
            System.out.println("The error: " + ex.getMessage());
            System.out.println(ex.getStackTrace());
        } finally {
            System.out.println("Program over");
        }
    }

    private LocalDate convertStringToDate(String userInput) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MM yyyy", Locale.getDefault());
        return LocalDate.parse(userInput, formatter);
    }

    private void formatDate(LocalDate birthday) throws IllegalArgumentException {
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("E, d LLL yyyy.");
        System.out.println(myFormat.format(birthday));
    }
}

// DateTimeFormatter builder

/**
 * - how many days alive
 * how many years alive
 * seconds
 * minutes
 * what time was it in hong kong, london, new york, los angeles. 
 * how many seconds since the epoch
 */


/**
 * Useful links: 
 * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#patterns
 * https://www.concretepage.com/java/jdk-8/java-8-datetimeformatter-datetimeformatterbuilder-example
 * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
 * 
 * Notes: 
 * d (will parse days that have 1 or 2 digits)
 * MMM (will parse Apr, but not April)
 * MMMM (will parse April, but not Apr)
 * MM (will parse 04 but not Apr / April)
 * 
 * if you use Scanner.next() you cannot have spaces in between words. A safer format would be e.g. using 01-02-2023
 * to solve this problem use Scanner.nextLine()
 */