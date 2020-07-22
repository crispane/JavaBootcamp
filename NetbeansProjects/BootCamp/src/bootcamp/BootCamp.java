/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp;

import java.time.LocalDate;

/**
 *
 * @author f3nix
 */
public class BootCamp {

	private String name;
	private LocalDate startingDate;
	private LocalDate endingDate;

	public BootCamp(String name, LocalDate startingDate, LocalDate endingDate) {
		this.name = name;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	public LocalDate getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(LocalDate endingDate) {
		this.endingDate = endingDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name)
				.append(" Bootcamp starts at ")
				.append(startingDate)
				.append(" and ends at ")
				.append(endingDate)
				.append('.');
		return builder.toString();
	}

}
