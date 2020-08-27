package BaseClasses;

import ExtraClasses.Item;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class Assignment extends Item {

	private String title;
	private String description;
	private LocalDate submissionDate;
	private int oralMark;
	private int totalMark;

	public Assignment() {
	}

	public Assignment(String title, String description, LocalDate submissionDate) {
		this.title = title;
		this.description = description;
		this.submissionDate = submissionDate;
	}

	public Assignment(String title, String description, LocalDate submissionDate, Integer totalMark, Integer oralMark) {
		this.title = title;
		this.description = description;
		this.submissionDate = submissionDate;
		this.totalMark = totalMark;
		this.oralMark = oralMark;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		while (true) {
			try {
				this.submissionDate = LocalDate.parse(submissionDate, formatter);
				break;
			} catch (DateTimeParseException e) {
				System.out.println("Invalid Date.");
			}
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOralMark() {
		return oralMark;
	}

	public void setOralMark(int oralMark) {
		this.oralMark = oralMark;
	}

	public int getTotalMark() {
		return totalMark;
	}

	public void setTotalMark(int totalMark) {
		this.totalMark = totalMark;
	}

	@Override
	public String toString() {
		return String.format("%-25s Due: %-15s\n--Description: %s\n", title, submissionDate, description);
	}

	@Override
	public String getName() {
		return title;
	}

}
