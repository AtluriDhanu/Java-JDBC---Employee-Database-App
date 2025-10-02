# Java JDBC - Employee Database App
A simple console-based app allows managing employee data by connecting to a MySQL database using JDBC. It provides a menu-driven interface for creating new employee records, viewing all employees, updating employee details like mobile number and deleting employee records. This app uses secure prepared statements to handle database operations.

## Features
- Add, view, update and delete employees.
- Use of preparedStatement to prevent SQL injections.
- Console-based user interaction.

## Technologies Used
- Java
- MySQL
- JDBC API
- Eclipse IDE, MySQL Workbench

## Project Structure
- EmployeeApp.java - Represents the main class with menu-driven user interactions, handles all CRUD operations (add, view, update, delete).
- DBConfig.java - Stores tha database connection details (url, username, password).
- lib/mysql-connector-j-9.4.0.jar - MySQL JDBC driver used for database connectivity.

## Steps to run
- Ensure MySQL server is running and create database 'company' with 'employee' table.
- Update 'DBConfig.java' with the database credentials.
- Add MySQLconnector (jar file) to 'lib' folder and include it in build path.
- Run 'EmployeeApp' in Eclipse IDE.
- Use console menu for CRUD operations.
