drop database if exists EmployerDB_Test;
create database EmployerDB_Test;
use EmployerDB_Test;

CREATE TABLE Employee (
         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
         firstName VARCHAR(100),
		 middleName VARCHAR(100),
		 lastName VARCHAR(100),
		 skype VARCHAR(100),
		 tel VARCHAR(100),
		 email VARCHAR(100)
       );

CREATE TABLE DayOff(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	employee_id INT,
	`from` Timestamp,
	`to` Timestamp,
	Description VARCHAR(255),
	DayOffType SMALLINT,

	FOREIGN KEY (employee_id) REFERENCES Employee(id)
);

CREATE TABLE ProjectHistory(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	employee_id INT,
	`from` DATETIME,
	`to` DATETIME,
	projectName VARCHAR(255),
	role SMALLINT,

	FOREIGN KEY (employee_id) REFERENCES Employee(id)

);