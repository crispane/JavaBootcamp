drop database bootcamps;
CREATE SCHEMA bootcamps DEFAULT CHARACTER SET utf8mb4;
use bootcamps;

CREATE TABLE classes (
	class_id INT AUTO_INCREMENT PRIMARY KEY,
	class_title VARCHAR(50),
	class_stream VARCHAR(50),
	class_type VARCHAR(50),
	start_date DATE,
	end_date DATE
);

CREATE TABLE assignments (
	assignment_id INT AUTO_INCREMENT PRIMARY KEY,
	assignment_title VARCHAR(50),
	assignment_description VARCHAR(100),
	submission_date DATE,
	class_id INT,
	FOREIGN KEY (class_id) REFERENCES classes (class_id)
);

CREATE TABLE projects (
	project_id INT AUTO_INCREMENT PRIMARY KEY,
	project_title VARCHAR(50),
	project_description VARCHAR(100),
	class_id INT,
	FOREIGN KEY (class_id) REFERENCES classes (class_id)
);

CREATE TABLE students (
	student_id INT AUTO_INCREMENT PRIMARY KEY,
	student_name VARCHAR(50),
	student_dob DATE,
	student_fees INT,
	class_id INT,
	FOREIGN KEY (class_id) REFERENCES classes (class_id)
);

CREATE TABLE assignments_results (
	-- assm_res_id INT AUTO_INCREMENT PRIMARY KEY,
	student_id INT,
	class_id INT,
	assignment_id INT,
	mark INT,
	FOREIGN KEY (student_id) REFERENCES students(student_id),
	FOREIGN KEY (class_id) REFERENCES students(class_id),
	FOREIGN KEY (assignment_id) REFERENCES assignments(assignment_id)
);

CREATE TABLE projects_results (
	-- project_res_id INT AUTO_INCREMENT PRIMARY KEY,
	mark INT,
	student_id INT,
	class_id INT,
	project_id INT,
	FOREIGN KEY (student_id) REFERENCES students(student_id),
	FOREIGN KEY (class_id) REFERENCES classes(class_id),
	FOREIGN KEY (project_id) REFERENCES projects(project_id)
);
