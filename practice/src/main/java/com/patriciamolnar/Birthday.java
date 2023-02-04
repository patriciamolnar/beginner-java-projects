package com.patriciamolnar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
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

    private void getDayOfBirthday() {
        DayOfWeek dayOfWeek = birthday.getDayOfWeek();
        String day = dayOfWeek.toString().toLowerCase();
        String dayString = day.substring(0, 1).toUpperCase() + day.substring(1);
        System.out.println("You were born on a " + Ansi.ANSI_GREEN + dayString + Ansi.ANSI_RESET + '.');
    }

    private void printPeriodAlive() {
        LocalDate today = LocalDate.now();

        Period period = Period.between(birthday, today);
        int years = period.getYears(); 
        int months = period.getMonths();
        int days = period.getDays();

        System.out.println("You have been alive " + 
            Ansi.ANSI_GREEN + years + Ansi.ANSI_RESET + (years == 1 ? " year " : " years ") + 
            Ansi.ANSI_GREEN + months + Ansi.ANSI_RESET + (months == 1 ? " month " : " months ") +
            Ansi.ANSI_GREEN + days + Ansi.ANSI_RESET + (days == 1 ? " day." : " days."));

        long totalMonths = ChronoUnit.MONTHS.between(birthday, today); 
        long totalDays = ChronoUnit.DAYS.between(birthday, today);
        
        System.out.println("That's a total of " + Ansi.ANSI_GREEN + totalMonths + Ansi.ANSI_RESET + (totalMonths == 1 ? " month" : " months."));
        System.out.println("Or " + Ansi.ANSI_GREEN + totalDays + Ansi.ANSI_RESET + (totalDays == 1 ? " day." : " days."));
    }

    private void getBirthdayInfo() {
        try(Scanner input = new Scanner(System.in);) { 
            System.out.println(Ansi.ANSI_GREEN + "Welcome! Please enter your birth date (DD MM YYYY)" + Ansi.ANSI_RESET);
            
            String answer = input.nextLine();
            birthday = convertStringToDate(answer);

            getDayOfBirthday();
            printPeriodAlive();

        } catch (DateTimeParseException dte) { // if user inputs incorrect value
            handleError(dte, "Invalid input. Please enter your birthdate in the format DD MM YYYY");

        } catch (IllegalArgumentException iae) { // cannot format birthdate
            handleError(iae, "The developer messed up something.");
        
        } catch(Exception ex) { // generic error
            handleError(ex);
        } finally {
            System.out.println("Bye.");
        }
    }

    private void handleError(Exception ex) {
        System.out.println("The error: " + ex.getMessage());
        System.out.println(ex.getStackTrace());
    }

    private void handleError(Exception ex, String message) {
        System.out.println(message);
        handleError(ex); 
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