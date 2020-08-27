/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinoproject;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author f3nix
 */
public class Utilities {

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

	// Clears the screen (Doesn't work for NetBeans Output. For terminals and command prompts only.)
	public static void clearScreen() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				// for Windows systems
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\u001b[H\u001b[2J"); // for Unix systems
				System.out.flush();
			}
		} catch (IOException | InterruptedException ex) {
			System.out.println("Screen couldn't be cleared. Sorry!");
		}
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

	public static int inputChoice(Scanner sc, int maxChoice) {
		int choice;
		while (true) {
			System.out.println();
			choice = inputInt(sc, "::Enter your choice : ");
			if (choice >= 1 && choice <= maxChoice) {
				System.out.println("");
				break;
			} else {
				System.out.println("Choice must be between 1 and " + maxChoice + ".");
				System.out.println("");
			}
		}
		return choice;
	}

	// Pauses the program until Enter key is pressed.
	public static void pressEnterToReturn(String message) {
		try {
			System.out.print("::" + message);
			System.in.read();
		} catch (IOException ex) {
			System.out.println("IO Error!");
		}
	}

	public static void printTable() {
		System.out.print("|");
		for (int i = 1; i < 81; i++) {
			System.out.printf(" %3d  ", i);
			if (i % 10 == 0) {
				System.out.print("|");
				System.out.println();
				if (i % 80 != 0) {
					System.out.print("|");
				}
			}
		}
	}

	public static Integer oddOrEven(Set<Integer> numbers) {
		Integer oddOrEven = null;
		int even = 0;
		int odd = 0;
		for (Integer number : numbers) {
			if (number % 2 == 0) {
				even++;
			} else {
				odd++;
			}
			if (even > odd) {
				oddOrEven = 1;
			} else if (even < odd) {
				oddOrEven = 2;
			} else {
				oddOrEven = 3;
			}
		}
		return oddOrEven;
	}

}
