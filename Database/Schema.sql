DROP DATABASE IF EXISTS EmployerDB_Test;
CREATE DATABASE EmployerDB_Test;
USE EmployerDB_Test;

CREATE TABLE Employee (
  id             INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  firstName      VARCHAR(100),
  middleName     VARCHAR(100),
  lastName       VARCHAR(100),
  skype          VARCHAR(100),
  tel            VARCHAR(100),
  email          VARCHAR(100),

  lastUpdateDate TIMESTAMP NOT NULL,
  isArchieved     BIT NOT NULL DEFAULT 0
);

CREATE TABLE DayOff (
  id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  employee_id INT NOT NULL,
  `from`      TIMESTAMP,
  `to`        TIMESTAMP,
  Description VARCHAR(255),
  DayOffType  SMALLINT,

  FOREIGN KEY (employee_id) REFERENCES Employee (id)
);

CREATE TABLE ProjectHistory (
  id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  employee_id INT NOT NULL,
  `from`      TIMESTAMP,
  `to`        TIMESTAMP,
  projectName VARCHAR(255),
  role        SMALLINT,

  FOREIGN KEY (employee_id) REFERENCES Employee (id)

);