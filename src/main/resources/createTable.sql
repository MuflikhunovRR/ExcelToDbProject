-- Create TABLE
CREATE TABLE PERSON_TEMP (
  id INT(11) NOT NULL AUTO_INCREMENT,
  First_name VARCHAR(150),
  Second_name VARCHAR(150),
  Phone VARCHAR(150),
  Phone_code INT(150),
  Passport_number INT(150),
  Born_country VARCHAR(150),
  Birthday DATE,
  Email VARCHAR(150),
  Company VARCHAR(150),
  Job VARCHAR(150),
  Salary INT(150),
  State VARCHAR(150),
  Car_mark VARCHAR(150),
  Car_model VARCHAR(150),
  Vin VARCHAR(150),
  Power INT(150),
  Year DATE,
  Car_price INT(150),
  Hire_date DATE,
  PRIMARY KEY (id)
);

DROP TABLE PERSON_TEMP;

SELECT * FROM PERSON_TEMP;

DELETE FROM PERSON_TEMP;

-- Insert data
INSERT INTO COUNTRY_CATALOG VALUES (id, 'Afghanistan', 'LOS ANGELES INTL', 'United States', 'US', '123', 1, 5, 'weg');


-- Create other table
CREATE TABLE Person (
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  First_name VARCHAR(150),
  Second_name VARCHAR(150),
  Birthday DATE,
);

CREATE TABLE Contacts (
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Phone VARCHAR(150),
  Phone_code INT(150),
  Email VARCHAR(150),
  FOREIGN KEY (id) REFERENCES Person(id)
);

CREATE TABLE Employer (
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Company VARCHAR(150),
  Job VARCHAR(150),
  Hire_date DATE,
  Salary INT(150),
  FOREIGN KEY (id) REFERENCES Person(id)
);

CREATE TABLE Vehicle (
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Car_mark VARCHAR(150),
  Car_model VARCHAR(150),
  Vin VARCHAR(150),
  Power INT(150),
  Year DATE,
  Car_price INT(150),
  FOREIGN KEY (id) REFERENCES Person(id)
);

CREATE TABLE Documents (
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Passport_number INT(150),
  Born_country VARCHAR(150),
  State VARCHAR(150),
  FOREIGN KEY (id) REFERENCES Person(id)
);