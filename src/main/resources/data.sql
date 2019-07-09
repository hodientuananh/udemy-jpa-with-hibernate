/*
create table person
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key (id)
);
*/

insert into person(id, name, location, birth_date) values
(1000, 'zero', 'Vietnam', sysdate());
insert into person(id, name, location, birth_date) values
(1001, 'one', 'Vietnam', sysdate());
insert into person(id, name, location, birth_date) values
(1002, 'two', 'Vietnam', sysdate());

insert into course(id, name, created_date, last_updated_date) values
(1000, 'Spring with Jpa', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) values
(1001, 'Spring with Hibernate', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) values
(1002, 'Spring with Junit', sysdate(), sysdate());

insert into passport(id, number) values
(1000, 'A1000');
insert into passport(id, number) values
(1001, 'B1000');
insert into passport(id, number) values
(1002, 'C1000');

insert into student(id, name, passport_id) values
(1000, 'Student 1', 1000);
insert into student(id, name, passport_id) values
(1001, 'Student 2', 1001);
insert into student(id, name, passport_id) values
(1002, 'Student 3', 1002);

insert into review(id, rating, description, course_id) values
(1000, '5', 'Great Course', 1000);
insert into review(id, rating, description, course_id) values
(1001, '4', 'Average Course', 1000);
insert into review(id, rating, description, course_id) values
(1002, '3', 'Low Course', 1001);

insert into student_course(student_id, course_id) values
(1000, 1000);
insert into student_course(student_id, course_id) values
(1000, 1001);
insert into student_course(student_id, course_id) values
(1000, 1002);
insert into student_course(student_id, course_id) values
(1001, 1002);