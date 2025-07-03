create database tripzy1;
use tripzy1;
drop database tripzy1;

create table users(
username varchar(50),
password varchar(50),
email varchar(50));
select * from users;

create table traveler(
id int primary key,
name varchar(50),
travel_num char(6),
phn_no char(10));
select * from traveler;

create table trip(
trip_id int primary key,
destination varchar(255),
start_date date,
end_date date,
id int,
foreign key(id) references traveler(id));
select * from trip;

create table expenses(
eid int primary key,
category varchar(255),
amount int unique,
edate date,
id int,
trip_id int,
foreign key(id)references traveler(id),
foreign key(trip_id)references trip(trip_id));
select * from expenses;



