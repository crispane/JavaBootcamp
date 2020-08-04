package WorkingClasses;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author f3nix
 */
public class Inputs {

	// methods for inputing DataTypes
	public static String inputString(Scanner sc, String message) {
		System.out.print(message);
		String temp = sc.next();
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
			if (c == 'Y' || c == 'y' || c == '\n') {
				return true;
			}
			if (c == 'N' || c == 'n') {
				return false;
			}
			System.out.print("Y or N ?");
		}
	}

	// Catches choice from menus
	public static int inputChoice(Scanner sc, int maxChoice) {
		int choice;
		while (true) {
			System.out.print("Enter choice Number: ");
			if (sc.hasNextInt()) {
				choice = sc.nextInt();
				if (choice >= 0 && choice <= maxChoice) {
					break;
				} else {
					System.out.println("Choice must be between 0 and " + maxChoice + ".");
				}
			} else {
				System.out.println("Number must be an integer.");
				sc.next();
			}
		}
		return choice;
	}

	// Pauses the program until Enter is pressed
	public static void pressEnterToReturn(String message) {
		try {
			System.out.print("--" + message);
			System.in.read();
			System.in.skip(System.in.available());
		} catch (IOException ex) {
			System.out.println("IO Error!");
		}
	}

}
