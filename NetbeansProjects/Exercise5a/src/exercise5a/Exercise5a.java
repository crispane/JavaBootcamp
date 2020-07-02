/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise5a;
import java.util.*;

/**
 *
 * @author panag
 */
public class Exercise5a {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		String name = "";
		int age;
		//Construct new Scanner
		Scanner sc= new Scanner(System.in); 
		//Print name request 
		System.out.print("Enter first name: ");
		//Read next line from input and and store in variable
		name = sc.nextLine();
		System.out.println(name);
		//Print age request
		System.out.print("Enter your age: ");
		//Read age as int and print year of Birth
		age = sc.nextInt();
		int year = Calendar.getInstance().get(Calendar.YEAR) - age;
		System.out.println("Year of Birth: " + year);
	}
	
}
