package interfacecomparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author f3nix
 */
public class Main {

	public static void main(String[] args) {

		//Construct synthetic data
		Assignment asm1 = new Assignment("title1", "14/07/2021");
		Assignment asm2 = new Assignment("title2", "14/07/2021");
		Assignment asm3 = new Assignment("title3", "14/08/2021");

		Student st1 = new Student("Lula Kent", 16, 78);
		Student st2 = new Student("Julian O'Quinn", 16, 54);
		Student st3 = new Student("Linda Sherman", 15, 90);
		Student st4 = new Student("Ethan Swanson", 17, 53);
		Student st5 = new Student("Amelia-Grace Dunkley", 18, 78);
		Student st6 = new Student("Teddy Sumner", 16, 95);
		Student st7 = new Student("Gabrielle Frank", 17, 53);
		Student st8 = new Student("Cally Daniels", 18, 87);

		Trainer tr1 = new Trainer("22/09/1982");
		Trainer tr2 = new Trainer("22/09/1982");
		Trainer tr3 = new Trainer("22/10/1985");
		Trainer tr4 = new Trainer("21/09/1982");

		//Exercise 1------------------------------------
		System.out.println("Exercise 1----------------");
		System.out.print(st1.compareTo(st2) + " "); // Comparing grades
		System.out.print(st4.compareTo(st7) + " ");
		System.out.print(st4.compareTo(st8) + " ");
		System.out.println();

		//Exercise 2------------------------------------
		System.out.println("Exercise 2----------------");
		System.out.print(tr1.compareTo(tr4) + " "); // comparing start dates
		System.out.print(tr1.compareTo(tr2) + " ");
		System.out.print(tr1.compareTo(tr3) + " ");
		System.out.println();

		//Exercise 3-------------------------------------
		System.out.println("Exercise 3----------------");
		System.out.print(asm3.compareTo(asm2) + " "); // comparing submission dates
		System.out.print(asm1.compareTo(asm2) + " ");
		System.out.print(asm1.compareTo(asm3) + " \n");
		System.out.println();

		//Creating student lists
		ArrayList<Student> ls1 = new ArrayList<>();
		ls1.add(st1);
		ls1.add(st2);
		ls1.add(st3);
		ls1.add(st4);

		ArrayList<Student> ls2 = new ArrayList<>();
		ls2.add(st5);
		ls2.add(st6);
		ls2.add(st7);
		ls2.add(st1);
		ls2.add(st2);
		ls2.add(st3);

		ArrayList<Student> ls3 = new ArrayList<>();
		ls3.add(st5);
		ls3.add(st6);
		ls3.add(st7);

		//Exercise 4-----------------------------
		System.out.println("Exercise 4----------------");
		Collections.sort(ls1); // sorting a student list by grade
		for (Student student : ls1) {
			System.out.println(student);

		}
		System.out.println();

		//Creating course lists
		Course c1 = new Course("Maths");
		Course c2 = new Course("Physics");
		Course c3 = new Course("Chemistry");

		CourseWithStudents cs1 = new CourseWithStudents(c1, ls1);
		CourseWithStudents cs2 = new CourseWithStudents(c2, ls2);
		CourseWithStudents cs3 = new CourseWithStudents(c3, ls3);
		List<CourseWithStudents> courses = new ArrayList<>();
		courses.add(cs1);
		courses.add(cs2);
		courses.add(cs3);

		//Exercise 5-----------------------------
		System.out.println("Exercise 5----------------");
		Collections.sort(courses); //sorting courses by number of students
		for (CourseWithStudents course : courses) {
			System.out.println(course);

		}
	}

}
