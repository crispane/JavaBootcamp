package WorkingClasses;

import BaseClasses.*;
import ExtraClasses.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class Creators {

	// A polymorphic method that returns a List of *ItemList*. It combines Source Items with a target Item and keeps them in an *ItemList*. 
	public static List<Item> combination(String sourceType, String targetType, Scanner sc, List<Item> source, List<Item> target, List<Item> previousList) {
		List<Item> returnList = new ArrayList<>();
		int i, j;
		while (true) {
			Printers.clearScreen();
			i = 0;
			System.out.println("Select " + targetType + ":");						// Print a list of target Items.
			System.out.println();
			for (Item targetItem : target) {
				i++;
				System.out.printf("%3d. " + targetItem.getName() + "\n", i);
			}
			System.out.printf("%3d. Back\n", 0);
			int targetChoice = Inputs.inputChoice(sc, target.size());				// Select one.
			if (targetChoice == 0) {
				break;
			}
			ItemList<Item, Item> sourcesInTarget = new ItemList<>();				// Create a ItemList to hold sources and target.
			List<Item> sourceIterator = new LinkedList<>();							// LinkedList that will iterate and shrink as selections are made. 
			for (Item item : source) {												// Create a deep copy of source to the Iterator.
				sourceIterator.add(item);
			}
			sourceIterator.removeAll(previousList);									// removes all items that already exist in the previously created list.
			while (true) {
				j = 0;
				Printers.clearScreen();
				System.out.println();
				System.out.println("Select " + sourceType + " to add to " + target.get(targetChoice - 1).getName() + ":");
				System.out.println();
				for (Item sourceItem : sourceIterator) {							// Print available sources.
					j++;
					System.out.printf("%3d. " + sourceItem + "\n", j);
				}
				System.out.printf("%3d. Back\n", 0);
				int sourceChoice = Inputs.inputChoice(sc, sourceIterator.size());	// Select source Item.	
				if (sourceChoice == 0) {
					break;
				}
				sourcesInTarget.setOwner(target.get(targetChoice - 1));				// Set target as *Owner* for to an ItemList *sourcesInTarget*.
				sourcesInTarget.getList().add(sourceIterator.get(sourceChoice - 1));// Selected source is passed in the list of of *sourcesInTarget*.
				sourceIterator.remove(sourceChoice - 1);							// Selected source is temporarily removed from iterator.
				System.out.println();
				System.out.println("-- " + sourceType + " added.");
				System.out.println();
			}
			if (!sourcesInTarget.getList().isEmpty()) {								// All created *sourcesInTarget*, if they are not empty,
				returnList.add(sourcesInTarget);									// are bundled to a *returnList* and returned.
			}
		}
		return returnList;
	}

	// Specialised method to create a List of students with their Courses. If *multipleCourses* is true it only picks the ones with more that one course.
	public static List<Item> studentsWithCourses(boolean multipleCourses, List<Item> students, List<Item> studentsPerCourse) {
		List<Item> returnList = new ArrayList<>();
		for (Item student : students) {												// Iterate all students.
			ItemList<Item, Item> studentWithCourses = new ItemList<>();
			studentWithCourses.setOwner(student); 									// At First, a studentChoice is passed to an ItemList *studentWithCourses* as the *Owner*.
			for (Item course : studentsPerCourse) {									// for each course that contains a list of students
				ItemList castCourse = (ItemList) course;
				if (castCourse.getList().contains(student)) {						// check list if studentChoice is there.
					studentWithCourses.getList().add(castCourse.getOwner());		// Matched courses are passed to *studentWithCourses*.
				}
			}
			if (multipleCourses) {													// if multipleCourses is true
				if (studentWithCourses.getList().size() > 1) { 						// all *studentWithCourses* that have more than one course are bundled and returned.
					returnList.add(studentWithCourses);
				}
			} else if (!(studentWithCourses.getList().isEmpty())) {					// else return a list that contains all students with one course and above.
				returnList.add(studentWithCourses);
			}
		}
		return returnList;
	}

	// Students are assigned with assignments that are only available to their courses.
	public static List<Item> studentsWithAssignments(Scanner sc, List<Item> coursesWithAssignments, List<Item> studentsWithCourses, List<Item> previousList) {
		System.out.println("**** CAUTION: Make sure you have added students and assignments to their courses first. ****");
		Printers.pressEnterToReturn("Press Enter to continue");
		List<Item> returnList = new ArrayList<>();
		int i, j;
		while (true) {
			Printers.clearScreen();
			i = 0;
			System.out.println("Select Student:");
			System.out.println();
			for (Item student : studentsWithCourses) {												// Print Students that are registered in a course.
				i++;
				System.out.printf("%3d. " + student.getName() + "\n", i);
			}
			System.out.printf("%3d. Back\n", 0);
			int studentChoice = Inputs.inputChoice(sc, studentsWithCourses.size());					// Select one.
			if (studentChoice == 0) {
				break;
			}
			ItemList<Item, Item> studentWithAsmts = new ItemList<>();								// Create a ItemList to hold the student with his assignments.
			for (Item course : coursesWithAssignments) {											// Iterate through the list of courses that hold assignments.
				ItemList castCourse = (ItemList) course;											// Downcast course.
				ItemList castStudentCourses = (ItemList) studentsWithCourses.get(studentChoice - 1);// Downcast the course list of the selected student.
				if (castStudentCourses.getList().contains(castCourse.getOwner())) {					// if student is registered in current course...
					Printers.clearScreen();
					System.out.println("Select assignments for " + studentsWithCourses.get(studentChoice - 1).getName() + " in course " + castCourse.getOwner().getName());
					System.out.println();
					@SuppressWarnings("unchecked")
					LinkedList<Item> castAssignments = (LinkedList<Item>) castCourse.getList();
					while (true) {
						Printers.clearScreen();
						j = 0;
						for (Item assignment : castAssignments) {									// ...print available assignments.
							Assignment castAssignment = (Assignment) assignment;
							j++;
							System.out.printf("%3d. " + castAssignment + "\n", j);
						}
						System.out.printf("%3d. Back\n", 0);
						int choice = Inputs.inputChoice(sc, castAssignments.size());					// Pick an assignment.
						if (choice == 0) {
							break;
						}
						studentWithAsmts.getList().add(castAssignments.get(choice - 1)); 			// Pass selection to an ItemList *studentWithAsmts*.
						castAssignments.remove(choice - 1);											// Remove assignment from options.
						studentWithAsmts.setOwner(castStudentCourses.getOwner());					// Set student as owner of ItemList.	
					}
				}
			}
			returnList.add(studentWithAsmts);
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
}
