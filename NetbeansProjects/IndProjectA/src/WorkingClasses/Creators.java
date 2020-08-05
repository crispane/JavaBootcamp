package WorkingClasses;

import BaseClasses.*;
import ExtraClasses.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author f3nix
 */
public class Creators {

	// Creators for Base Class ArrayLists 
	public static List<Item> createCourse(Scanner sc) {
		List<Item> courses = new ArrayList<>();
		while (true) {
			Course course = new Course(Inputs.inputString(sc, "Enter title: "),
					Inputs.inputString(sc, "Enter stream: "),
					Inputs.inputString(sc, "Enter type: "),
					Inputs.inputDate(sc, "Enter start date: [dd/mm/yyyy] "),
					Inputs.inputDate(sc, "Enter end date: [dd/mm/yyyy] "));
			courses.add(course);
			System.out.printf("Do you want to add a new Course? [y/n] ");
			if (!Inputs.yes(sc)) {
				break;
			}
		}
		return courses;
	}

	public static List<Item> createStudent(Scanner sc) {
		List<Item> students = new ArrayList<>();
		while (true) {
			Student student = new Student(Inputs.inputString(sc, "Enter first name: "),
					Inputs.inputString(sc, "Enter last name: "),
					Inputs.inputDate(sc, "Enter Date of Birth: [dd/mm/yyyy] "),
					Inputs.inputMoney(sc, "Enter tuition fees: "));
			students.add(student);
			System.out.printf("Do you want to add a new Student? [y/n] ");
			if (!Inputs.yes(sc)) {
				break;
			}
		}
		return students;
	}

	public static List<Item> createTrainer(Scanner sc) {
		List<Item> trainers = new ArrayList<>();
		while (true) {
			Trainer trainer = new Trainer(Inputs.inputString(sc, "Enter first name: "),
					Inputs.inputString(sc, "Enter last name: "),
					Inputs.inputString(sc, "Enter subject: "));
			trainers.add(trainer);
			System.out.printf("Do you want to add a new Trainer? [y/n] ");
			if (!Inputs.yes(sc)) {
				break;
			}
		}
		return trainers;
	}

	public static List<Item> createAssignment(Scanner sc) {
		List<Item> assignments = new ArrayList<>();
		while (true) {
			Assignment assignment = new Assignment(Inputs.inputString(sc, "Enter title: "),
					Inputs.inputString(sc, "Enter description: "),
					Inputs.inputDate(sc, "Enter submission date: [dd/mm/yyyy]"));
//					Inputs.inputInt(sc, "Enter oral mark: "),
//					Inputs.inputInt(sc, "Enter total mark: "));
			assignments.add(assignment);
			System.out.printf("Do you want to add a new Assignment? [y/n] ");
			if (!Inputs.yes(sc)) {
				break;
			}
		}
		return assignments;
	}

	// A polymorphic method to create Lists of ItemLists 
	public static List<Item> addSourcesToTarget(String sourceType, String targetType, Scanner sc, List<Item> source, List<Item> target) {
		List<Item> returnList = new ArrayList<>();
		int i, j;
		while (true) { 														// Select target Item.
			Printers.clearScreen();
			i = 0;
			System.out.println("Select " + targetType + ":");
			for (Item targetItem : target) {
				i++;
				System.out.println(i + ". " + targetItem.getName());
			}
			System.out.println("0. Back");
			int targetChoice = Inputs.inputChoice(sc, target.size());
			if (targetChoice == 0) {
				break;
			}
			ItemList<Item, Item> sourcesInTarget = new ItemList<>();
			while (true) { 													// Select sources Items.
				j = 0;
				System.out.println();
				System.out.println("Select " + sourceType + " to add:");
				for (Item sourceItem : source) {
					j++;
					System.out.println(j + ". " + sourceItem.getName());
				}
				System.out.println("0. Back");
				int sourceChoice = Inputs.inputChoice(sc, source.size());
				if (sourceChoice == 0) {
					break;
				}
				sourcesInTarget.getList().add(source.get(sourceChoice - 1)); // Selections are passed to an ItemList *sourcesInTarget*.
				sourcesInTarget.setOwner(target.get(targetChoice - 1));
				System.out.print("Add another " + sourceType + " to " + targetType + "? [y/n] ");
				if (!Inputs.yes(sc)) {
					break;
				}
			}
			if (!sourcesInTarget.getList().isEmpty()) {
				returnList.add(sourcesInTarget);							// all created *sourcesInTarget* are bundled to a *returnList* and returned.
			}
		}
		return returnList;
	}

	// Specialised method to create a List of students that are in multiple Courses.
	public static List<Item> studentsInMultipleCourses(List<Item> students, List<Item> studentsPerCourse) {
		List<Item> returnList = new ArrayList<>();
		for (Item student : students) {
			ItemList<Item, Item> studentWithCourses = new ItemList<>();
			studentWithCourses.setOwner(student); 							// A student is passed to an ItemList *studentWithCourses* as the *Owner*.
			for (Item itemlist : studentsPerCourse) {
				ItemList castlist = (ItemList) itemlist;
				if (castlist.getList().contains(student)) {				    // Then they are checked against previously created *studentsPerCourse* ItemList.
					studentWithCourses.getList().add(castlist.getOwner());  // Matched courses are finally passed to *studentWithCourses* as the *returnList* of the *Owner*.
				}
			}
			if (studentWithCourses.getList().size() > 1) { 					// All *studentWithCourses* that have more than one course are bundled and returned.
				returnList.add(studentWithCourses); 									
			}
		}
		return returnList;

	}

}
