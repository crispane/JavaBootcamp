/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author f3nix
 */
public class Main {

	/**
	 * @param args the command line arguments
	 * @throws java.io.IOException
	 */
	public static void main(String[] args) throws IOException {


			
			Menus.mainMenu();//, courses, students, trainers, assignments);
	}

	public static String inputString(Scanner sc, String message) {
		System.out.print(message);
		String temp = sc.next();
		return temp;
	}

	public static int inputInt(Scanner sc, String message) {
		int x = 0;
		while (true) {
			try {
				System.out.print(message);
				x = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Number must be an integer.");
				sc.next();
			}
		}
		return x;
	}

	public static LocalDate inputDate(Scanner sc, String message) {
		LocalDate date;
		while (true) {
			System.out.print(message);
			String temp = sc.next();
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				date = LocalDate.parse(temp, formatter);
				break;
			} catch (DateTimeParseException e) {
				System.out.println("Invalid Date.");
			}
		}
		return date;
	}

	public static BigDecimal inputMoney(Scanner sc, String message) {
		BigDecimal amount = new BigDecimal("000");
		while (true) {
			try {
				System.out.printf(message);
				amount = sc.nextBigDecimal();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Number must be a decimal.");
				sc.next();
			}
		}
		return amount;
	}

	public static boolean yes(Scanner sc) {
		char c;
		//Guard loop until appropriate char is given
		while (true) {
			c = sc.next().charAt(0);
			if (c == 'Y' || c == 'y') {
				return true;
			}
			if (c == 'N' || c == 'n') {
				return false;
			}
			System.out.print("Y or N ?");
		}
	}

}
