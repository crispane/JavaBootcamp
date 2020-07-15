/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson11exercises;

import java.util.Scanner;

/**
 *
 * @author f3nix
 */
public class Lesson11Exercises {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) 
	{
		System.out.println("Exercise 1: ");
		Scanner sc = new Scanner(System.in);	
		System.out.print("Enter your favorite movie quote and i'll count the spaces: ");
		System.out.println(numberOfSpaces(sc) + " spaces in the quote.");

		System.out.println();

		System.out.println("Exercise 2: ");
		String str = "Harry";	
		int n = str.length();
		String mystery = str.substring(0, 1) + str.substring(n - 1, n);
		System.out.println(mystery);

		System.out.println();

		System.out.println("Exercise 4: ");
		TestClass tc = new TestClass(20, 1000000000L, 34.4F, 25.5); 
		System.out.println(tc.toString());

		System.out.println();

		System.out.println("Exercise 6: ");
		System.out.println(inverseAnalog("abcdedfghedcba")); 
		System.out.println(inverseAnalog("abccba"));
		System.out.println(inverseAnalog("abcba"));
		System.out.println(inverseAnalog("aba"));
		System.out.println(inverseAnalog("aa"));
		System.out.println(inverseAnalog("a"));
		String test = inverseAnalog("abccba");
		System.out.println(test);

		System.out.println();
	}

	public static int numberOfSpaces(Scanner sc) {
		String a = sc.nextLine();
		return a.length() - a.replace(" ", "").length();
	}

	public static String inverseAnalog(String str) {
		if (str.length() - 1 < 1) return "";
		if (str.charAt(0) != str.charAt(str.length() - 1)) return "";
		return str.charAt(0) + inverseAnalog(str.substring(1, str.length() - 1));
		

	}

}
