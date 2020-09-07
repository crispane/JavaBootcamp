INSERT INTO classes(class_title) VALUES
	('CB11 JAVA PART-TIME'),
	('CB11 JAVA FULL-TIME'),
    ('CB11 C# PART-TIME'),
	('CB11 C# FULL-TIME'),
    ('CB11 PYTHON PART-TIME'),
	('CB11 PYTHON FULL-TIME')
;

INSERT INTO students(student_name, class_id) VALUES
	('Ηλίας Παπαδόπουλος', 1),
	('Γιάννης Αποστόλου', 6),
    ('Λευτέρης Ανδριώτης', 3),
	('Σωτήρης Παπαδάκης', 5),
    ('Έκτορας Μαχαιρίδης', 1),
	('Δημήτρης Αναστασάκος', 4)
;

INSERT INTO assignments(assignment_title, class_id) VALUES
	('assignment1', 1),
	('assignment2', 2),
    ('assignment3', 1),
	('assignment4', 6),
    ('assignment5', 3),
	('assignment6', 4),
    ('assignment7', 5)
;

INSERT INTO projects(project_title, class_id) VALUES
	('project1', 1),
	('project2', 2),
    ('project3', 1),
	('project4', 6),
    ('project5', 3),
	('project6', 4),
    ('project7', 5)
;

INSERT INTO assignments_results(student_id, class_id, assignment_id, mark) VALUES
	(1, 1, 1, 77), 
    (5, 1, 3, 96),
    (3, 3, 5, 86),
	(4, 5, 7, 67),
	(2, 6, 6, 55)
;

INSERT INTO projects_results(student_id, class_id, project_id, mark) VALUES
	(1, 1, 1, 30), 
    (5, 1, 3, 76),
    (3, 3, 5, 86),
	(4, 5, 7, 10),
	(2, 6, 6, 78)
;

SELECT * FROM classes;
SELECT * FROM students;
SELECT * FROM assignments;
SELECT * FROM assignments_results;
SELECT 
    *
FROM
    projects_results;

SELECT students.student_id, student_name, class_title, assignment_title, mark
FROM assignments_results
JOIN (students, assignments, classes)
	ON assignments_results.student_id=students.student_id 
    AND assignments_results.assignment_id=assignments.assignment_id
    AND students.class_id = classes.class_id
;

SELECT students.student_id, student_name, class_title, project_title, mark
FROM projects_results
JOIN (students, projects, classes)
	ON projects_results.student_id=students.student_id 
    AND projects_results.project_id=projects.project_id
    AND students.class_id = classes.class_id
;
