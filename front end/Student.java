import java.util.ArrayList;
public class Student {
    public static ArrayList <Student> student_list = new ArrayList<>();
    public static void addStudent(Student s){
       student_list.add(s);
   }
    String roll;
    String name;
    String pwd;
    int year;
    String branch;
    Course[] courses = new Course[5];
    int attendance;
    double grade;
    
    static{
        Student s1 = new Student("101", "Shagufta", "xxx", 2, "CSE");
        s1.grade = 94;
        Student s2 = new Student("102", "Sneha", "xxx", 2, "CSE");
        Student s3 = new Student("103", "Sahithi", "xxx", 2, "EEE");
    }
    
    
    
    Student(String roll, String name, String pwd, int year, String branch){
        this.name = name;
        this.roll = roll;
        this.pwd = pwd;
        this.year = year;
        this.branch = branch;
        
        if (branch.equals("CSE")){this.courses = Course.CSE;}
        if (branch.equals("EEE")){this.courses = Course.EEE;}
        if (branch.equals("ME")){this.courses = Course.ME;}
        if (branch.equals("CE")){this.courses = Course.CE;}
        
        addStudent(this);
        
    }
}


