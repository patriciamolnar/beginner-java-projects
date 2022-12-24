package com.patriciamolnar;

public class Calculator {
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-'; 
    private final char MULTIPLICATION = '*'; 
    private final char DIVIDSION = '/'; 
    private final char MODULUS = '%'; 

    int num1; 
    int num2; 
    char operation; 

    public static void main(String[] args) {
        Calculator calculator = new Calculator(); 
        calculator.setOperands(args);
        int result = calculator.calculate(); 
        if(result == -1) {
            System.out.println("Invalid operation.");
        } else {
            System.out.println("The result is: " + result);
        }
    }

    void setOperands(String[] args) {
        if(args.length != 3) {
            System.out.println("Please provide 3 arguments in the form of e.g. '1 * 3'.");
        } else {
            int num1, num2; 
            char operand = args[1].charAt(0);
            
            try {
                num1 = Integer.parseInt(args[0]); 
                num2 = Integer.parseInt(args[2]);
                this.num1 = num1; 
                this.operation = operand; 
                this.num2 = num2;
            }
            catch (NumberFormatException ex){
                System.out.println("Incorrect format. Please make sure you are entering numbers.");
            }
            
        }
    }

    int calculate() {
        int result = -1; 

        if(operation == ADDITION) {
            result = num1 + num2; 
        } else if(operation == SUBTRACTION) {
            result = num1 - num2;
        } else if(operation == MULTIPLICATION) {
            result = num1 * num2;
        } else if(operation == DIVIDSION) {
            result = num1 / num2;
        } else if(operation == MODULUS) {
            result = num1 % num2;
        }

        return result; 
    }
    
}
