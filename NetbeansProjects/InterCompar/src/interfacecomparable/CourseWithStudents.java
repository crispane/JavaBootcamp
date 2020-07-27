package interfacecomparable;

import java.util.List;

/**
 *
 * @author f3nix
 */
public class CourseWithStudents implements Comparable<CourseWithStudents> {
	private Course course;
	private List<Student> list;

	public CourseWithStudents() {
	}

	public CourseWithStudents(Course course, List<Student> list){
		this.course = course;
		this.list = list;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}
	
	@Override
	public int compareTo(CourseWithStudents course) {
		if (this.list.size()==(course.getList().size())) {
			return 0;
		} else if (this.list.size() >= course.getList().size()) {
			return 1;
		} else {
			return -1;
		}
	}

//	@Override
//	public int compareTo(CourseWithStudents o) {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//	}

	@Override
	public String toString() {
		return "CourseWithStudents{" + "course=" + course + ", list=" + list + '}';
	}
}
