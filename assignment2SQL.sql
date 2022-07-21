create database academy;
use academy;
create table students(
id int auto_increment,
name varchar(40),
primary key(id)
);
create table courses(
id int auto_increment,
name varchar(40),
primary key(id)
);
create table school_operations(
op_id int not null auto_increment,
course_id int not null,
student_id int not null,
scores int not null,
primary key(op_id),
foreign key(course_id) references courses(id),
foreign key(student_id) references students(id)

);

show full columns in school_operations;
insert into students(name) values("rohan"),
("priyaansh"),("prince"),("pradnya");

insert into courses(name) values("science"),
("arts"),("commerce"),("politics");

 -- select * from courses; 
insert into school_operations(course_id,student_id,scores,course_date) values
(4,3,78,"2021-04-04"),
(3,4,56,"2021-04-06"),
(1,3,65,"2021-04-07"),
(2,4,98,"2021-05-08"),
(1,1,99,"2021-08-02"),
(2,4,56,"2021-02-03"),
(3,3,54,"2021-07-09"),
(4,4,34,"2021-03-23"),
(4,1,69,"2021-01-30");



-- --------------------------------------------------the main operations...............................................


-- 1. average of all the scores obtained by all students in any single given courses

select avg(scores) from school_operations where course_id = 1;

-- 2. Scorecard for any given student that shows all his scores for all of the courses

select school_operations.course_id as id , school_operations.scores as score , courses.name as "name of the course" from courses, school_operations where courses.id = school_operations.course_id and school_operations.student_id = 1;

-- 3. Scorecard for any given student that shows only his best score per course. (still getting doubt)
select school_operations.course_id as id , students.name as name, courses.name as "name of the course" from courses,school_operations,students  where school_operations.student_id = students.id and school_operations.scores = (select max(scores) from school_operations);

-- 4. Scorecard for any given student that shows only his latest score per course
select students.name as name , school_operations.scores as score , school_operations.course_date as "date" from school_operations, students, courses where students.id = 1 order by school_operations.course_date desc limit 1;

-- 5. The best score obtained (by any students) per course along with the name of the student. Kind of the like topper of each course.
select students.name as name , school_operations.scores as score , school_operations.course_date as "date" from school_operations, students, courses where students.id = 1 order by school_operations.scores desc limit 1;
