package interfacecomparable;

/**
 *
 * @author f3nix
 */
public class Student implements Comparable<Student> {

	private String name;
	private Integer age;
	private Integer grade;

	public Student() {
	}

	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Student(String name, Integer age, Integer Grade) {
		this.name = name;
		this.age = age;
		this.grade = Grade;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setlGrade(Integer totalGrade) {
		this.grade = totalGrade;
	}

	@Override
	public String toString() {
		return "Student{" + "name=" + name + ", age=" + age + ", Grade=" + grade + '}';
	}

	@Override
	public int compareTo(Student st) {
		return this.grade.compareTo(st.getGrade());
	}

}
