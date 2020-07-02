
package project0;

import java.time.LocalDate; //import for getting current Year through LocalDate.now().getYear()
import java.util.*; //import for Hashmap


// Class of a person who is married with children
public class MarriedWithChildren extends Married{
	private final int childrenNumber;
	private final HashMap<String, Integer> childrenMap;

	//Constructor
	public MarriedWithChildren(String name, int year, String city, boolean married, int YearsMarried, int weddingYear, boolean children, int childrenNumber, HashMap<String, Integer> childrenMap, String color) {
	super(name, year, city, married, YearsMarried, weddingYear, children, color);
	this.childrenNumber = childrenNumber;
	this.childrenMap = childrenMap;
}
	
	//Override parent method to add further details
	@Override
	public void Greetings() 
	{
		int childIndex= 0; //index of child for printing purposes
		System.out.println(); //Empty Line

		//Printing Basic Details
		System.out.printf("Dear %s your were born in %d so you are %d and born in the city of %s.\n", getName(), getYear(), LocalDate.now().getYear() - getYear(), getCity());
		System.out.printf("You have been married for %d years, you got married in %d and you have %d children.\n", getYearsMarried(), getWeddingYear(), childrenNumber);

		//Printing the HashMap
		for (String i : childrenMap.keySet())		
			System.out.printf("The name of your %d child is %s and was born in the year of %d.\n", ++childIndex, i, childrenMap.get(i));

		//Printing favorite color	
		System.out.println("Your favourite color is " + getColor() + ".");
	}

	//Getters but no Setters
	public int getChildrenNumber() {
		return childrenNumber;
	}

	public HashMap<String, Integer> getChildrenMap() {
		return childrenMap;
	}

}
