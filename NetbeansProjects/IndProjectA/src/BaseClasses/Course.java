package BaseClasses;

import ExtraClasses.Item;
import java.time.LocalDate;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class Course extends Item{

	private String title;
	private String stream;
	private String type;
	private LocalDate startDate;
	private LocalDate endDate;

	public Course() {
	}

	public Course(String title, String stream, String type, LocalDate startDate, LocalDate endDate) {
		this.title = title;
		this.stream = stream;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return String.format("%-25s%-15s%-15sStarts: %-15sEnds: %-15s",title, stream, type, startDate, endDate);
	}
	
	@Override
	public String getName() {
		return title;
	}


}
