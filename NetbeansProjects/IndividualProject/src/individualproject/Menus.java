/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author f3nix
 */
public class Menus {

	public static void mainMenu(){//(Scanner sc, List<Course> courses, List<Student> students, List<Trainer> trainers, List<Assignment> assignments) {
		Scanner sc = new Scanner(System.in);
		List<Course> courses = new ArrayList<>();
		List<Assignment> assignments = new ArrayList<>();
		List<Student> students = new ArrayList<>();
		List<Trainer> trainers = new ArrayList<>();
		List<List<Student>> studentsInCourses = new ArrayList<>();
		while (true) {
		clearScreen();
		System.out.println("*** Bootcamp Registry Program ***");
		System.out.println("1. Create Courses");
		System.out.println("2. Create Students");
		System.out.println("3. Create Assignments");
		System.out.println("4. Create Trainers");
		System.out.println("---------------------------------");
		System.out.println("5. Assign Students to Courses");
		System.out.println("6. Assign Assignments to Students");
		System.out.println("7. Assign Trainers to Courses");
		System.out.println("---------------------------------");
		System.out.println("0. Exit Program");
		int choice = inputChoice(sc, 7);
		switch (choice) {
			case 1:
				clearScreen();
				courses = Database.createCourse(sc);
				System.out.println(courses);
				break;
			case 2:
				clearScreen();
				students = Database.createStudent(sc);
				System.out.println(students);
				break;
			case 3:
				clearScreen();
				assignmentMenu(sc, courses, students, trainers, assignments);
				break;
			case 4:
				clearScreen();
				break;
			case 5:
				System.out.println(courses);
				clearScreen();
				studentsInCourses = Database.studentsInCourses(sc, students, courses);
				break;
			case 6:
				break;
			case 7:
				break;
			case 0:
				System.exit(0);
				break;
			default:
				break;
		}
	}
		}

	public static void courseMenu(Scanner sc, List<Course> courses, List<Student> students, List<Trainer> trainers, List<Assignment> assignments) {
		System.out.println("1. View Courses");
		System.out.println("2. Add Courses");
		System.out.println("3. Edit Courses");
		System.out.println("0. Return to Main Menu");

		int choice = inputChoice(sc, 3);
		switch (choice) {
			case 1:
				clearScreen();
				break;
			case 2:
				while (true) {
					clearScreen();
					courses = Database.createCourse(sc);
				}
			case 3:
				clearScreen();
				break;
			case 0:
				break;
			default:
				break;
		}

	}

	public static void trainerMenu(Scanner sc, List<Course> courses, List<Student> students, List<Trainer> trainers, List<Assignment> assignments) {
		System.out.println("1. View Trainers");
		System.out.println("2. Add Trainers");
		System.out.println("3. Edit Trainers");
		System.out.println("4. Assign to Course");
		System.out.println("0. Return to Main Menu");
		int choice = inputChoice(sc, 4);
		switch (choice) {
			case 1:
				clearScreen();
				break;
			case 2:
				while (true) {
					clearScreen();
					trainers.add(Trainer.create(sc));
					System.out.printf("Do you want to add a new Trainer (Y/n)? ");
					if (!Main.yes(sc)) {
						trainerMenu(sc, courses, students, trainers, assignments);
					}
					break;
				}
			case 3:
				clearScreen();
				break;
			case 4:
				clearScreen();
				break;
			case 0:
				break;
			default:
				break;
		}
	}

	public static void studentMenu(Scanner sc, List<Course> courses, List<Student> students, List<Trainer> trainers, List<Assignment> assignments) {
		while (true) {
			System.out.println("1. View Students");
			System.out.println("2. Add Students");
			System.out.println("3. Edit Students");
			System.out.println("4. Assign to Course");
			System.out.println("0. Return to Main Menu");
			int choice = inputChoice(sc, 4);
			if (choice == 0) {
				break;
			}
			switch (choice) {
				case 1:
					clearScreen();
					break;
				case 2:
				case 3:
					clearScreen();
					break;
				case 4:
					clearScreen();
					Database.studentsInCourses(sc, students, courses);
					break;
				default:
					break;
			}
		}
	}

	public static void assignmentMenu(Scanner sc, List<Course> courses, List<Student> students, List<Trainer> trainers, List<Assignment> assignments) {
		System.out.println("1. View assignments");
		System.out.println("2. Add assignments");
		System.out.println("3. Edit assignments");
		System.out.println("4. Assign to student");
		System.out.println("0. Return to Main Menu");
		int choice = inputChoice(sc, 4);
		switch (choice) {
			case 1:
				clearScreen();
				break;
			case 2:
				while (true) {
					clearScreen();
					assignments.add(Assignment.create(sc));
					System.out.printf("Do you want to add a new Assignment(Y/n)? ");
					if (!Main.yes(sc)) {
						assignmentMenu(sc, courses, students, trainers, assignments);
					}
					break;
				}
				break;
			case 3:
				clearScreen();
				break;
			case 4:
				clearScreen();
				break;
			case 0:
				break;
			default:
				break;
		}
	}

	public static int inputChoice(Scanner sc, int maxChoice) {
		int choice;
		while (true)
			try {
			System.out.print("Enter choice Number: ");
			choice = sc.nextInt();
			if (choice >= 0 && choice <= maxChoice) {
				break;
			} else {
				System.out.println("Choice must be between 0 and " + maxChoice + ".");
			}
		} catch (InputMismatchException e) {
			System.out.println("Number must be an integer.");
			sc.next();
		}
		return choice;
	}

//	public static void initialChoice(Scanner sc, int choice) throws IOException {
//		List<Student> students = new ArrayList<>();
//		List<Course> courses = new ArrayList<>();
//		switch (choice) {
//			case 1:
//				Menus.clearScreen();
//				students.add(Student.create(sc));
//				break;
//
//			case 2:
//				Menus.clearScreen();
//				Trainer.create(sc);
//				break;
//			case 3:
//				Menus.clearScreen();
//				courses.add(Course.create(sc));
//				break;
//			case 4:
//				Menus.clearScreen();
//				Assignment.create(sc);
//				break;
//			case 5:
//				Menus.clearScreen();
//				break;
//			case 0:
//				System.exit(0);
//			default:
//				break;
//		}
//	}
	public static void clearScreen() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (IOException | InterruptedException ex) {
		}
	}

	public static void pressEnterToReturn() throws IOException {
		System.out.print("Thank you. Press Enter to return to main menu.");
		System.in.read();
	}

}
