/*
*Create a method that asks the user to input a number. 
*If the input is not a number the program should ask the user to enter a valid number. 
*Also check if the user inputs a number between 1 and 10. 
*Only these numbers can pass. Otherwise the program should ask for a number between 1 and 10. 
*The program will keep asking the user for input until he/she enters a number between 1-10.
 */
package validnumber;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class ValidNumber {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		askNumber(sc);
	}
	
	public static int askNumber(Scanner sc) {
        int x = -1;
        do {
			try{
            System.out.print("Enter number between 1-10: ");
            x = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Number must be an integer.");
				sc.next();
			}
			
        }while(x > 10 || x < 1);
            return x;
       
    }
}
