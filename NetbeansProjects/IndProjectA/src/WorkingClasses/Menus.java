package WorkingClasses;

import ExtraClasses.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author f3nix
 */
public class Menus {

	// Base Menu
	public static void BootCamp() {
		try {
			Scanner sc = new Scanner(System.in);
			List<Item> courses = new ArrayList<>();
			List<Item> assignments = new ArrayList<>();
			List<Item> students = new ArrayList<>();
			List<Item> trainers = new ArrayList<>();
			List<Item> studentsPerCourse = new ArrayList<>();
			List<Item> trainersPerCourse = new ArrayList<>();
			List<Item> assignmentsPerCourse = new ArrayList<>();
			List<Item> assignmentsPerStudent = new ArrayList<>();
			// Unfortunately methods need to return one thing only. 
			// In the submenus that need to return 2 or more items, I packed the items in a list and returned that list.
			// This list is then passed to a *bufferlist*. (See lines 40 and 51)
			// A *bufferlist* is necessary, in order to distribute returned values from the menus.
			List<List<Item>> bufferlist = new ArrayList<>();
			while (true) {
				Printers.clearScreen();
				System.out.println("*** Bootcamp Registry Program ***");
				System.out.println("1. Courses");
				System.out.println("2. Trainers");
				System.out.println("3. Students");
				System.out.println("4. Assignments");
				System.out.println("0. Exit Program");
				int choice = Inputs.inputChoice(sc, 4);
				switch (choice) {
					case 1:
						Printers.clearScreen();
						bufferlist = courseMenu(sc, courses);
						courses = bufferlist.get(0);
						break;
					case 2:
						Printers.clearScreen();
						bufferlist = trainerMenu(sc, trainers, courses, trainersPerCourse);
						trainers = bufferlist.get(0);
						trainersPerCourse = bufferlist.get(1);
						break;
					case 3:
						Printers.clearScreen();
						bufferlist = studentMenu(sc, students, courses, studentsPerCourse);
						students = bufferlist.get(0);
						studentsPerCourse = bufferlist.get(1);
						break;
					case 4:
						Printers.clearScreen();
						bufferlist = assignmentMenu(sc, assignments, courses, assignmentsPerCourse, students, assignmentsPerStudent);
						assignments = bufferlist.get(0);
						assignmentsPerCourse = bufferlist.get(1);
						assignmentsPerStudent = bufferlist.get(2);
						break;
					case 0:
						System.exit(0);
						break;
					default:
						break;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("");
		}
	}

	// Class submenus
	public static List<List<Item>> courseMenu(Scanner sc, List<Item> courses) {
		List<List<Item>> list = new ArrayList<>();
		outerloop:
		while (true) {
			Printers.clearScreen();
			System.out.println("1. View Courses");
			System.out.println("2. Add Courses");
			System.out.println("0. Return to Main Menu");
			int choice = Inputs.inputChoice(sc, 2);
			switch (choice) {
				case 1:
					Printers.clearScreen();
					Printers.printList("course", courses);
					break;
				case 2:
					Printers.clearScreen();
					courses.addAll(Creators.createCourse(sc));
					break;
				case 0:
					break outerloop;
				default:
					break;
			}
		}
		list.add(courses);
		return list;
	}

	public static List<List<Item>> trainerMenu(Scanner sc, List<Item> trainers, List<Item> courses, List<Item> trainersPerCourse) {
		List<List<Item>> list = new ArrayList<>();
		outerloop:
		while (true) {
			Printers.clearScreen();
			System.out.println("1. View Trainers");
			System.out.println("2. Add Trainers");
			System.out.println("3. Add Trainers To Courses");
			System.out.println("4. View Trainers Per Course");
			System.out.println("0. Return to Main Menu");
			int choice = Inputs.inputChoice(sc, 4);
			switch (choice) {
				case 1:
					Printers.clearScreen();
					Printers.printList("trainer", trainers);
					break;
				case 2:
					while (true) {
						Printers.clearScreen();
						trainers.addAll(Creators.createTrainer(sc));
						break;
					}
					break;
				case 3:
					Printers.clearScreen();
					trainersPerCourse = Creators.addSourceToTarget("trainer", "course", sc, trainers, courses);
					break;
				case 4:
					Printers.clearScreen();
					Printers.printItemLists("Trainer", trainersPerCourse);
					break;
				case 0:
					break outerloop;
				default:
					break;
			}
		}
		list.add(trainers);
		list.add(trainersPerCourse);
		return list;
	}

	public static List<List<Item>> studentMenu(Scanner sc, List<Item> students, List<Item> courses, List<Item> studentsPerCourse) {
		List<List<Item>> list = new ArrayList<>();
		outerloop:
		while (true) {
			Printers.clearScreen();
			System.out.println("1. View Students");
			System.out.println("2. Add Students");
			System.out.println("3. Add Students to Courses");
			System.out.println("4. View Students per Course");
			System.out.println("5. View Courses per Student");
			System.out.println("0. Return to Main Menu");
			int choice = Inputs.inputChoice(sc, 5);
			switch (choice) {
				case 1:
					Printers.clearScreen();
					Printers.printList("student", students);
					break;
				case 2:
					Printers.clearScreen();
					students.addAll(Creators.createStudent(sc));
					break;
				case 3:
					Printers.clearScreen();
					studentsPerCourse = Creators.addSourceToTarget("student", "course", sc, students, courses);
					break;
				case 4:
					Printers.clearScreen();
					Printers.printItemLists("Student", studentsPerCourse);
					break;
				case 5:
					List<Item> coursesPerStudent = new ArrayList<>();
					coursesPerStudent = Creators.studentsInMultipleCourses(students, courses, studentsPerCourse);
					Printers.printItemLists("course", coursesPerStudent);
					break;
				case 0:
					break outerloop;
				default:
					break;
			}
		}
		list.add(students);
		list.add(studentsPerCourse);
		return list;
	}

	public static List<List<Item>> assignmentMenu(Scanner sc, List<Item> assignments, List<Item> courses, List<Item> assignmentsPerCourse, List<Item> students, List<Item> assignmentsPerStudent) {
		List<List<Item>> list = new ArrayList<>();
		outerloop:
		while (true) {
			Printers.clearScreen();
			System.out.println("1. View assignments");
			System.out.println("2. Add assignments");
			System.out.println("3. Add Assignments to Course");
			System.out.println("4. View Assignments per Course");
			System.out.println("5. Add Assignments to student");
			System.out.println("6. View Assignments per Student");
			System.out.println("0. Return to Main Menu");
			int choice = Inputs.inputChoice(sc, 6);
			switch (choice) {
				case 1:
					Printers.clearScreen();
					Printers.printList("assignment", assignments);
					break;
				case 2:
					while (true) {
						Printers.clearScreen();
						assignments.addAll(Creators.createAssignment(sc));
						break;
					}
					break;
				case 3:
					Printers.clearScreen();
					assignmentsPerCourse= Creators.addSourceToTarget("assignment", "course", sc, assignments, courses);
					break;
				case 4:
					Printers.clearScreen();
					Printers.printItemLists("Assignment", assignmentsPerCourse);
					break;
				case 5:
					Printers.clearScreen();
					assignmentsPerStudent = Creators.addSourceToTarget("assignment", "student", sc, assignments, students);
					break;
				case 6:
					Printers.clearScreen();
					Printers.printItemLists("Assignment", assignmentsPerStudent);
					break;
				case 0:
					break outerloop;
				default:
					break;
			}
		}
		list.add(assignments);
		list.add(assignmentsPerCourse);
		list.add(assignmentsPerStudent);
		return list;
	}
}
