select * from salesman;

select * from salesman where scity = 'Patra';
select * from salesman where not scity = 'Patra';
select * from salesman where (scity = 'Athens') and (scomm > 0.14);
select distinct scity from salesman;
select * from salesman where scomm between 0.15 and 0.17;
select * from salesman where scity in ('Athens', 'Patra');
select sname, scomm, (1.20*scomm) from salesman where scity = 'Athens';
select * from salesman where scity = 'Athens' and sname LIKE 'A%';
select * from salesman order by scomm desc;
