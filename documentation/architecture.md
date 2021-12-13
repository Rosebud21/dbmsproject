Architecture for Virtual Classroom 

	By:
		Sneha Potluri (19XJ1A0572)
		Sahithi Josyula (19XJ1A0562)
		Enuganti Manushree (19XJ1A0523)

	a. Frontend
		i and ii. Pages and their Features 

                HOMEPAGE: This is the very first thing that appears when a user runs the application.
             	Here, you can choose between logging in as a student or a faculty member. 
             	Upon clicking either faculty or student you will be directed to the respective login page.
        	STUDENT LOGIN PAGE:
          	-> The student will be asked to provide their student id/rollno .and password 
         	-> If the password and id are present in the database, and match the login requirements, the user will be directed to the student dashboard.
         	-> The user can also find a signup option on the login page in  order to enroll themselves in a new course by providing more details (more about this in the student signup).
       		FACULTY LOGIN PAGE:
        	-> A faculty member trying to login must enter their unique id and password in order to access their faculty dashboard. 
		STUDENT SIGNUP PAGE:
        	-> A student can signup or enroll in their course and access course content.
       		-> They have to fill in the following fields: name, year, rollno, course, branch, password. 
       		-> After signing up a user will be able to access the student dashboard. 
      		STUDENT DASHBOARD:
       		-> a student can view their courses as different tabs with the java tabbed pane.
      		-> they can view the upcoming assignments and view their  course timetable.        
         	FACULTY DASHBOARD:
      		-> Faculty members can view their courses as tabbed panes similar to the student dashboard.
 		-> They can view their timetable for the day, their grades, and see what assignments they have due. 
      
		iii. DB connectors - How we will connect My SQL(backend) with our front end (java)
 		- First we import the library from our database then we import the class with a table model. 
		- A catch block needs to be added here for errors and expectations. 
		- Then the driver class needs to be loaded in which connection object should be created for My SQL. 
		- A statement object should be created after. 
		- Now we must  pass SQL queries through a table model after which all the executable queries are stated. 
		- All the results for the queries passed are then stored in ResultSet. 
		- And then a loop can be created to display the data from the database.

	b. Backend
		i. API endpoints
		ii. Features
		iii. DB Connectors
 
	c.  Database
       		We will be maintaining separate databases as that makes it easier for data abstraction and efficiency is optimised when we handle smaller tables.

           	1. Student database: 
            	Tables:
            	1.1 Student_details:  contains the  student signup information
                             - name       varchar (50)
                             - year       int 
                             - rollno     unique varchar, primary key 
                             - course     varchar (cse or eee) (also used to see faculty)
                           
            	1.2 Student_login: contains the login essentials          
                            - rollno        unique varchar, foreign key(connection between two tables) 
                            - pwd           varchar
		1.3 Assignments: allows students to upload assignments that faculty can see 
			    - course 
			    - rollno
			    - id
			    - date
			    - assignment 
               
 		2. Faculty database
 		Tables:
         	2.1 Faculty_details: contains the faculty details, used at login time. 
              			- id      primary key unique varchar
             			- course  varchar(cse or eee) 
            			- name    varchar (50)
           		        - pwd     varchar (9)
		2.2  Faculty_grade: enables faculty to give students grades 
        			- roll no    foreign key  UNIQUE varchar (8) { uses student rollno as           primary key to display grade on page)}
         			- cgpa      int 
		2.3 Course_materials:
				- course		(foreign key)
				- id			(primary key)
				- date
				- course_material
 
 	d. Overview 

	This is an attempt at creating a virtual platform that encompasses all academic schedules and coursework ensuring a holistic online learning experience. It’s a one-stop online portal to access coursework and academics. 
	We will be designing an application that enables the academic community at MU to  have an uncomplicated mechanism while accessing academic details.
	Especially during the coronavirus pandemic, online platforms have proven to provide an enhanced academic experience for students and faculty. 
	It can get chaotic to keep track of course materials, projects, schedules, and deadlines without an application like this. 

	i. We will be using a java gui based front end. Further, we will be connecting the java front end using java connectors and ensuring a dynamic data access and display mechanism.
	   For the database, we will be implementing a database using mysql, consisting of tables ,schemas and multiple databases.
	
	ii. CONNECTOR DIAGRAM
		![api python](https://user-images.githubusercontent.com/89914089/145883048-45d7614f-b5d2-4e84-b3c5-755929610411.jpg)
		
	iii. TREE DIAGRAM PICTURE
             ![tree diagram ](https://user-images.githubusercontent.com/89914089/145883067-aa8f4a54-b2f3-472a-8cc0-937d00367e34.jpg)
	       
	iV. ER Diagram 
	[erdiagram (1).pdf](https://github.com/Rosebud21/dbmsproject/files/7706745/erdiagram.1.pdf)

 
