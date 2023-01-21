package com.patriciamolnar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Birthday {
    private LocalDate birthday; 
    public static void main(String[] args) {
        Birthday program = new Birthday(); 
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome! Please enter your birth date (DD MM YYYY)");

        String answer = input.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MM yyyy");
        program.birthday = LocalDate.parse(answer, formatter);
        System.out.println(program.birthday);

        input.close();
    }
}

// format the output of the variable so it's being printed in a nice way
// try with resources 
// error handling DateTimeParseException
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