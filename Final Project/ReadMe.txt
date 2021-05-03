This assignment is in two parts java api and angular frontend and both the parts have to run simultaneously for the project to work.
Note : Disconnect from nagarro vpn before running the project since the mail service does not work on this vpn.

First execute the following sql statements to create the database,required tables and admin account :-

For the user table and the admin account :-

create database TravelPortalDb;

use TravelPortalDb;
create table User(
id int primary key auto_increment ,
firstname varchar(255) ,
lastname  varchar(255) ,
buisnessunit varchar(255) ,
title varchar(255) ,
email varchar(255) ,
telephone varchar(255) ,
address1 varchar(255) ,
address2 varchar(255) ,
city varchar(255) ,
state varchar(255) ,
zip varchar(255) ,
country varchar(255) ,
password varchar(255) ,
usertype varchar(255),
ticketdate varchar(255)
);

insert into user(email,password,usertype) values("2017003126.himanshu@ug.sharda.ac.in","IJpXmFdU","admin");



use travelportaldb;
create table Ticket(
tid int primary key auto_increment,
requesttype varchar(255),
priority varchar(255),
travelcity varchar(255),
fromcity varchar(255),
startdate varchar(255),
enddate varchar(255),
passportnumber varchar(255),
projectname varchar(255),
expenseby varchar(255),
travelapprovername varchar(255),
duration varchar(255),
upperbound varchar(255),
otherdetails varchar(255),
comments text,
status varchar(255),
uid int

)



The admin account is hard coded and copy the id and passowrd form data base to login as an admin.
For loggin in as the user first go to signup and you will recieve the password on you email and the username will be same as
email and enter a valid email id to get the password.

Run the java backend as the spring boot application and for running the angular first install the modules by npm i

