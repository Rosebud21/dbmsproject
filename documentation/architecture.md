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
         	-> The user can also find a signup option on the login page in  order to enroll themselves in a new course by providing more details (more about this in the 			    student signup).
		
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
      
		iii. DB connectors -
 		   -> we will be implementing predefined python db apis which will be consistent and specific to the postgresql framework for databases that we have used.
		   -> PostgreSQL --  psycopg, PyGresQL, and pyPgSQL
		    ->we've used psycopg which is a python library to communicate with the postgresql server.
                    -> PostgreSQL can be integrated with Python using psycopg2 module.
		    -> import the sycopg2 moudule 
		    -> import the confiparser module into the config.py program.
		     -> confiparser gives the option to manage user-editable configuration files for an application.
		    -> sycopg2 is a PostgreSQL database adapter for the Python programming language.
		    -> configure-confi.py helps in connecting with the database which is then imported into the connection.py
		    -> cursor- we create a cursor object which enables a cursor to be created.
		    
	b. Backend
		i. API endpoints, incoming parameters, responses, and functions:

			/hello/ 
                        This API is use to test the api status. It has GET and POST methods.

                        /student/login/
                        This API is used to verify th student login. It takes the arguments rollnumber and password and finds out if the user is registered or not. 

                        /student/signup/
                        This API is used to create a new student user. It takes the student details as arguments and sends it to DB connector to store it into the database.

                         /student/getall/
 
		
		ii. Features
		iii. DB Connectors
 
	c.  Database
       	

           	1. Student tables: 
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
               
 		2. Faculty tables :
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
	   For the database, we will be implementing a database using postgresql, consisting of tables ,schemas and  databases.
	
	ii. CONNECTOR DIAGRAM
		

![apipython](https://user-images.githubusercontent.com/89914089/145981025-3af154ce-d708-444a-ae5a-aceef3aca21b.jpg)	
		
		
		
		
		
		
		
		
		
		
	iii. TREE DIAGRAM PICTURE
 ![treediagram](https://user-images.githubusercontent.com/89914089/145980719-83fe3a3d-ab3c-40e3-8251-95b3a006875c.jpg)

	       
	  
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	iV. ER Diagram 
	
![erdiagram](https://user-images.githubusercontent.com/89914089/145980099-8921de81-9679-4e06-a7c0-5210973d7262.jpg)
