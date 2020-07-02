
package project0;

import java.util.*; //Import for Scanner and HashMap
import java.time.LocalDate; //import for getting current Year through LocalDate.now().getYear()

/**
 *
 * @author Chrysanthos Panagakos
 *
 * ************************************ PROJECT SUMMARY ***************************************
 *
 * In this project the goal is to get some personal details from the user, store them, and
 * print them in the form of a small paragraph. 3 implementations of a person are used, depending
 * on his details. Class person implements a single person, Class Married implements a married person
 * and Class MarriedWithChildren implements a married person with children. The names and ages 
 * of the children are stored in a HashMap<String, Integer>. Methods for all user inputs are 
 * implemented and passed on to the appropriate Class through a PersonInit() method. Guard clauses 
 * for InputMismatchException are introduced on the methods that require an int input as well as 
 * checks for Y/N questions.
 * 
 *                            ***************** EXERCISE ****************
 *
 *  Ask from the user the following questions and store the answers to appropriate variables:
 * 1. What is your name?
 * 2. What year you were born?
 * 3. What is the name of the city you were born?
 * 4. Are you married?
 * 	(if the answer is Yes ask)
 * 	4a. How many years have you been married?
 * 	4b. What year did you get married?
 * 	4c. Do you have any children?
 * 		(if the answer is Yes ask)
 * 		4d. How many children do you have?
 * 			(if the answer is more than 0 ask)
 * 			4e. What is the name of your i child?
 * 			4f. What is the age of your i child?
 * 			4g. What is the name of your j child
 * 			4h. What is the age of your j child?
 * 5. What is your favourite color?
 *
 *
 * The output of the program should be:
 *
 * Dear {name}, your were born in {year} so you are {age} and born in the city of {city}.
 * You are not married and your favourite color is {color}.
 *
 * 					OR
 * Dear {name}, your were born in {year} so you are {age} and born in the city of {city}.
 * You have been married for {marriedYears} and you got married in {yearOfMarriage} and you don't have any children.
 * Your favourite color is {color}.
 *
 * 					OR
 * Dear {name}, your were born in {year} so you are {age} and born in the city of {city}.
 * You have been married for {marriedYears} and you got married in {yearOfMarriage} and you have X children.
 * The name of your i child is {nameOfChild_i} and was born in the year of {bornYearChild_i}.
 * The name of your j child is {nameOfChild_j} and was born in the year of {bornYearChild_j}.
 * Your favourite color is {color}.
 * *************************************************************************************************/
 
public class Project0 {

	public static void main(String[] args) {
		Person person = PersonInit(); //Initialise person
		person.Greetings(); //Greet person
	}
	
	
	//Initialisation Sequence
	public static Person PersonInit()
	{
		Scanner sc = new Scanner(System.in); //Create new Scanner
		
		//Ask standard inputs for all persons and store in variables
		String name = inputName(sc);
		int year = inputYearOB(sc);
		String city = inputCity(sc);
		boolean married = inputMarried(sc);
		
		//If person is not married ask about their favorite color, construct Person instance and return it.
		if (!married) 
		{
			String color = inputColor(sc);
			return new Person(name, year, city, married, color);
			
		//If married, proceed with the next questions
		}else {
			
			int YearsMarried = inputYearsMarried(sc);
			int weddingYear = inputWeddingYear(sc);
			boolean children = inputChildren(sc);

			//If person doesn't have children ask about favorite color, construct a Married Instance and return it.
			if (!children) 
			{
				String color = inputColor(sc);
				return new Married(name, year, city, married, YearsMarried, weddingYear, children, color);
				
			//If person is married and has children create a HashMap for the childrens' details, 
			//ask about their favorite color, construct a MarriedWithChildren instance and return it.
			}else {
				
				int childrenNumber = inputChildrenNumber(sc);
				HashMap<String, Integer> childrenMap = inputChildrenDetails(sc, childrenNumber);
				String color = inputColor(sc);
				return new MarriedWithChildren(name, year, city, married, YearsMarried, weddingYear, children, childrenNumber, childrenMap, color);

			}
		}

	}

	// Methods for requesting personal details of Persons

