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
                  API's
                  --> /hello/ 
                    this api is use to test the api status it has GET and POST methods
		        return "Hello World!"

                  -->/student/login/
                    this api is used to verify the student login. It takes roll number and password as arguments and verifies if the student is registered by scanning the                          student database.
                      Arguments: -> password 
                                 -> Rollnum
				 res =  flask.Response("False")
		   
				  
                 --> /student/signup/
                     this api is used to create a new student user  using GET AND POST methods 
                     it takes the student details as arguments and sends it to DB connector to                         store it into the database
                       Arguments: -> rollno
                                -> name 
                               -> password 
                                ->   year 
                               -> branch 
			 
	                       return str(database.insert_students(students))    

                 --->/student/getall/
                    This api uses the GET method  
                       Arguments: ->name 
                               -> rollnum
                               -> year 
                              -> grade
			      return=  res =  flask.Response(out)
        
               —> /Faculty/login/ 
                 This api uses the GET and POST method
                      Arguments : It takes the faculty details from the database and checks the                       faculty credentials 
                       -> password 
                       -> eid
                      return=  res =  flask.Response("False")

              —--> /assignments/
                This api uses the POST method in order to add items/ assignments to the inventory                     as a faculty member.
               Arguments: it takes the assignment details and stores it in the assignment table.  
                                  -> Subcode 
                                  -> title
                                  -> description 
                                 -> deadline 
		 return str(database.create_assignments(assignment))
                            
                —>/assignments/  
                This api uses the GET method  in order to retrieve data from the assignments                          table. 
                      Arguments: it verifies with the subcode and displays data
                                  —>subcode 
                res =  flask.Response(out)
                return res

                 —-->    /materials/ 
                       This api is used with a GET function to retrieve information from the materials table in order to display data. 
                        Arguments: it uses subcode to verify 
                                —> subcode
                       return= res =  flask.Response(out)  
				  
                                 
                   —---> / materials/   
                       This api uses the POST function to add data into the materials table 
                      Arguments: -> subcode 
                                 -> filename 
                                 -> date
                              return str(database.create_material(material))        

	
	c.  Database
            
            	1.1 Student_details:  contains the  student signup information
			     - sno 	  int
                             - name       varchar (50)
                             - year       int 
                             - rollno     unique varchar, primary key 
                             - branch     varchar (cse or eee) (also used to see faculty)
			     - password   varchar (4)
			    
		1.2 Assignments: allows students to upload assignments that faculty can see 
			    - subject_code
			    - title
			    - description
			    - deadline
 		
         	2.1 Faculty_table: contains the faculty details, used at login time. 
				- sno 
              			- eid      primary key unique varchar
             			- branch  varchar(cse or eee) 
            			- name    varchar (50)
           		        - pwd     varchar (9)
				
		2.2  Faculty_grade: enables faculty to give students grades 
        			- roll no    foreign key  UNIQUE varchar (8) { uses student rollno as           primary key to display grade on page)}
         			- cgpa      int 
				
		2.3 material:
				- subject_code		(foreign key)
				- filename		
				- date
			
		2.4 Faculty subjects:
				- eid
				- subject_code
				
		3.1 Course_list:
				- branch
				- subject_code
				- year
				- name
			
		3.2 Academics:
				- rollnum
				- attendance
				- grade 
 
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
