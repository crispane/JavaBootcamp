CREATE DATABASE sales;
USE sales;
CREATE TABLE IF NOT EXISTS products (
    Pcode INT AUTO_INCREMENT PRIMARY KEY,
    Pdescr VARCHAR(45) NOT NULL,
    Pprice DECIMAL(7,2)
);

CREATE TABLE IF NOT EXISTS customers (
	Ccode INT AUTO_INCREMENT PRIMARY KEY,
	Cname VARCHAR(20)
);
    
CREATE TABLE IF NOT EXISTS salesmen (
	Scode INT AUTO_INCREMENT PRIMARY KEY,
    Sname VARCHAR(20) NOT NULL,
    Scity VARCHAR(15),
    Scomm DECIMAL(5,2)
);

CREATE TABLE IF NOT EXISTS family (
	Fname VARCHAR(20),
    Frelationship VARCHAR(20),
    Dob DATE,
    Salesman INT
);

CREATE TABLE IF NOT EXISTS sales (
	Scode INT AUTO_INCREMENT PRIMARY KEY,
    Pcode INT,
    Sdate DATE,
    Ccode INT,
    Smcode INT,
    Quant INT,
    Cost DECIMAL(7,2),
    FOREIGN KEY (Pcode) REFERENCES products(Pcode),
    FOREIGN KEY (Ccode) REFERENCES customers(Ccode)
);

INSERT INTO customers(Ccode, Cname) VALUES 
	(100102, 'Aleksiadis'),
	(100103, 'Papadopoulos'),
	(100104, 'Ioannou'),
	(100105, 'Apostolou'),
	(100106, 'Papamarkou'),
	(100107, 'Drakopoulos');
    
INSERT INTO salesmen(Scode, Sname, Scity, Scomm) VALUES
	(101, 'Antoniou', 'Athens', 0.14),
	(102, 'Dimou', 'Athens', 0.15),
	(103, 'Vasileiou', 'Patra', 0.17),
	(104, 'Raptis', 'Thessaloniki', 0.16),
	(105, 'Lamprinakis', 'Irakleio', 0.15);
    
INSERT INTO family(Fname, Frelationship, Dob, Salesman) VALUES
    ('George', 'son', '1981-02-11', 101),
	('Mary', 'wife', '1977-12-11', 101);
    
DELETE FROM products; 
INSERT INTO products(Pcode, Pdescr, Pprice) VALUES
	(1310, 'Mouse', 50.00),
	(1311, 'Keyboard', 100.00),
	(1312, 'HDD 250MB', 60.00),
	(1313, 'Printer 24pin', 81.00),
	(1314, 'TV 17', 250.00),
	(1315, 'Printer injekt', 135.00);


INSERT INTO sales(Scode, Pcode, Sdate, Ccode, Smcode, Quant, Cost) VALUES
	(10001,1310,'1993-06-10',100107,104,20,'800.00'),
	(10002,1313,'1993-07-12',100102,101,10,'700.00'),
	(10003,1312,'1993-03-15',100104,105,16,'760.00'),
	(10004,1310,'1993-04-21',100106,103,12,'400.00'),
	(10005,1310,'1992-12-02',100103,102,25,'1250.00'),
	(10006,1311,'1992-11-03',100107,104,30,'120.00'),
	(10007,1313,'1993-05-17',100105,104,20,'1600.00'),
	(10008,1312,'1993-02-12',100107,104,5,'100.00'),
	(10009,1310,'1992-12-02',100102,101,10,'500.00'),
	(10010,1311,'1992-11-03',100106,103,20,'80.00'),
	(10011,1313,'1993-04-04',100104,105,15,'1150.00');



    
    
    