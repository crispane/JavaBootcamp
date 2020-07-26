package interfacecomparable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author f3nix
 */
public class Trainer implements Comparable<Trainer> {
	private String name;
	private LocalDate startDate;

	public Trainer() {
	}

	public Trainer(String startDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.startDate = LocalDate.parse(startDate, formatter);
	}

	public Trainer(String name, LocalDate startDate) {
		this.name = name;
		this.startDate = startDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Trainer{" + "name=" + name + ", startDate=" + startDate + '}';
	}


	@Override
	public int compareTo(Trainer tr) {
		return this.startDate.compareTo(tr.getStartDate());
	}

}
