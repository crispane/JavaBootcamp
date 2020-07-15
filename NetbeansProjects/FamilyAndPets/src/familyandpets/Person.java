package familyandpets;

import java.util.List;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class Person {
	private String name;
	private int age;
	private List<Pet> pets;

	public Person() {
	}

	public Person(String name, int age, List<Pet> pets) {
		this.name = name;
		this.age = age;
		this.pets = pets;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	
}
