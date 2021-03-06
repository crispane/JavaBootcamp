package WorkingClasses;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class Inputs {

	/* methods for inputing DataTypes */
	public static String inputString(Scanner sc, String message) {
		System.out.print(message);
		String temp = sc.nextLine();
		return temp;
	}

	public static int inputInt(Scanner sc, String message) {
		int x = 0;
		while (true) {
			System.out.print(message);
			if (sc.hasNextInt()) {
				x = sc.nextInt();
				break;
			} else {
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

	// BigDecimal for money
	public static BigDecimal inputMoney(Scanner sc, String message) {
	BigDecimal amount = new BigDecimal("000");
		while (true) {
			System.out.printf(message);
			if (sc.hasNextBigDecimal()) {
				amount = sc.nextBigDecimal();
				break;
			} else {
				System.out.println("Number must be a decimal.");
				sc.next();
			}
		}
		return amount;
	}

	// asks yes or no
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
			System.out.print("y or n ?");
		}
	}

	// Catches choice from menus
	public static int inputChoice(Scanner sc, int maxChoice) {
		int choice;
		while (true) {
			System.out.println();
			choice = inputInt(sc, "::Enter choice Number: ");
			if (choice >= 0 && choice <= maxChoice) {
				break;
			} else {
				System.out.println("Choice must be between 0 and " + maxChoice + ".");
			}
		}
		return choice;
	}

}
