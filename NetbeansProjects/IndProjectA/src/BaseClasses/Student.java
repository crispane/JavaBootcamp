package BaseClasses;

import ExtraClasses.Item;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author f3nix
 */
public class Student extends Item{

	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private BigDecimal tuitionFees;

	public Student() {
	}

	public Student(String firstName, String lastName, LocalDate dateOfBirth, BigDecimal tuitionFees) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.tuitionFees = tuitionFees;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BigDecimal getTuitionFees() {
		return tuitionFees;
	}

	public void setTuitionFees(BigDecimal tuitionFees) {
		this.tuitionFees = tuitionFees;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", tuitionFees=" + tuitionFees + '}';
	}

	@Override
	public String getName() {
		return firstName + " " + lastName;
	}

}
