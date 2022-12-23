package com.patriciamolnar;

public class Numbers {
    int bigDecimalNumber = 500_000_000; 
    int binary = 0b10101; 
    int octal = 010; 
    int hexadecimal = 0x00; 

    void printNumber(String name) {
        switch(name) {
            case "decimal": 
                System.out.println(bigDecimalNumber);
                break;
            case "binary": 
                System.out.println(binary);
                break;
            case "octal": 
                System.out.println(octal);
                break;
            case "hexadecimal": 
                System.out.println(hexadecimal);
                break;
            default: 
                System.out.print("Please provide a valid argument.");
        }
    }
}
