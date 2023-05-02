create database apm;
  show databases;
  use apm;
  

CREATE TABLE Clients (
  clientId INT(10) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  POC_Fullname VARCHAR(100) NOT NULL,
  POC_PhoneNumber VARCHAR(16) NOT NULL,
  POC_EmailAddress VARCHAR(100) NOT NULL,
  PRIMARY KEY(clientId),
  CHECK (LENGTH(Name) >= 3)
);


CREATE TABLE Projects (
  project_code INT(10) NOT NULL AUTO_INCREMENT,
  title VARCHAR(50) NOT NULL,
  budget INT(10) NOT NULL,
  start_date DATE NOT NULL,
  expected_end_date DATE NOT NULL,
  created_on DATE NOT NULL,
  status VARCHAR(20) NOT NULL,
  last_updated_on DATE,
  client_id INT(10) NOT NULL,
  PRIMARY KEY(ProjectCode),
  FOREIGN KEY(client_id) REFERENCES Clients(client_id),
  CHECK (LENGTH(title) >= 3),
  CHECK (expected_end_date > start_date),
  CHECK ( status IN ('New', 'InProgress', 'Completed', 'Delayed', 'Cancelled'))
);




CREATE TABLE Resources (
  user_id VARCHAR(6) NOT NULL,
  firstName VARCHAR(15) NOT NULL,
  lastName VARCHAR(15) NOT NULL,
  email VARCHAR(50) NOT NULL,
  phoneNumber VARCHAR(10) NOT NULL,
  role VARCHAR(20) NOT NULL,
  projectCode INT(10) NOT NULL,
  PRIMARY KEY(user_id),
  FOREIGN KEY(projectCode) REFERENCES Projects(projectCode),
   CHECK (LENGTH(firstName) >= 3),
   CHECK (LENGTH(lastName) >= 3),
  CHECK (LENGTH(user_id) = 6),
  CHECK (role IN ('Developer', 'Tester'))
);




INSERT INTO Clients (name, POC_Fullname, POC_PhoneNumber, POC_EmailAddress)
VALUES 
  ('ABC COMPANY', 'John Smith', '964218743', 'john@example.com'),
  ('XYZ COMPANY', 'Adam Mathews', '7423148964', 'adam@example.com'),
  ('PQR COMPANY', 'Steve Cole', '7621348971', 'cole@example.com');
  
  

select * from Projects;
select * from Clients;
select * from Resources;

  
  


  
  
  
  
  




