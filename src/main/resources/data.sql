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

insert into course(id, name, created_date, last_updated_date, is_deleted) values
(1000, 'Spring with Jpa', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) values
(1001, 'Spring with Hibernate', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) values
(1002, 'Spring with Junit', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) values
(1003, 'Spring with Angular', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) values
(1004, 'Spring with Redix', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) values
(1005, 'Spring with Facebook', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) values
(1006, 'Spring with Twitter', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) values
(1007, 'Spring with Google', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) values
(1008, 'Spring with Ionic', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) values
(1009, 'Spring with Firebase', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) values
(1010, 'Spring with Github', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) values
(1011, 'Spring with Eclipse', sysdate(), sysdate(), false);

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
(1000, 'FIVE', 'Great Course', 1000);
insert into review(id, rating, description, course_id) values
(1001, 'FOUR', 'Average Course', 1000);
insert into review(id, rating, description, course_id) values
(1002, 'THREE', 'Low Course', 1001);

insert into student_course(student_id, course_id) values
(1000, 1000);
insert into student_course(student_id, course_id) values
(1000, 1001);
insert into student_course(student_id, course_id) values
(1001, 1001);