/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject;

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
	public static Trainer create(Scanner sc) {
		Trainer trainer = new Trainer(Main.inputString(sc, "Enter first name: "),
				Main.inputString(sc, "Enter last name: "),
				Main.inputString(sc, "Enter subject: "));
		return trainer;
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
