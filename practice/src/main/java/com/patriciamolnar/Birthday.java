package com.patriciamolnar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Birthday {
    private LocalDate birthday; 
    public static void main(String[] args) {
        try(Scanner input = new Scanner(System.in);) {
            Birthday program = new Birthday(); 
            System.out.println("Welcome! Please enter your birth date (YYYY MM DD)");
            String answer = input.nextLine();
            program.birthday = program.convertStringToDate(answer);
            program.printResult(program.birthday);
        } catch(Exception ex) {
            System.out.println("The error: " + ex.getMessage());
            System.out.println(ex.getStackTrace());
        } finally {
            System.out.println("Program over");
        }
    }

    public LocalDate convertStringToDate(String userInput) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MM yyyy", Locale.getDefault());
        return LocalDate.parse(userInput, formatter);
    }

    public void printResult(LocalDate birthday) throws IllegalArgumentException {
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("E, d LLL yyyy.");
        System.out.println(myFormat.format(birthday));
    }
}
// error handling DateTimeParseException, IllegalArgumentException
// DateTimeFormatter builder

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
 */