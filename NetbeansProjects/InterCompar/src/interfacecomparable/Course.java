package interfacecomparable;

import java.util.List;

/**
 *
 * @author f3nix
 */
public class Course implements Comparable<Course> {

	private String title;
	private List<Student> list;

	public Course() {
	}

	public Course(String name, List<Student> list) {
		this.title = name;
		this.list = list;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Course{" + "title=" + title + ", list=" + list + '}';
	}

	@Override
	public int compareTo(Course course) {
		if (this.list.size()==(course.getList().size())) {
			return 0;
		} else if (this.list.size() >= course.getList().size()) {
			return 1;
		} else {
			return -1;
		}
	}
}
