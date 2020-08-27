package BaseClasses;

import ExtraClasses.Item;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class Trainer extends Item{
	private String firstName;
	private String lastName;
	private String subject;

	public Trainer() {
	}

	public Trainer(String firstName, String lastName, String subject) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return String.format("%-15s%-15sSub: %-15s",firstName, lastName, subject);
	}

	@Override
	public String getName() {
		return firstName + " " + lastName;
	}
	
}
