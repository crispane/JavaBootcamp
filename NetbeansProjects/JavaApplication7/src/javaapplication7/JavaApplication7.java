/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.util.Scanner;

/**
 *
 * @author panag
 */
public class JavaApplication7 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//define and init a Scanner sc
		Scanner sc = new Scanner(System.in);

		//define and init a variable called age of type int
		Integer age = 0;
		Float sage = 0f;
		//Ask the user about his age
		System.out.println("What is your age? ");

		//get user's age
		age = Integer.parseInt(sc.next());
		sage = Float.parseFloat(sc.next());
//		age = Integer.parseInt("1120");
		sage = sage + 1;
		System.out.println(age);
		System.out.println(sage + 1);

		

		
	}
	
}
