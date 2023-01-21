package com.patriciamolnar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Birthday {
    private LocalDate birthday; 
    public static void main(String[] args) {

        try(Scanner input = new Scanner(System.in);) {
            Birthday program = new Birthday(); 
            System.out.println("Welcome! Please enter your birth date (YYYY MM DD)");
            String answer = input.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MM yyyy", Locale.getDefault());
            program.birthday = LocalDate.parse(answer, formatter);

            DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("E, d LLL yyyy.");
            System.out.println(myFormat.format(program.birthday));
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        } finally {
            System.out.println("Program over");
        }

    }
}

// try with resources 
// error handling DateTimeParseException, IllegalArgumentException
// DateTimeFormatter builder

/**
 * Notes: 
 * d (will parse days that have 1 or 2 digits)
 * MMM (will parse Apr, but not April)
 * MMMM (will parse April, but not Apr)
 * MM (will parse 04 but not Apr / April)
 * 
 * if you use Scanner.next() you cannot have spaces in between words. A safer format would be e.g. using 01-02-2023
 */