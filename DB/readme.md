
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
  
![WhatsApp Image 2021-12-14 at 7 19 22 PM](https://user-images.githubusercontent.com/89914089/146042462-304fe778-8dc0-4dea-aa53-fe7643433a8e.jpeg)

