-- create database sales;
-- use sales;
-- CREATE TABLE SCHEMA
CREATE TABLE if not exists products (
	-- <field_name> <data_type> <constraints>,
    pcode INT AUTO_INCREMENT PRIMARY KEY,
    pdescr VARCHAR(45) NOT NULL,
    pprice DECIMAL(7,2)
);

INSERT INTO products(pcode, pdescr, pprice) VALUES(1,'keyboard', 15.10);
INSERT INTO products(pdescr, pprice) VALUES('TV Monitor', 105.20);
INSERT INTO products(pdescr, pprice) VALUES('mouse', 5.20), ('battery', 15.30), ('camera', 20.80), ('RAM', 30.00), ('Hard Disk', 15.00);
INSERT INTO products(pdescr, pprice) VALUES('SSD Disk', 80.00);

SELECT * FROM products;

SELECT * 
FROM products 
WHERE pcode = 1;

SELECT * FROM products WHERE pdescr = 'TV Monitor';

DELETE FROM products WHERE pcode > 2;

SELECT pdescr FROM products WHERE pprice > 10;

SELECT pprice
FROM products
WHERE pdescr = 'Mouse';

SELECT * 
FROM products
WHERE pdescr LIKE '%disk%';

UPDATE products
SET pprice = 30
WHERE pdescr = 'HArd disk';

SET SQL_SAFE_UPDATES = 0;

SELECT pprice FROM products WHERE pdescr='mouse';

DROP DATABASE sales;