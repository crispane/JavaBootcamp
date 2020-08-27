package WorkingClasses;

import BaseClasses.*;
import ExtraClasses.Item;
import RunClasses.SyntheticData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class Menus {

	// Base Menu
	public static void BootMenu() {
//		try {
		Scanner sc = new Scanner(System.in);
		List<Item> courses;
		List<Item> assignments;
		List<Item> students;
		List<Item> trainers;
		List<Item> studentsPerCourse;
		List<Item> coursesPerStudent;
		List<Item> trainersPerCourse;
		List<Item> assignmentsPerCourse;
		List<Item> assignmentsPerStudent;

		Printers.clearScreen();
		System.out.println("   ****************************************************");
		System.out.println("   You are about to start the Bootcamp Registry Program");
		System.out.println("   -- For optimal presentation please use a terminal --");
		System.out.println();
		System.out.print("Would you like to populate lists with Synthetic Data? [y/n] ");
		if (Inputs.yes(sc)) {
			courses = SyntheticData.synthCourses();
			students = SyntheticData.synthStudents();
			trainers = SyntheticData.synthTrainers();
			assignments = SyntheticData.synthAssignments();
		} else {
			courses = new ArrayList<>();
			assignments = new ArrayList<>();
			students = new ArrayList<>();
			trainers = new ArrayList<>();
		}
		studentsPerCourse = new ArrayList<>();
		coursesPerStudent = new ArrayList<>();
		trainersPerCourse = new ArrayList<>();
		assignmentsPerCourse = new ArrayList<>();
		assignmentsPerStudent = new ArrayList<>();
		List<List<Item>> bufferlist;
		while (true) {
			Printers.clearScreen();
			System.out.println("*** Bootcamp Registry Program ***");
			System.out.println();
			System.out.println("1. Courses");
			System.out.println("2. Trainers");
			System.out.println("3. Students");
			System.out.println("4. Assignments");
			System.out.println("5. Help");
			System.out.println("0. Exit Program");
			int choice = Inputs.inputChoice(sc, 5);
			switch (choice) {
				case 1:
					Printers.clearScreen();
					courses = courseMenu(sc, courses).get(0);
					break;
				case 2:
					Printers.clearScreen();
					bufferlist = trainerMenu(sc, trainers, courses, trainersPerCourse);
					trainers = bufferlist.get(0);
					trainersPerCourse = bufferlist.get(1);
					break;
				case 3:
					Printers.clearScreen();
					bufferlist = studentMenu(sc, students, courses, studentsPerCourse, coursesPerStudent);
					students = bufferlist.get(0);
					studentsPerCourse = bufferlist.get(1);
					break;
				case 4:
					Printers.clearScreen();
					bufferlist = assignmentMenu(sc, assignments, courses, assignmentsPerCourse, students, assignmentsPerStudent, studentsPerCourse, coursesPerStudent);
					assignments = bufferlist.get(0);
					assignmentsPerCourse = bufferlist.get(1);
					assignmentsPerStudent = bufferlist.get(2);
					break;
				case 5:
					Printers.clearScreen();
					Printers.ExercisesIndex();
					break;
				case 0:
					System.exit(0);
					break;
				default:
					break;
			}
		}
//		} catch (IndexOutOfBoundsException e) {
//			System.out.println("");
//		}
	}

	/* Base Class submenus */
	public static List<List<Item>> courseMenu(Scanner sc, List<Item> courses) {
		List<List<Item>> returnList = new ArrayList<>();
		outerloop:
		while (true) {
			Printers.clearScreen();
			System.out.println("*** Bootcamp Registry Program / Courses ***");
			System.out.println();
			System.out.println("1. View Courses");
			System.out.println("2. Create Courses");
			System.out.println("0. Return to Main Menu");
			int choice = Inputs.inputChoice(sc, 2);
			switch (choice) {
				case 1:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Course List ***");
					System.out.println();
					List<Course> castCourses = new ArrayList<>(); // Downcasting to prepare for print
					for (Item course : courses) {
						castCourses.add((Course) course);
					}
					Printers.printList("course", castCourses);
					break;
				case 2:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Create Courses ***");
					System.out.println();
					courses.addAll(Creators.createCourse(sc));
					break;
				case 0:
					break outerloop;
				default:
					break;
			}
		}
		returnList.add(courses);
		return returnList;
	}

	public static List<List<Item>> trainerMenu(Scanner sc, List<Item> trainers, List<Item> courses, List<Item> trainersPerCourse) {
		List<List<Item>> returnList = new ArrayList<>();
		outerloop:
		while (true) {
			Printers.clearScreen();
			System.out.println("*** Bootcamp Registry Program / Trainers ***");
			System.out.println();
			System.out.println("1. View Trainers");
			System.out.println("2. Create Trainers");
			System.out.println("3. Add Trainers To Courses");
			System.out.println("4. View Trainers Per Course");
			System.out.println("0. Return to Main Menu");
			int choice = Inputs.inputChoice(sc, 4);
			switch (choice) {
				case 1:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Trainers List ***");
					System.out.println();
					List<Trainer> castTrainers = new ArrayList<>(); // Downcasting to prepare for print
					for (Item trainer : trainers) {
						castTrainers.add((Trainer) trainer);
					}
					Printers.printList("trainer", castTrainers);
					break;
				case 2:
					while (true) {
						Printers.clearScreen();
						System.out.println("*** Bootcamp Registry Program / Create Trainers ***");
						System.out.println();
						trainers.addAll(Creators.createTrainer(sc));
						break;
					}
					break;
				case 3:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Add Trainers to Courses ***");
					System.out.println();
					trainersPerCourse = Creators.combinator("trainer", "course", sc, trainers, courses);
					break;
				case 4:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Trainers Per Course ***");
					System.out.println();
					Printers.printItemLists("Trainer", trainersPerCourse);
					break;
				case 0:
					break outerloop;
				default:
					break;
			}
		}
		returnList.add(trainers);
		returnList.add(trainersPerCourse);
		return returnList;
	}

	public static List<List<Item>> studentMenu(Scanner sc, List<Item> students, List<Item> courses, List<Item> studentsPerCourse, List<Item> coursesPerStudent) {
		List<List<Item>> returnList = new ArrayList<>();
		outerloop:
		while (true) {
			Printers.clearScreen();
			System.out.println("*** Bootcamp Registry Program / Students ***");
			System.out.println();
			System.out.println("1. View Students");
			System.out.println("2. Create Students");
			System.out.println("3. Add Students to Courses");
			System.out.println("4. View Students per Course");
			System.out.println("5. View Students with multiple Courses");
			System.out.println("0. Return to Main Menu");
			int choice = Inputs.inputChoice(sc, 5);
			switch (choice) {
				case 1:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Students List ***");
					System.out.println();
					List<Student> castStudents = new ArrayList<>(); // Downcasting to prepare for print
					for (Item student : students) {
						castStudents.add((Student) student);
					}
					Printers.printList("student", castStudents);
					break;
				case 2:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Create Students ***");
					System.out.println();
					students.addAll(Creators.createStudent(sc));
					break;
				case 3:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Add students to course ***");
					System.out.println();
					studentsPerCourse = Creators.combinator("student", "course", sc, students, courses);
					break;
				case 4:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Students Per Course ***");
					System.out.println();
					Printers.printItemLists("Student", studentsPerCourse);
					break;
				case 5:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Students with multiple Courses ***");
					System.out.println();
					coursesPerStudent = Creators.studentsWithCourses(true, students, studentsPerCourse);
					Printers.printItemLists("course", coursesPerStudent);
					break;
				case 0:
					break outerloop;
				default:
					break;
			}
		}
		returnList.add(students);
		returnList.add(studentsPerCourse);
		return returnList;
	}

	public static List<List<Item>> assignmentMenu(Scanner sc, List<Item> assignments, List<Item> courses, List<Item> assignmentsPerCourse, List<Item> students, List<Item> assignmentsPerStudent, List<Item> studentsPerCourse, List<Item> coursesPerStudent) {
		List<List<Item>> returnList = new ArrayList<>();
		outerloop:
		while (true) {
			Printers.clearScreen();
			System.out.println("*** Bootcamp Registry Program / Assignments ***");
			System.out.println();
			System.out.println("1. View Assignments");
			System.out.println("2. Create Assignments");
			System.out.println("3. Add Assignments to Courses");
			System.out.println("4. View Assignments per Course");
			System.out.println("5. Add Assignments to Students");
			System.out.println("6. View Assignments per Student");
			System.out.println("7. Check For Deadlines");
			System.out.println("0. Return to Main Menu");
			int choice = Inputs.inputChoice(sc, 7);
			switch (choice) {
				case 1:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Assignments List ***");
					System.out.println();
					List<Assignment> castAssignments = new ArrayList<>(); // Downcasting to prepare for print
					for (Item assignment : assignments) {
						castAssignments.add((Assignment) assignment);
					}
					Printers.printList("assignment", castAssignments);
					break;
				case 2:
					while (true) {
						Printers.clearScreen();
						System.out.println("*** Bootcamp Registry Program / Create Assignments ***");
						System.out.println();
						assignments.addAll(Creators.createAssignment(sc));
						break;
					}
					break;
				case 3:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Add Assignments to Courses ***");
					System.out.println();
					assignmentsPerCourse = Creators.combinator("assignment", "course", sc, assignments, courses);
					break;
				case 4:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Assignments Per Course ***");
					System.out.println();
					Printers.printItemLists("Assignment", assignmentsPerCourse);
					break;
				case 5:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Add Assignments to Students ***");
					System.out.println();
					coursesPerStudent = Creators.studentsWithCourses(false, students, studentsPerCourse);
					assignmentsPerStudent = Creators.studentsWithAssignments(sc, assignmentsPerCourse, coursesPerStudent, assignmentsPerStudent);
					break;
				case 6:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Assignments Per Student ***");
					System.out.println();
					Printers.printItemLists("Assignment", assignmentsPerStudent);
					break;
				case 7:
					Printers.clearScreen();
					System.out.println("*** Bootcamp Registry Program / Assignment Deadlines ***");
					Printers.subWeek(sc, assignmentsPerStudent);
					break;
				case 0:
					break outerloop;
				default:
					break;
			}
		}
		returnList.add(assignments);
		returnList.add(assignmentsPerCourse);
		returnList.add(assignmentsPerStudent);
		return returnList;
	}
}
