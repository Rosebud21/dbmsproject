


import java.util.ArrayList;


public class Faculty {
    
    
    public static ArrayList <Faculty> fac_list = new ArrayList<>();
    
    public static void addFaculty (Faculty f){
       fac_list.add(f);
   }
    
    String eid;
    String name;
    String pwd;
    String branch;
    Course[] courses = new Course[5];

    static Faculty f1 = new Faculty("123", "Rohan", "xyz", "CSE");
    static Faculty f2 = new Faculty("456", "Sheela", "xyz", "EEE");
    
    Faculty(String eid, String name, String pwd, String branch){
        this.eid = eid;        
        this.name = name;
        this.pwd = pwd;
        this.branch = branch;
        if (branch.equals("CSE")){this.courses = Course.CSE;}
        if (branch.equals("EEE")){this.courses = Course.EEE;}
        if (branch.equals("ME")){this.courses = Course.ME;}
        if (branch.equals("CE")){this.courses = Course.CE;}
        addFaculty(this);
    }
}



