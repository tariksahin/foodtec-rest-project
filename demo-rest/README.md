**About the task**

Offers a search for users for the above some criterias and which returns a list of resources in JSON format<br />



**Tech Stack**

Java 11<br />
Maven<br />
Spring Boot 2.7.4<br />
H2<br />
REST Web Service<br />


**Installation**

Open the project in any IDE like Intellij, eclipse etc.
After all requirements are loaded and the project is ready, start it.

	- /DB
	you can access the db with this endpoint. DB access informations;
	driver class: org.h2.Driver
	url: jdbc:h2:mem:userdb
	user name: tarik
	password: tarik	
	
	
	After login, you should add dummy data. You can run the following insert query to addition.
	
	INSERT INTO users(id, email, income, name, password,phone, registration_date) VALUES ('1', 'tariksahin01@gmail.com', '1111', 'tarik', 'tarik', '05425904849','2022-10-11 10:10:10');

	INSERT INTO users(id, email, income, name, password,phone, registration_date) VALUES ('2', 'tariksahin02@gmail.com', '2222', 'foodtec', 'foodtec', '05425904850','2022-10-12 10:10:10');

	INSERT INTO users(id, email, income, name, password,phone, registration_date) VALUES ('3', 'tariksahin03@gmail.com', '3333', 'vangelis', 'vangelis', '05425904851','2022-10-13 10:10:10');



	- /list-users
	Thanks to this endpoint, you can search with/without criterias among the added users.
	If you don't add any criteria, it returns all users. (http://localhost:8080/list-users)
	If you add criteria(s), it returns the user(s) with filtered parameter(s).
	You can search with all combination of criteria fields. Fields are; name, registrationDate, income
	Here's some examples how they are called;
	(http://localhost:8080/list-users?name=tarik) 
	(http://localhost:8080/list-users?income=1000)
	(http://localhost:8080/list-users?name=foodtec&registrationDate=11.10.2022)
	(http://localhost:8080/list-users?name=vangelis&registrationDate=10.10.2022&income=1000)
	
	
**Bonus Points**
Project is designed to accommodate future extensions. If an extra search criteria is desired, it can be simply added. <br />
Sensitive information data is masked in service layer. Except last 3 digits for phone number, all characters for password. <br />
Logback logging <br />
