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
		Scanner sc = new Scanner(System.in);
		while (true) {
			initialMenu(sc);
		}
	}

	public static void initialMenu(Scanner sc) throws IOException {
		clearScreen();
		System.out.println("********** Welcome to Bootcamp Registry Program **********");
		System.out.println("1. Create new student ");
		System.out.println("2. Create new trainer ");
		System.out.println("3. Create new course ");
		System.out.println("4. Create new assignment ");
		System.out.println("0. Exit Program");
		System.out.println("************************************************************");
		initialChoice(sc, inputChoice(sc, 4));
	}

	public static void initialChoice(Scanner sc, int choice) throws IOException {
		switch (choice) {
			case 1:
				clearScreen();
				Student.create(sc);
				break;
			case 2:
				clearScreen();
				Trainer.create(sc);
				break;
			case 3:
				clearScreen();
				Course.create(sc);
				break;
			case 4:
				clearScreen();
				Assignment.create(sc);
				break;
			case 0:
				System.exit(0);
			default:
				break;
		}
	}

	public static int inputChoice(Scanner sc, int maxChoice) {
		int choice;
		while (true)
			try {
			System.out.print("Enter choice Number: ");
			choice = sc.nextInt();
			if (choice >= 0 && choice <= maxChoice) {
				break;
			} else {
				System.out.println("Choice must be between 0 and " + maxChoice + ".");
			}
		} catch (InputMismatchException e) {
			System.out.println("Number must be an integer.");
			sc.next();
		}
		return choice;
	}

	public static String inputString(Scanner sc, String message) {
		System.out.print(message);
		return sc.next();
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

	public static void clearScreen() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (IOException | InterruptedException ex) {
		}
	}
}
