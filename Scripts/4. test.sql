SELECT USER FROM DUAL;

--DEPARTMENT
SELECT DEPTNO, DEPTNAME, FLOOR FROM DEPARTMENT;
SELECT DEPTNO, DEPTNAME, FLOOR FROM DEPARTMENT WHERE DEPTNO=1;
UPDATE DEPARTMENT
   SET DEPTNAME = '마케팅2', FLOOR = 10
 WHERE DEPTNO = 5;

DELETE FROM DEPARTMENT
 WHERE DEPTNO = 5;

--EMPLOYEE
SELECT EMPNO, EMPNAME, TITLE, MANAGER, SALARY, DNO FROM EMPLOYEE;
INSERT INTO EMPLOYEE VALUES(7777, '김인턴', '인턴', 4377, 1000000, 1);
DELETE FROM EMPLOYEE WHERE EMPNO = 7777;




CREATE USER spring_mybatis IDENTIFIED BY rootroot;

GRANT CONNECT, RESOURCE, CREATE SYNONYM, CREATE VIEW
TO spring_mybatis;
create table department (
deptno number not null,
deptname varchar2(50) not null,
floor number null,
primary key (deptno)
);

DROP TABLE EMPLOYEE;

create table employee (
empno number not null primary key,
empname varchar2(50) not null,
title varchar2(50) null,
manager number null,
salary number null,
dno number null,
foreign key(manager) references employee(empno),
foreign key(dno) references department(deptno)
);

