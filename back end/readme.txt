
 WHAT IS AN API ?
 
an api is an application programming interface that acts like
a mediater between the client and the server .
-> in our project we've used a python backend  with the help of python apis.
-> this api has a set of request functions that it can perform such as GET ,POST.
->  in order to work with apis we must understand what an endpoint is 
- > an endpoint is a specific address that we refer to in order to get access to certain feautures. 
->   as you can observe below we refernce these apis with the functionality they provide as well as a list of arguments they hold:
   
Backend
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
                     it takes the student details as arguments and sends it to DB connector to store it into the database
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
                      Arguments : It takes the faculty details from the database and checks the  faculty credentials 
                       -> password 
                       -> eid
                      return=  res =  flask.Response("False")

              —--> /assignments/
               This api uses the POST method in order to add items/ assignments to the inventory as a faculty member.
               Arguments: it takes the assignment details and stores it in the assignment table.  
                                  -> Subcode 
                                  -> title
                                  -> description 
                                 -> deadline 
		 return str(database.create_assignments(assignment))
                            
                —>/assignments/  
                This api uses the GET method  in order to retrieve data from the assignments table. 
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
