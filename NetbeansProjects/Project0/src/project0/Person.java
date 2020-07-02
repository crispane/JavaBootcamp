
package project0;

import java.time.LocalDate; //import for getting current Year through LocalDate.now().getYear()

// Class of a person who is not married 
public class Person {
	private final String name;
	private final int year;
	private final String city;
	private final boolean married;
	private final String color;

	//Constructor
	public Person(String name, int year, String city, boolean married, String color) {
		this.name = name;
		this.year = year;
		this.city = city;
		this.married = false;
		this.color = color;
	}

	// Method to greet the person with his details
	public void Greetings() 
	{
		System.out.println(); // Empty Line

		//Printing Basic Details
		System.out.printf("Dear %s your were born in %d so you are %d and born in the city of %s.\n", name, year, LocalDate.now().getYear() - year, city);
			System.out.println("You are not married and your favourite color is " + color + ".");
	}

	//Getters but no Setters
	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public String getCity() {
		return city;
	}

	public boolean isMarried() {
		return married;
	}

	public String getColor() {
		return color;
	}

}





