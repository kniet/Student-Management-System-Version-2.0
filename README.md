# Student-Management-System
Student Management System is a web application built using the Java Spring and Hibernate frameworks. It allows for the management of student informations and registration new users.

# Technologies:
* Spring MVC
* Spring Security
* Hibernate
* Java Server Pages (JSP)
* Tomcat
* Maven

# Requirements
To run this application, you will need:

* A Java Development Kit (JDK) 11 or above 
* A Java Integrated Development Environment (IDE) such as Eclipse or IntelliJ IDEA
* A web server that supports Java (such as Apache Tomcat)
* A MySQL database

# Installation
1. Clone this repository to your local machine 
2. Import the project into your IDE
3. Import the `sql-script.sql`, `sql-inserts.sql` and `sql-security.sql` files for create a new MySQL database
4. In `AppConfig.java`, set the database connection details. But if you did above steps then it should be configured already
5. In Tomcat configuration or any web server add war exploded file for deployment
6. Build and deploy the application to your web server

# Usage
To log into the application, use the username "admin" and password "admin" or username "kuba" and password "abc". Once logged in, you will be able to add, edit, search and delete students and view informations about them. You can also create new users through the registration panel. There is only one "admin" role, the rest of users have basic roles, so you can see how the authorization works.
