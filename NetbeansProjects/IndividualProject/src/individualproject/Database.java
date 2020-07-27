/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author f3nix
 */
public class Database {

	List<Course> courseList;
	List<Student> StudentList;
	List<Trainer> trainerList;
	List<Assignment> assignmentList;

	List<List<Assignment>> assignmentsPerStudent;

	List<List<Student>> studentsPerCourse;
	List<List<Trainer>> trainersPerCourse;

	public static List<Course> createCourse(Scanner sc) {
		List<Course> courses = new ArrayList<>();
		while (true) {
			Course course = new Course(Main.inputString(sc, "Enter title: "),
					Main.inputString(sc, "Enter stream: "),
					Main.inputString(sc, "Enter type: "),
					Main.inputDate(sc, "Enter start date: "),
					Main.inputDate(sc, "Enter end date: "));
			courses.add(course);
			System.out.printf("Do you want to add a new Course(Y/n)? ");
			if (!Main.yes(sc)) {
				break;
			}
		}
		return courses;
	}

	public static List<Student> createStudent(Scanner sc) {
		List<Student> students = new ArrayList<>();
		while (true) {
			Student student = new Student(Main.inputString(sc, "Enter first name: "),
					Main.inputString(sc, "Enter last name: "),
					Main.inputDate(sc, "Enter Date of Birth (dd/mm/yyyy): "),
					Main.inputMoney(sc, "Enter tuition fees: "));
			students.add(student);
			System.out.printf("Do you want to add a new Student(Y/n)? ");
			if (!Main.yes(sc)) {
				break;
			}
		}
		return students;
	}

	public static List<List<Student>> studentsInCourses(Scanner sc, List<Student> students, List<Course> courses) {
		List<List<Student>> studentsInCourses = new ArrayList<>();
		int i = 0;
		int choice;
		for (Course course : courses) {
			i++;
			System.out.println("Add a student to course " + i + ". " + course.getTitle());
			List<Student> studentList = new ArrayList<>();
//			for (Student student : students) {
				printStudents(students);
				choice = Menus.inputChoice(sc, courses.size());
				if (choice == 0) {
					break;
				}
				studentList.add(students.get(choice - 1));
//			}
			studentsInCourses.add(studentList);

		}
		return studentsInCourses;
	}

	public static void printStudents(List<Student> students) {
		int i = 0;
		for (Student student : students) {
			i++;
			System.out.println(i + ". " + student.getFirstName() + " " + student.getLastName());
		}
		System.out.println("0. Next Course");
	}

}
