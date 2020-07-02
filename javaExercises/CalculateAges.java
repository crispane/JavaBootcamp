
/* CalculateAges.java */

/* 
* Exercise: 
*
* Create a program that calculates when you were born. 
* Data given is the year we have and your age.
* Do this for 3 more people. 
* How old was each person in 1960 and how old will be in 2040?
*/


public class CalculateAges{

	public static void main(String[] args) 
	{
		String [] name = {"me", "John", "Anna", "Maria"}; 
		int [] age = {38, 1, 105, 76};

		int currYear = 2020;
		int pastYear = 1960;
		int futureYear = 2040;
		
		printSequence(name, age, currYear, pastYear, futureYear);
	}	

	public static void printSequence(String[] name, int[] age, int currYear, int pastYear, int futureYear){
		for (int i = 0; i < name.length; i++) 
		{ 
			System.out.printf("Birth year of %s is %d. ", name[i], birthYear(age[i], currYear));
			if (name[i].equals("me")) name[i] = "I";
			if ( birthYear(age[i], currYear) > pastYear)
				System.out.printf("In %d, %s will not be born for another %d years!", pastYear, name[i], birthYear(age[i], currYear)- pastYear);
			else
				System.out.printf("In %d, %s was %d years old.", pastYear, name[i], ageCalc(age[i], currYear, pastYear));
			System.out.printf(" And in %d, %s will be %d years old. \n", futureYear, name[i], ageCalc(age[i], currYear, futureYear));
		}
	}
	

	public static int birthYear(int age, int currYear) {
		return currYear - age;
	}

	public static int ageCalc(int age, int currYear,  int targetYear) {
		if (birthYear(age, currYear) > targetYear)
			return -1;
		else
			return targetYear - birthYear(age, currYear);
	}
}
		
