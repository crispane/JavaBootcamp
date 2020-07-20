/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author f3nix
 */
public class Trainer {
	String firstName;
	String lastName;
	String subject;

	public Trainer() {
	}

	public Trainer(String firstName, String lastName, String subject) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.subject = subject;
	}

	public static List<Trainer> create(Scanner sc) throws IOException {
		List<Trainer> list = new ArrayList<>();
		while (true) {
			list.add(new Trainer(Main.inputString(sc, "Enter first name: "), Main.inputString(sc, "Enter last name: "), Main.inputString(sc, "Enter subject: ")));
			System.out.printf("Do you want to add a new Trainer(Y/n)? ");
			if (!Main.yes(sc)) {
				break;
			}
		}
		System.out.print("Thank you. Press Enter to return to main menu.");
		System.in.read();
		return list;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Trainer{" + "firstName=" + firstName + ", lastName=" + lastName + ", subject=" + subject + '}';
	}

	
}
