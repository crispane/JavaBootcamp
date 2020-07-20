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
public class Course {
	String title;
	String stream;
	String type;
	LocalDate startDate;
	LocalDate endDate;

	public Course() {
	}

	public Course(String title, String stream, String type, LocalDate startDate, LocalDate endDate) {
		this.title = title;
		this.stream = stream;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public static List<Course> create(Scanner sc) throws IOException {
		List<Course> list = new ArrayList<>();
		while (true) {
			list.add(new Course(Main.inputString(sc, "Enter title: "),
					Main.inputString(sc, "Enter stream: "),
					Main.inputString(sc, "Enter type: "),
					Main.inputDate(sc, "Enter start date: "),
					Main.inputDate(sc, "Enter end date: ")));
			System.out.printf("Do you want to add a new Course(Y/n)? ");
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

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Course{" + "title=" + title + ", stream=" + stream + ", type=" + type + ", startDate=" + startDate + ", endDate=" + endDate + '}';
	}
	
}
