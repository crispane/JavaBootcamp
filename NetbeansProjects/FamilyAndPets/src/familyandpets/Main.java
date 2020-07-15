/*
*Create a program that will ask the user to enter the details of his/her family. 
*Enter at least 3 Persons. You must create a class Person with variables name, age and pets. 
*pets variable is of type List<Pet>(If List<Pet> is difficult, then make it array of Pets). 
*So you must also create another class Pet. Class Pet will have variables nickname and type. 
*type will be String and can have values dog, cat, fish, etc. All the details will be entered from the user. 
*Use Scanner class. When all details have been entered, print the details of the family in a file called family.txt.
*Not everyone needs to have pets. The pets must be also be printed in the file.
 */
package familyandpets;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner sc = new Scanner(System.in);
		PrintWriter wr = new PrintWriter("family.txt", "UTF-8");

		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();

		inputPerson(sc, p1);
		inputPerson(sc, p2);
		inputPerson(sc, p3);

		printPerson(p1, wr);
		printPerson(p2, wr);
		printPerson(p3, wr);

		sc.close();
		wr.close();
	}

	public static Person inputPerson(Scanner sc, Person person) {
		System.out.print("Enter your relationship with the family member: ");
		String relationship = sc.next();

		System.out.printf("Enter your %s's name: ", relationship);
		person.setName(sc.next());

		while (true)
			try {
			System.out.printf("Enter %s's age: ", relationship);
			person.setAge(sc.nextInt());
			break;
		} catch (InputMismatchException e) {
			System.out.println("Number must be an integer.");
			sc.next();
		}

		System.out.printf("Does your %s have any pets? Enter Y or N: ", relationship);
		if (yesOrNo(sc)) {
			person.setPets(inputPets(sc));
		} else {
			person.setPets(new ArrayList<>());
		}
		System.out.println();
		return person;
	}

	public static void printPerson(Person person, PrintWriter wr) {
		wr.printf("%s is %d years old and has %d pets.\n", person.getName(), person.getAge(), person.getPets().isEmpty() ? 0 : person.getPets().size());
		if (!person.getPets().isEmpty()) {
			for (Pet pet : person.getPets()) {
				wr.printf("A %s, %s.\n", pet.getType(), pet.getNickname());
			}
		}
		wr.println();
	}

	public static boolean yesOrNo(Scanner sc) {
		char c;
		//Guard loop until appropriate char is given
		while (true) {
			c = sc.next().charAt(0);
			if (c == 'Y' || c == 'y') {
				return true;
			}
			if (c == 'N' || c == 'n') {
				return false;
			}
			System.out.print("Y or N ?");
		}
	}

	public static List<Pet> inputPets(Scanner sc) {

		List<Pet> pets = new ArrayList<>();
		String exit = "init";
		int i = 1;

		while (!(exit.equals("exit"))) {
			System.out.printf("Enter type of pet %d: ", i);
			Pet pet = new Pet();
			pet.setType(sc.next());
			System.out.printf("Enter nickname of pet %d: ", i);
			pet.setNickname(sc.next());
			pets.add(pet);
			i++;
			System.out.print("If no more pets type \"exit\", or anything else to continue to next pet : ");
			
			exit = sc.next().toLowerCase();
		}
		System.out.println();
		return pets;
	}
}