	//Ask name
	public static String inputName(Scanner sc) { 
		System.out.print("What is your name? ");
		return sc.next();
	}

	//Ask year of birth
	public static int inputYearOB(Scanner sc) { 
		int year;
		System.out.print("What year you where born? ");

		//Guard clause for InputMismatchException
		while(true){
			try {
				year = sc.nextInt();
				// Check for rational answer but accept anyways
				if (year > LocalDate.now().getYear() || year < 1920)
					System.out.println("Wait a minute, Doc. Are you telling me you built a time machine...?");
				return year;
			}catch(InputMismatchException e){
				System.out.print("Enter a valid year! ");
				sc.next();
			}
		}
	}
	
	//Ask city of birth
	public static String inputCity(Scanner sc) {
		System.out.print("What is the name of the city you were born? ");
		return sc.next();
	}

	//Ask if married
	public static boolean inputMarried(Scanner sc) {
		char c;
			System.out.print("Are you married (Y/N)? ");

		//Guard loop until appropriate char is given
		while (true){
			c = sc.next().charAt(0);
			if (c == 'Y' || c == 'y')
				return true;
 			if ( c == 'N' || c == 'n') 
				return false;
			System.out.println("Y or N mister?");
		}
	}

	//Ask how many years person is married
	public static int inputYearsMarried(Scanner sc) {

		int years;
		System.out.print("How many years have you been married? ");

		//Guard clause for InputMismatchException
		while(true){
			try {
				years = sc.nextInt();
				return years;
			}catch(InputMismatchException e){
				System.out.print("Enter a valid number of years! ");
				sc.next();
			}
		}
	}

	//Ask year of wedding
	public static int inputWeddingYear(Scanner sc) {

		int year;
		System.out.print("What year did you get married? ");

		//Guard clause for InputMismatchException
		while(true){
			try {
				year = sc.nextInt();
				if (year > LocalDate.now().getYear() || year < 1920) //rationality check
					System.out.println("Wait a minute, Doc. Are you telling me you built a time machine...?");
				return year;
			}catch(InputMismatchException e){
				System.out.print("Enter a valid year! ");
				sc.next();
			}
		}
	}
	
	//Ask if person has children
	public static boolean inputChildren(Scanner sc) {
		char c;
			System.out.print("Do you have any children (Y/N)? ");

		//Guard loop until appropriate char is given
		while (true){
			c = sc.next().charAt(0);
			if (c == 'Y' || c == 'y')
				return true;
 			if ( c == 'N' || c == 'n') 
				return false;
			System.out.println("Y or N mister?");
		}
	}

	//ASk number of children
	public static int inputChildrenNumber(Scanner sc) {

		int children;
		System.out.print("How many children do you have? ");

		//Guard clause for InputMismatchException
		while(true){
			try {
				children = sc.nextInt();
				if (children > 10) //rationality check but accept
					System.out.println("Really...?");
				return children;
			}catch(InputMismatchException e){
				System.out.print("Enter a valid number of years! ");
				sc.next();
			}
		}
	}

	//Ask names and age of children
	public static HashMap<String, Integer> inputChildrenDetails(Scanner sc, int childrenNumber) {
		HashMap<String, Integer> childrenMap = new HashMap<String, Integer>(); //create new hashmap
		String name;
		int age;

		//Populate Hashmap (CAUTION: Names of children must all be different or else they will be overwritten)
		for (int i = 0; i < childrenNumber; i++){
			System.out.print("What is the name of your " + (i + 1) + " child? ");
			name = sc.next();
			System.out.print("What is the age of your " + (i + 1) + " child? ");

			//Guard clause for InputMismatchException
			while(true){
				try {
					age = sc.nextInt();
					if (age > 100 || age < 0) //rationality check but accept
						System.out.println("Wait a minute, Doc. Are you telling me you built a time machine...?");
					break;
				}catch(InputMismatchException e){
					System.out.print("Enter a valid year! ");
					sc.next();
				}
			}
			childrenMap.put(name, age); //If input is valid pass it on hashMap with put() method
		}
		return childrenMap;
	}	

	//Ask favorite color
	public static String inputColor(Scanner sc){
		System.out.print("What is your favorite color? ");
		return sc.next();
	}



}



