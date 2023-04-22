SHOW databases;
create database capstone;
use capstone;
show tables;
create table Employee(EmployeeID integer Not null,EmployeeName 
varchar(50) NOT NULL,DateOfBirth date not null, 
primary key(EmployeeID));
describe Employee;
insert into Employee(EmployeeID,EmployeeName,DateOfBirth) 
values(101,"Sahil","2000-04-05");
select * from Employee;
alter table Employee drop column date_of_birth;
alter table Employee drop column employee_name;
alter table Employee drop column EmployeeName;
alter table Employee drop column DateOfBirth;
delete from Employee where EmployeeID=101;
insert into Employee(EmployeeID,EmployeeName,DateOfBirth) 
values(103,"Ritesh","2000-06-16");