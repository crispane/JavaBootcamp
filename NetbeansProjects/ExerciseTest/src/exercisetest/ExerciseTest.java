/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetest;
import java.util.*;
import java.lang.*;

/**
 *
 * @author panag
 */
public class ExerciseTest {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//Construct new Scanner
		Scanner sc= new Scanner(System.in); 
		//Print current year request 
		System.out.print("Enter current year: ");
		//Read next line from input 
		int year = sc.nextInt();
		//Print age request
		System.out.print("Enter your age: ");
		//Read next int from input 
		int age= sc.nextInt();
		//Difference
		int diff = Math.abs(year - age);
		//Print name request 
		System.out.print("Enter first name: ");
		//init String name
		String name = sc.next();
		//Read next Line
//		name = sc.next();
		//Print Hello message
		System.out.println("Hello " + name);
	}
	
}
