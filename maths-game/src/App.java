import java.util.Random;
import java.util.Scanner;

public class App {
    private int min = 1; 
    private int max = 10; 

    private int count = 0;
    // private char[] types = {'+', '-', '*', '/', '%'};
    private char[] types = {'/', '/', '/', '/', '/'};
    private Random random = new Random();

    private int correct = 0;
    
    private double num1, num2; 
    private int currentTypeIndex;

    public static void main(String[] args) {
        App app = new App();

        try(Scanner input = new Scanner(System.in)) {
            do {
                String question = app.generateQuestion();
                System.out.println(question);
                double answer = input.nextDouble();
                app.checkAnswer(answer);
                app.count++;
            } while(app.count < 10);
        }

        System.out.println("Game Over: You got " + app.correct + " out of 10 correct.");
    }

    private double generateNumber() {
        return Math.floor(Math.random() * (max - min + 1) + min);
    }

    private int generateNumber(int max) {
        return random.nextInt(max);
    }

    private String generateQuestion() {
        double x = generateNumber();
        double y = generateNumber(); 
        currentTypeIndex = generateNumber(types.length);
        char calcType = types[currentTypeIndex];

        if(x > y) {
            num1 = x;
            num2 = y;
        } else {
            num1 = y;
            num2 = x;
        }

        return num1 + " " + calcType + " " + num2;
    }

    private double calculateSolution() {
    
        double result = num1 / num2; 

        return Math.round(result * 100.0) / 100.0; 
        
        // switch(currentTypeIndex) {
        //     case 0: 
        //         result = x + y;
        //         break;
        //     case 1: 
        //         result = x - y;
        //         break; 
        //     case 2: 
        //         result = x * y;
        //         break;
        //     case 3: 
        //         result = x / y;
        //         break;
        //     case 4: 
        //         result = x % y;
        //         break; 
        //     default: 
        //         result = 0; 
        // }

        // return (float) result; 
    }

    private void checkAnswer(double answer) {
        double solution = calculateSolution();
        if(solution == answer) {
            correct++;
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect, answer is: " + solution);
        }
    }
}

/**
 * todo: 
 * allow floats as an input 
 * handle errors
 */


/**
 * notes: 
 * 
 * when adding a number to a char, the char will be converted to its ASCII code and the result will be a number
 * e.g. 1 + ' ' will return 33, as ASCII code for space is 32. 
 */