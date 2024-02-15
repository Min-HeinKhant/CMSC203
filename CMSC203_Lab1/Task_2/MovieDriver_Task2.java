/*
 * Class: CMSC203-32689
 * Instructor: Professor Grigoriy Grinberg
 * Description: A Class Lab where we import a Movie Class and include details
 * Due: 02/19/2024
 * Platform/compiler:Java Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Min Hein Khant
*/


import java.util.Scanner;

public class MovieDriver_Task2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Movie mov = new Movie();  
		boolean restart = true;
		
		while (restart == true) {
		System.out.println("Enter the title of the movie:");
	    String title = scan.nextLine();
	    mov.setTitle(title);
	    
	    System.out.println("Enter the movie’s rating:");
        String rat = scan.nextLine();
        mov.setRating(rat);
        
        System.out.println("Enter the number of tickets sold at the theater:");
        int ticketsSold = scan.nextInt();
        mov.setSoldTickets(ticketsSold);

        scan.nextLine(); //Sometimes, newline character gets stuck in buffer
        System.out.println(mov.toString());
        
        System.out.println("Do you want to enter another? (y or n)");
        String choice = scan.nextLine();

        restart = choice.equalsIgnoreCase("y");
		}
        scan.close();  
	}

}
