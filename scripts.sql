create database bankmanagement;
show databases;
use bankmanagement;
create table signup(formno varchar(20),Name varchar(20),Father_Name varchar(20),DOB varchar(20),Gender varchar(20),Email varchar(30),Marital_Status varchar(20),Address varchar(40),City varchar(20),Pin_Code varchar(20),State varchar(25));
show tables;
delete from signup WHERE formno = 9122;
select * from signup;
DROP table signup;
create table signuptwo(formno varchar(20),religion varchar(20),Category varchar(20),Income varchar(20),Education varchar(20),Occupation varchar(30),Pan varchar(20),Aadhar varchar(40),Senior_Citizen varchar(20),Existing varchar(20));
select * from signuptwo;

