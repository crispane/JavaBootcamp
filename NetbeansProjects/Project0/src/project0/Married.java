
package project0;

import java.time.LocalDate; //import for getting current Year through LocalDate.now().getYear()

// Class of a person who is married but doesn't have any children
public class Married extends Person {
	private final int YearsMarried;
	private final int weddingYear;
	private final boolean children;


	//Constructor
	public Married(String name, int year, String city, boolean married, int YearsMarried, int weddingYear, boolean children, String color) {
		super(name, year, city, married, color);
		this.YearsMarried = YearsMarried;
		this.weddingYear = weddingYear;
		this.children = false;
	}

	//Override parent method to add further details
	@Override
	public void Greetings() 
	{
		System.out.println(); //empty Line

		//Printing Basic Details
		System.out.printf("Dear %s your were born in %d so you are %d and born in the city of %s.\n", getName(), getYear(), LocalDate.now().getYear() - getYear(), getCity());
		System.out.printf("You have been married for %d years, you got married in %d and you don't have children.\n", getYearsMarried(), getWeddingYear());
		System.out.println("Your favourite color is " + getColor() + ".");
	}

	//Getters but no Setters
	public int getYearsMarried() {
		return YearsMarried;
	}

	public int getWeddingYear() {
		return weddingYear;
	}

	public boolean isChildren() {
		return children;
	}

}
