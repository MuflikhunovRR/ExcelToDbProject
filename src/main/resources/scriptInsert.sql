
INSERT INTO Person (id, First_name, Second_name, Birthday)
  SELECT id, First_name, Second_name, Birthday FROM PERSON_TEMP;

INSERT INTO Contacts (id, Phone, Phone_code, Email)
  SELECT id, Phone, Phone_code, Email FROM PERSON_TEMP;

INSERT INTO Employer (id, Company, Job, Hire_date, Salary)
  SELECT id, Company, Job, Hire_date, Salary FROM PERSON_TEMP;

INSERT INTO Vehicle (id, Car_mark, Car_model, Vin, Power, Year, Car_price)
  SELECT id, Car_mark, Car_model, Vin, Power, Year, Car_price FROM PERSON_TEMP;

INSERT INTO Documents (id, Passport_number, Born_country, State)
  SELECT id, Passport_number, Born_country, State FROM PERSON_TEMP;