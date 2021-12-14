
Queries 

login:
  student - [select * from student_table]
  faculty - [select * from faculty_table]
  
signup:
  insert into student_table (name, rollno, branch, year, password) values (%s, %s, %s, %s, %s);
  
student_homepage:
  get courselist - [select * from courses_list]
  
course page:
  get materials - select * from materials
  get assignments - select * from assignments 
  add materials 
  add assignments 
  
faculty_homepage: 
  courses - [select branch]
  grades -  [update grade]
  

                
