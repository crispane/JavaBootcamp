/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author f3nix
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("* Bootcamp date availability check *");
		System.out.println();

		System.out.println("Enter 1st Bootcamp details");
		BootCamp bc1 = createBC(sc);
		System.out.println();

		System.out.println("Enter 2nd Bootcamp details");
		BootCamp bc2 = createBC(sc);
		System.out.println();

		System.out.println("Enter 3rd Bootcamp details");
		BootCamp bc3 = createBC(sc);
		System.out.println();

		List<BootCamp> bcList = new ArrayList<>();
		bcList.add(bc1);
		bcList.add(bc2);
		bcList.add(bc3);

		printAvailableBC(sc, bcList);

	}

	public static BootCamp createBC(Scanner sc) {
		BootCamp bootcamp = new BootCamp(inputString(sc, "Enter title: "),
				inputDate(sc, "Enter start date (dd/mm/yyyy): "),
				inputDate(sc, "Enter end date (dd/mm/yyyy): "));
		return bootcamp;
	}

	public static void printAvailableBC(Scanner sc, List<BootCamp> bc) {
		LocalDate date = inputDate(sc, "Check available date: ");
		List<BootCamp> bcCandidates = new ArrayList<>();
		for (BootCamp bootcamp : bc) {
			if (!(date.isBefore(bootcamp.getStartingDate()) || date.isAfter(bootcamp.getEndingDate()))) {
				bcCandidates.add(bootcamp);
			}
		}
		if (!bcCandidates.isEmpty()) {
			System.out.println("Bootcamps available in " + date + ":");
			for (BootCamp bootcamp : bcCandidates) {
				System.out.println(bootcamp);
			}
			System.out.println();
		} else {
			System.out.println("Sorry no bootcamp is available in " + date);
			System.out.println();
		}
	}

	public static String inputString(Scanner sc, String message) {
		System.out.print(message);
		return sc.next();
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
}