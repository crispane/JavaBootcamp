package WorkingClasses;

import BaseClasses.Assignment;
import ExtraClasses.*;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class Printers {

	public static void subWeek(Scanner sc, List<Item> assignmentsPerStudent) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE, dd-MM-yyyy");
		LocalDate checkDate = Inputs.inputDate(sc, "Enter a date to check for assignment deadlines: [DD/MM/YY] ");// Enter a checkDate.
		LocalDate weekStartDate = checkDate.with(DayOfWeek.MONDAY);												// Monday of CheckdDate.
		LocalDate weekEndDate = checkDate.with(DayOfWeek.FRIDAY);												// Friday of CheckdDate.
		for (Item studentWithAssmts : assignmentsPerStudent) { 													// Go through the list of student assignments.
			ItemList castStudentWithAssmnts = (ItemList) studentWithAssmts;										// Downcast studentWithAssignments.
			System.out.println();
			System.out.println("Assignment deadlines for " + castStudentWithAssmnts.getName() + " from " + weekStartDate.format(formatter) + " until " + weekEndDate.format(formatter) + ":");
			for (int i = 0; i < castStudentWithAssmnts.getList().size(); i++) { 								// Iterate on his assignment list.
				Assignment castAssignment = (Assignment) castStudentWithAssmnts.getList().get(i); 				// Downcast current assignment.
				if(castAssignment.getSubmissionDate().isAfter(weekStartDate.minusDays(1)) && castAssignment.getSubmissionDate().isBefore(weekEndDate.plusDays(3))) {
					System.out.println(castAssignment); 														// Print assignment if it is in the same calendar week.
																												// plusDays(3) in line 30 mitigate for assignments that may have a submission date on the weekend.
				}
			}
		}
		Printers.pressEnterToReturn("Press Enter to return");
	}

	// OLD VERSION OF SUBMISSION WEEK (without checkDate.with.(DayOfWeek.MONDAY)
//	public static void submissionWeek(Scanner sc, List<Item> assignmentsPerStudent) {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE, dd-MM-yyyy");
//		LocalDate checkDate = Inputs.inputDate(sc, "Enter a date to check for assignment deadlines: [DD/MM/YY] ");// Enter a checkDate.
//		int distanceFromFriday = checkDate.getDayOfWeek().getValue() - DayOfWeek.FRIDAY.getValue(); 			// How many days is checkDate away from a Friday.
//		if (distanceFromFriday > 0) {
//			checkDate = checkDate.minusDays(distanceFromFriday); 												// Move checkDate on the Friday of same Week.
//		} else {
//			checkDate = checkDate.plusDays(-distanceFromFriday); 												// Move checkDate on the Friday of same Week.
//		}
//		for (Item studentWithAssmts : assignmentsPerStudent) { 													// Go through the list of student assignments.
//			ItemList castStudentWithAssmnts = (ItemList) studentWithAssmts;										// Downcast studentWithAssignments.
//			System.out.println();
//			System.out.println("Assignment deadlines for " + castStudentWithAssmnts.getName() + " from " + checkDate.minusDays(4).format(formatter) + " until " + checkDate.format(formatter) + ":");
//			for (int i = 0; i < castStudentWithAssmnts.getList().size(); i++) { 								// Iterate on his assignment list.
//				Assignment castAssignment = (Assignment) castStudentWithAssmnts.getList().get(i); 				// Downcast current assignment.
//				long dateComparison = ChronoUnit.DAYS.between(castAssignment.getSubmissionDate(), checkDate); 	// Compare assignment date with checkDate.
//				if (dateComparison > -5 && dateComparison <= 2) {												// Limits mitigate for assignments that may have a submission date on the weekend.
//					System.out.println(castAssignment); 														// Print assignment.
//				}
//			}
//		}
//		Printers.pressEnterToReturn("Press Enter to return");
//	}

	// Prints Lists that contain an ItemList
	public static <T> void printItemLists(String itemType, List<T> list) {
		for (T itemlist : list) {
			ItemList castlist = (ItemList) itemlist;
			System.out.println();
			System.out.println(itemType + "s in " + castlist.getOwner() + ": ");
			System.out.println();
			for (int i = 0; i < castlist.getList().size(); i++) {
				System.out.println("-- " + ((Item) castlist.getList().get(i)).getName());
			}
		}
		System.out.println();
		pressEnterToReturn("Press Enter to return ");
	}

	// Prints simple Lists
	public static <T> void printList(String itemType, List<T> list) {
		System.out.println("All " + itemType + "s: ");
		System.out.println();
		list.forEach(item -> {
			System.out.println(item);
		});
		System.out.println();
		pressEnterToReturn("Press Enter to return ");
	}

	// Clears the screen (Doesn't work for NetBeans Output. For terminals and command prompts only.)
	public static void clearScreen() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {				// for Windows systems
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\u001b[H\u001b[2J");								// for Unix systems
				System.out.flush();
			}
		} catch (IOException | InterruptedException ex) {
			System.out.println("Screen couldn't be cleared. Sorry!");
		}
	}

	// Pauses the program until Enter key is pressed.
	public static void pressEnterToReturn(String message) {
		try {
			System.out.print("::" + message);
			System.in.read();
			//System.in.skip(System.in.available());
		} catch (IOException ex) {
			System.out.println("IO Error!");
		}
	}

	public static void ExercisesIndex() {
		System.out.println("*** Bootcamp Registry Program / Exercises Index ***");
		System.out.println();
		System.out.println("* Question 1: A list of all the students");
		System.out.println("	Steps: 3. Students > 1. View Students");
		System.out.println();
		System.out.println("* Question 2: A list of all the trainers");
		System.out.println("	Steps: 2. Trainers > 1. View Trainers");
		System.out.println();
		System.out.println("* Question 3: A list of all the assignments");
		System.out.println("	Steps: 4. Assignments > 1. View Assignments");
		System.out.println();
		System.out.println("* Question 4: A list of all the courses");
		System.out.println("	Steps: 1. Courses > 1. View Courses");
		System.out.println();
		System.out.println("* Question 5: All the students per course");
		System.out.println("	Steps: 3. Students > 3. Add Students to Courses > 4. View Students Per Course");
		System.out.println();
		System.out.println("* Question 6: All the trainers per course");
		System.out.println("	Steps: 2. Trainers > 3. Add Trainers to Courses > 4. View Trainers Per Course");
		System.out.println();
		System.out.println("* Question 7: All the assignments per course");
		System.out.println("	Steps: 4. Assignments > 3. Add Assignments to Courses > 4. View Assignments Per Course");
		System.out.println();
		System.out.println("* Question  8: All the assignments per student");
		System.out.println("	Steps: 4. Assignments > 5. Add Assignments to Students > 6. View Assignments Per Student");
		System.out.println("		NOTE: \"3. Add Assignments to Courses\" must be completed first");
		System.out.println();
		System.out.println("* Question  9: A list of students that belong to more than one course");
		System.out.println("	Steps: 3. Students > 5. View Students with Multiple Courses");
		System.out.println("		NOTE: \"3. Add Students to Courses\" must be completed first.");
		System.out.println();
		System.out.println("* Question 10: Look for assignment submission dates");
		System.out.println("	Steps: 4. Assignments > 7. Check for Deadlines");
		System.out.println("		NOTE: \"5. Add Assignments to Students\" must be completed first.");
		System.out.println();
		Printers.pressEnterToReturn("Press Enter to return");

	}
}
