package interfacecomparable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author f3nix
 */
public class Assignment implements Comparable<Assignment> {

	private String title;
	private LocalDate submissionDate;

	public Assignment() {
	}

	public Assignment(String title, String submissionDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.submissionDate = LocalDate.parse(submissionDate, formatter);
		this.title = title;
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

	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}

	@Override
	public String toString() {
		return "Assignment{" + "submissionDate=" + submissionDate + '}';
	}

	@Override
	public int compareTo(Assignment asm) {
		return this.submissionDate.compareTo(asm.getSubmissionDate());
	}
}
