# JSPwithDatabase

This app was built with JSP (Java Server Pages) using Apache Tomcat v9.0 with MySQL database.
This was a team effort with help from Anthony Meyer, Casey Thimm, and Tanner Lory. 

![webpage_full](https://user-images.githubusercontent.com/39227780/63535690-aebac800-c4d7-11e9-91bd-d7ec6b2d7677.png)

Database Schema
----------------
Alumni(alumniID(primary key), first_name, last_name, email, phone, linkedIn, grad_student(boolean), employed(boolean))

Degree(degreeID(primary key), type, major, minor, honors, graduation, alumniID(foreign key))

Employee(employeeID(primary key), position, starting_salary, start_year, end_year, employerID(foreign key))

Employer(employerID(primary key), employer, city, state, feedback)

School(schoolID(primary key), school, city, state)

Student(studentID(primary key), degree_desired, schoolID(foreign key))

