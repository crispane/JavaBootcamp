/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author f3nix
 */
public class Assignment {

	String title;
	String description;
	LocalDate subDateTime;
	int oralMark;
	int totalMark;

	public Assignment() {
	}
	public Assignment(String title, String description, LocalDate subDateTime, int oralMark, int totalMark) {
		this.title = title;
		this.description = description;
		this.subDateTime = subDateTime;
		this.oralMark = oralMark;
		this.totalMark = totalMark;
	}

	public static List<Assignment> create(Scanner sc) throws IOException {
		List<Assignment> list = new ArrayList<>();
		while (true) {
			list.add(new Assignment(Main.inputString(sc, "Enter title: "),
					Main.inputString(sc, "Enter description: "),
					Main.inputDate(sc, "Enter submission date: "),
					Main.inputInt(sc, "Enter oral mark: "),
					Main.inputInt(sc, "Enter total mark: ")));
			System.out.printf("Do you want to add a new Assignment(Y/n)? ");
			if (!Main.yes(sc)) {
				break;
			}
		}
		System.out.print("Thank you. Press Enter to return to main menu.");
		System.in.read();
		return list;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getSubDateTime() {
		return subDateTime;
	}

	public void setSubDateTime(LocalDate subDateTime) {
		this.subDateTime = subDateTime;
	}

	public int getOralMark() {
		return oralMark;
	}

	public void setOralMark(int oralMark) {
		this.oralMark = oralMark;
	}

	public int getTotalMark() {
		return totalMark;
	}

	public void setTotalMark(int totalMark) {
		this.totalMark = totalMark;
	}

	@Override
	public String toString() {
		return "Assignment{" + "title=" + title + ", description=" + description + ", subDateTime=" + subDateTime + ", oralMark=" + oralMark + ", totalMark=" + totalMark + '}';
	}


}
