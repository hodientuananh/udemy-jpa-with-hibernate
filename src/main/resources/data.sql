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

insert into course(id, name) values
(1000, 'Spring with Jpa');
insert into course(id, name) values
(1001, 'Spring with Hibernate');
insert into course(id, name) values
(1002, 'Spring with Junit');