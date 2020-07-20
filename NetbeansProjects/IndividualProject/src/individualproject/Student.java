/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author f3nix
 */
public class Student {

	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private BigDecimal tuitionFees;

	public Student() {
	}

	public Student(String firstName, String lastName, LocalDate dateOfBirth, BigDecimal tuitionFees) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.tuitionFees = tuitionFees;
	}

	public static List<Student> create(Scanner sc) throws IOException {
		List<Student> list = new ArrayList<>();
		while (true) {
			list.add(new Student(Main.inputString(sc, "Enter first name: "),
					Main.inputString(sc, "Enter last name: "),
					Main.inputDate(sc, "Enter Date of Birth (dd/mm/yyyy): "),
					Main.inputMoney(sc, "Enter tuition fees: ")));
			System.out.printf("Do you want to add a new Student (Y/n)? ");
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BigDecimal getTuitionFees() {
		return tuitionFees;
	}

	public void setTuitionFees(BigDecimal tuitionFees) {
		this.tuitionFees = tuitionFees;
	}

	@Override
	public String toString() {
		return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", tuitionFees=" + tuitionFees + '}';
	}

}
