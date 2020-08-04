package WorkingClasses;

import BaseClasses.*;
import ExtraClasses.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author f3nix
 */
public class Creators {

	// Creators for instanced Lists 
	public static List<Item> createCourse(Scanner sc) {
		List<Item> courses = new ArrayList<>();
		while (true) {
			Course course = new Course(Inputs.inputString(sc, "Enter title: "),
					Inputs.inputString(sc, "Enter stream: "),
					Inputs.inputString(sc, "Enter type: "),
					Inputs.inputDate(sc, "Enter start date: "),
					Inputs.inputDate(sc, "Enter end date: "));
			courses.add(course);
			System.out.printf("Do you want to add a new Course(Y/n)? ");
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
					Inputs.inputDate(sc, "Enter Date of Birth (dd/mm/yyyy): "),
					Inputs.inputMoney(sc, "Enter tuition fees: "));
			students.add(student);
			System.out.printf("Do you want to add a new Student(y/n)? ");
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
			System.out.printf("Do you want to add a new Trainer(y/n)? ");
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
					Inputs.inputDate(sc, "Enter submission date: "),
					Inputs.inputInt(sc, "Enter oral mark: "),
					Inputs.inputInt(sc, "Enter total mark: "));
			assignments.add(assignment);
			System.out.printf("Do you want to add a new Assignment(y/n)? ");
			if (!Inputs.yes(sc)) {
				break;
			}
		}
		return assignments;
	}

	// A most important method to create Lists of ItemLists
	public static List<Item> addSourceToTarget(String sourceType, String targetType, Scanner sc, List<Item> source, List<Item> target) {
		List<Item> returnList = new ArrayList<>();
		int i;
		for (Item targetItem : target) {
			ItemList sourceInTarget = new ItemList();
			while (true) {
				i = 0;
				System.out.println("Select " + sourceType + " to add to " + targetItem);
				for (Item sourceItem : source) {
					i++;
					System.out.println(i + ". " + sourceItem.getName());
				}
				int choice = Inputs.inputChoice(sc, source.size());
				if(choice == 0) break;
				sourceInTarget.add(source.get(choice - 1));
				sourceInTarget.setItem(targetItem);
				System.out.print("Add another " + sourceType + " to " + targetType + "?(y/n) ");
				if (!Inputs.yes(sc)) {
					break;
				}
			}
			returnList.add(sourceInTarget);
		}
		return returnList;
	}

public static List<Item> studentsInMultipleCourses(List<Item> students, List<Item> studentsPerCourse){
	HashMap<Item, List<Item>> map = new HashMap<>();
	for (Item itemlist : studentsPerCourse) {
		ItemList castedList= (ItemList)itemlist;

		//st.add(((ItemList)itemlist).getItem());
	}
	return null;
}
	
}
