CREATE DATABASE IF NOT EXISTS dbSCHOOL;
CREATE TABLE IF NOT EXISTS dbSCHOOL.tblStudent_Records(
	student_no INT NOT NULL, 
    first_name VARCHAR(45) NOT NULL, 
    middle_name VARCHAR(45) NOT NULL, 
    last_name VARCHAR(45) NOT NULL, 
    home_address VARCHAR(75) NOT NULL,
    permanent_address VARCHAR(75) NOT NULL,
    birthdate DATE NOT NULL,
    gender VARCHAR(45) NOT NULL,
    status VARCHAR(45) NOT NULL,
    nationality VARCHAR(45) NOT NULL,
    religion VARCHAR(45) NOT NULL,
    contact_no VARCHAR(11) NOT NULL,
	course VARCHAR(45) NOT NULL,
    year VARCHAR(45) NOT NULL,
    section VARCHAR(45) NOT NULL,
    PRIMARY KEY (student_no)
);