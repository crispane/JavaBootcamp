package WorkingClasses;

import BaseClasses.*;
import ExtraClasses.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class Creators {

	// A polymorphic method that returns a List of *ItemList*. It combines Source Items with a target Item and keeps them in an *ItemList*. 
	public static List<Item> combination(String sourceType, String targetType, Scanner sc, List<Item> source, List<Item> target) {
		List<Item> returnList = new ArrayList<>();
		int i, j;
		while (true) {
			Printers.clearScreen();
			i = 0;
			System.out.println("Select " + targetType + ":");				// Print a list of target Items.
			for (Item targetItem : target) {
				i++;
				System.out.println(i + ". " + targetItem.getName());
			}
			System.out.println("0. Back");
			int targetChoice = Inputs.inputChoice(sc, target.size());		// Select one.
			if (targetChoice == 0) {
				break;
			}
			ItemList<Item, Item> sourcesInTarget = new ItemList<>();		// Create a ItemList to hold sources and target.
			List<Item> sourceIterator = new ArrayList<>();
			for (Item item : source) {										// Create a deep copy of source to iterate with.
				sourceIterator.add(item);									// This copy is needed because items are removed after
			}																// selection. Iterator is reset for the next target.
			while (true) {
				j = 0;
				System.out.println();
				System.out.println("Select " + sourceType + " to add:");
				for (Item sourceItem : sourceIterator) {					// Print available sources.
					j++;
					System.out.println(j + ". " + sourceItem);
				}
				System.out.println("0. Back");
				int sourceChoice = Inputs.inputChoice(sc, source.size());	// Select source Item.	
				if (sourceChoice == 0) {
					break;
				}
				sourcesInTarget.setOwner(target.get(targetChoice - 1));		// Set target as *Owner* for to an ItemList *sourcesInTarget*.
				sourcesInTarget.getList().add(source.get(sourceChoice - 1));// Selected source is passed in the list of of *sourcesInTarget*.
				sourceIterator.remove(sourceChoice - 1);					// Selected source is temporarily removed from iterator.
				System.out.println();
				System.out.println("-- " + sourceType + " added.");
				System.out.println();
			}
			if (!sourcesInTarget.getList().isEmpty()) {						// All created *sourcesInTarget*, if they are not empty,
				returnList.add(sourcesInTarget);							// are bundled to a *returnList* and returned.
			}
		}
		return returnList;
	}

	// Specialised method to create a List of students that are in multiple Courses.
	public static List<Item> studentsInMultipleCourses(List<Item> students, List<Item> studentsPerCourse) {
		List<Item> returnList = new ArrayList<>();
		for (Item student : students) {										// Iterate all students.
			ItemList<Item, Item> studentWithCourses = new ItemList<>();
			studentWithCourses.setOwner(student); 							// Firstly, a student is passed to an ItemList *studentWithCourses* as the *Owner*.
			for (Item itemlist : studentsPerCourse) {
				ItemList castlist = (ItemList) itemlist;
				if (castlist.getList().contains(student)) {				    // Then they are checked against previously created *studentsPerCourse* ItemList.
					studentWithCourses.getList().add(castlist.getOwner());  // Matched courses are passed to *studentWithCourses*.
				}
			}
			if (studentWithCourses.getList().size() > 1) { 					// Finally, all *studentWithCourses* that have more than one course are bundled and returned.
				returnList.add(studentWithCourses);
			}
		}
		return returnList;
	}

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
					Inputs.inputDate(sc, "Enter submission date: [dd/mm/yyyy] "));
			assignments.add(assignment);
			System.out.printf("Do you want to add a new Assignment? [y/n] ");
			if (!Inputs.yes(sc)) {
				break;
			}
		}
		return assignments;
	}

	public static List<Item> studentsWithAssignments(Scanner sc, List<Item> studentsWithCourses, List<Item> coursesWithAssignments) {
		List<Item> returnList = new ArrayList<>();
		for (Item student : studentsWithCourses) {
			ItemList castStudent = (ItemList) student;
			for (Item course : coursesWithAssignments) {
				ItemList castCourse = (ItemList) course;
				if (castStudent.getList().contains(castCourse.getOwner())) {
					ItemList<Item, Item> studentWithAsmts = new ItemList<>();
					System.out.println("Choose assignments for " + castStudent.getName() + " in course " + castCourse.getName());
					ArrayList<Item> castAssignments = (ArrayList<Item>) castCourse.getList();
					while (true) {
						int i = 0;
						for (Item assignment : castAssignments) {
							i++;
							System.out.println(i + ". " + assignment.getName());
						}
						int choice = Inputs.inputChoice(sc, castAssignments.size());
						if (choice == 0) {
							break;
						}
						studentWithAsmts.getList().add(castAssignments.get(choice - 1)); // Selections are passed to an ItemList *studentWithAsmts*.
						studentWithAsmts.setOwner(castStudent.getOwner());
					}
					returnList.add(studentWithAsmts);
				}
			}

		}
		return returnList;
	}

}
