/*
author:Chrysanthos Panagakos
 */
package exercise5;
import java.util.*;
/**
 *
 * @author panag
 */
public class Exercise5 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		/* Ask the user his first name and then print his first name
        Ask the user his age and then print the year he was born
        */

		//Construct new Scanner
		Scanner sc= new Scanner(System.in); 
		//Print name request 
		System.out.print("Enter first name: ");
		//Read next line from input and print name
		System.out.println(sc.nextLine());
		//Print age request
		System.out.print("Enter your age: ");
		//Read age as int and print year of Birth
		System.out.println("Year of Birth: " + (Calendar.getInstance().get(Calendar.YEAR)-sc.nextInt()));
	
	}
	
}