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

public class MovieDriver_Task1 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Movie mov = new Movie();  //Creates Movie instance named Mov. 
		
		System.out.println("Enter the title of the movie:");
	    String title = scan.nextLine();
	    mov.setTitle(title); //Uses function in the parent class to set variable
	    
	    System.out.println("Enter the movie’s rating:");
        String rat = scan.nextLine();
        mov.setRating(rat); //Uses function in the parent class to set variable
        
        System.out.println("Enter the number of tickets sold at the theater:");
        int ticketsSold = scan.nextInt();
        mov.setSoldTickets(ticketsSold); //Uses function in the parent class to set variable

        System.out.println(mov.toString());

        scan.close();  
	}

}
