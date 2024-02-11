/*
 * Class: CMSC203 
 * Instructor: Professor Grigoriy Grinberg
 * Description: A Simulation of an ESP Color Test
 * Due: 02/12/2024
 * Platform/compiler:Java Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Min Hein Khant
*/

package computerScience203_Assigments;

import java.util.Random;
import java.util.Scanner;

public class ESPGame {

    public static void main(String[] args) {
    	
    	// Colors initialized as constants
        final String RED = "Red";
        final String ORANGE = "Orange";
        final String YELLOW = "Yellow";
        final String GREEN = "Green";
        final String BLUE = "Blue";
        final String INDIGO = "Indigo";
        final String VIOLET = "Violet";

        //Set correctGuesses to 0 to avoid errors, and start a random generator
        int correctGuesses = 0;
        Random rand = new Random();
        Scanner stdin = new Scanner(System.in);

        //Gets background info of student
        System.out.print("Enter your name: ");
        String name = stdin.nextLine();
        System.out.print("Describe yourself: ");
        String description = stdin.nextLine();
        System.out.print("Due Date: ");
        String dueDate = stdin.nextLine();
        
        
        //For loop to make it loop 11 times
        for (int i = 0; i < 11; i++) {
            int colorNum = rand.nextInt(7);
            String chosenColor = "";
            switch (colorNum) {
                case 0: chosenColor = RED; break;
                case 1: chosenColor = ORANGE; break;
                case 2: chosenColor = YELLOW; break;
                case 3: chosenColor = GREEN; break;
                case 4: chosenColor = BLUE; break;
                case 5: chosenColor = INDIGO; break;
                case 6: chosenColor = VIOLET; break;
            }

            String guess;
            do {
                System.out.println("\nRound " + (i + 1) + "\nI am thinking of a color. Is it Red, Orange, Yellow, Green, Blue, Indigo, or Violet?");
                System.out.print("Enter your guess: ");
                guess = stdin.nextLine();
            } while (!guess.equalsIgnoreCase(RED) && !guess.equalsIgnoreCase(ORANGE) &&
                     !guess.equalsIgnoreCase(YELLOW) && !guess.equalsIgnoreCase(GREEN) &&
                     !guess.equalsIgnoreCase(BLUE) && !guess.equalsIgnoreCase(INDIGO) &&
                     !guess.equalsIgnoreCase(VIOLET));
            
            //Ignore case to ignore capital letters as long as the letters are the same. .Equals work with strings, not ==

            if (guess.equalsIgnoreCase(chosenColor)) {
                correctGuesses++;
                System.out.println("Correct! It was " + chosenColor);
            } else {
                System.out.println("Incorrect. It was " + chosenColor);
            }
        }

        System.out.println("\nGame Over! You guessed " + correctGuesses + " out of 11 colors correctly.");
        System.out.println("Student Name: " + name);
        System.out.println("User Description: " + description);
        System.out.println("Due Date: " + dueDate);

        stdin.close();
    }
}
