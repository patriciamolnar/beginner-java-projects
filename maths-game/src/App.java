import java.time.Duration;
import java.time.Instant;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    private int min = 1; 
    private int max = 10; 

    private int count = 0;
    private char[] types = {'+', '-', '*', '/', '%'};
    private Random random = new Random();

    private int correct = 0;
    
    private double x, y; 
    private int currentTypeIndex;

    private int limit = 10; 

    public static void main(String[] args) {
        App app = new App();
        Scanner input = new Scanner(System.in);

        Instant start = Instant.now();
        app.runQuiz(input);
        Instant end = Instant.now(); 
        String durationMessage = app.getDuration(start, end);
        input.close();

        System.out.println("Game Over: You got " + app.correct + " out of " + app.limit + " correct.");
        System.out.println("The time you needed to complete game: " + durationMessage);
    }

    private void runQuiz(Scanner input) {
        String question = ""; 
        try {
            do {
                question = generateQuestion();
                handleAnswer(input, question);
            } while(count < limit);
        } catch(InputMismatchException ime) {
            handleError(input, question);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void runQuiz(Scanner input, String question) {
        try {
            do {
                System.out.println(Ansi.ANSI_RED + "We're expecting a valid number! Please try again:" + Ansi.ANSI_RESET);
                handleAnswer(input, question);
                runQuiz(input);
            } while(count < limit);
        } catch(InputMismatchException ime) {
            handleError(input, question);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleAnswer(Scanner input, String question) {
        System.out.println(question);
        double answer = input.nextDouble();   
        checkAnswer(answer);
        count++;
    }

    private void handleError(Scanner input, String question) {
        input.next();
        runQuiz(input, question);
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
            this.x = x;
            this.y = y;
        } else {
            this.x = y;
            this.y = x;
        }

        return String.format("%.0f", this.x) + " " + calcType + " " + String.format("%.0f", this.y);
    }

    private double calculateSolution() {
        double result; 

        switch(currentTypeIndex) {
            case 0: 
                result = x + y;
                break;
            case 1: 
                result = x - y;
                break; 
            case 2: 
                result = x * y;
                break;
            case 3: 
                result = x / y;
                break;
            case 4: 
                result = x % y;
                break; 
            default: 
                result = 0; 
        }

        return Math.round(result * 100.0) / 100.0;
    }

    private void checkAnswer(double answer) {
        double solution = calculateSolution();
        if(solution == answer) {
            correct++;
            System.out.println(Ansi.ANSI_GREEN + "Correct" + Ansi.ANSI_RESET);
        } else {
            System.out.println(
                Ansi.ANSI_RED + "Incorrect" + Ansi.ANSI_RESET + 
                ", answer is: " + 
                Ansi.ANSI_GREEN + solution + Ansi.ANSI_RESET);
        }
    }

    private String getDuration(Instant start, Instant end) {
        Duration duration = Duration.between(start, end);
        
        System.out.println(duration);
        long absSeconds = Math.abs(duration.getSeconds());

        long hours =  absSeconds / 3600;
        long minutes = (absSeconds % 3600) / 60;
        long seconds = absSeconds % 60; 

        String result = ""; 
        if(hours > 0) {
            result += hours + " hours ";
        }

        if(minutes > 0) {
            result +=  minutes + " minutes "; 
        }

        result += seconds + " seconds";

        return result; 
    }
}

/** 
 * add timer that makes message an error when user fails to supply input
 * increase the size of the numbers used as the game progresses
 * allow users to choose specific division to practice. 
 */


/**
 * notes: 
 * 
 * when adding a number to a char, the char will be converted to its ASCII code and the result will be a number
 * e.g. 1 + ' ' will return 33, as ASCII code for space is 32. 
 * 
 * for divisions use doubles
 */