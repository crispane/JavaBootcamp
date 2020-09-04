CREATE database sales
DEFAULT CHARACTER SET utf8;
use sales;

create table customer(
ccode int unsigned auto_increment,
cname varchar(20) not null,
primary key (ccode)
);

create table salesman(
scode int unsigned not null,
sname varchar(20) not null,
scity varchar(15) null,
scomm decimal(5,2) unsigned null,
primary key (scode)
);

ALTER TABLE salesman
MODIFY COLUMN scode int unsigned auto_increment; 
-- drop table salesman;
-- desc salesman;

create table product(
pcode int unsigned primary key auto_increment,
pdescr varchar(45) not null,
pprice decimal(7,2) unsigned default 0
);

create table family(
fname varchar(20) not null,
frelationship varchar(20),
dob date,
salesman int unsigned null,
constraint fk_family foreign key (salesman)
references salesman (scode) 
);
-- desc family;

ALTER TABLE family
DROP FOREIGN KEY fk_family;
 
alter table family
add constraint fk_family foreign key (salesman)
references salesman (scode) on delete cascade;

create table sales(
scode int unsigned primary key auto_increment,
smcode int unsigned not null,
ccode int unsigned not null,
pcode int unsigned not null,
quant int unsigned default 0,
cost decimal(7,2) default 0,
sdate date,
constraint fk_saleman foreign key (smcode)
references salesman (scode),
constraint fk_customer foreign key (ccode)
references customer (ccode),
constraint fk_product foreign key (pcode)
references product (pcode)
);

insert into customer (ccode, cname) 
values (100102, 'Aleksiadis'),
(100103, 'Papadopoulos'),
(100104, 'Ioannou'),
(100105, 'Apostolou'),
(100106, 'Papamarkou'),
(100107, 'Drakopoulos');
select * from customer;

insert into salesman (sname, scode, scity, scomm)
values ('Antoniou', 101, 'Athens', 0.14),
('Dimou', 102, 'Athens', 0.15),
('Vasileiou', 103, 'Patra', 0.17),
('Raptis', 104, 'Thessaloniki', 0.16),
('Lamprinakis', 105, 'Irakleio', 0.15);

select * from salesman;
-- delete from salesman ;

-- set SQL_SAFE_UPDATES = 1;
insert into product (pcode, pdescr, pprice) 
values (1310, 'Mouse', 50.00),
(1311, 'Keyboard', 100.00),
(1312, 'HDD 250MB', 60.00),
(1313, 'Printer 24pin', 81.00),
(1314, 'TV 17', 250.00),
(1315, 'Printer injekt', 135.00);
select * from product;

insert into family(fname, frelationship, dob, salesman) 
values ('George', 'son', '1981-02-11', 101),
('Mary', 'wife', '1977-12-11', 101);
select * from family;

insert  into `sales`(`Scode`,`Pcode`,`Sdate`,`Ccode`,`Smcode`,`Quant`,`Cost`) 
values (10001,1310,'1993-06-10',100107,104,20,'800.00'),
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

select * from sales;
-- insert into sales (SCode, smcode, ccode, pcode) 
-- values (1, 101, 100107, 1310);
-- delete from sales where scode = 1;
