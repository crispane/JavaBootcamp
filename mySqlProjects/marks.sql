-- drop database bootcamps;
create database bootcamps;
use bootcamps;

CREATE TABLE classes (
	class_code INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	class_title VARCHAR(50)
);


CREATE TABLE assignments (
	assignment_code INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	assignment_title VARCHAR(50),
    assignment_description VARCHAR(100),
	assignment_mark INT UNSIGNED NULL,
    class INT UNSIGNED NULL,
    student INT UNSIGNED NULL
);

CREATE TABLE projects (
	project_code INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	project_title VARCHAR(50),
    project_description VARCHAR(100),
    project_mark INT UNSIGNED,
    class INT UNSIGNED NULL,
    student INT UNSIGNED NULL
);

CREATE TABLE students (
	student_code INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(50),
    class INT UNSIGNED NULL,
    assignment INT UNSIGNED NULL,
	constraint fk_class foreign key (class) references classes (class_code),
	constraint fk_assignment foreign key (assignment) references assignments (assignment_code)
);

ALTER TABLE assignments
add constraint fk_class2 foreign key (class) references classes (class_code),
add constraint fk_student2 foreign key (student) references students (student_code);

ALTER TABLE projects
add constraint fk_class3 foreign key (class) references classes (class_code),
add	constraint fk_student3 foreign key (student) references students (student_code);

    