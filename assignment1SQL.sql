create database rohan_assignment;
use rohan_assignment;
create table employees (
id int not null unique auto_increment,
name varchar(45),
email varchar(50) unique,
contact varchar(50),
primary key (id)
);
insert into employees(name,email,contact)
values(
"rohan","cvb3rho@gmail.com","8888151997"
),
("reyansh","abcde@gmail.com","4545454545"),
(
"rajat","xyz@gmail.com","212121212"
);

select * from employees;