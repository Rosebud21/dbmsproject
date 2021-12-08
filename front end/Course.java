

import java.util.ArrayList;

public class Course {
    
   String name;
   String code;
   int year;
   String branch;
   ArrayList <Assignment> assign_list = new ArrayList<>();
   ArrayList <Material> mat_list = new ArrayList<>();
   
    
    Course(String name, String code, int year, String branch){
        this.name = name;
        this.code = code;
        this.year = year;
        this.branch = branch;
        
        for (Assignment a: Assignment.sample){
            this.assign_list.add(a);
        }
        for (Material m: Material.sample){
            this.mat_list.add(m);
        }
    }
    
    public static Course[] CSE = new Course[5];
    public static Course[] EEE = new Course[5];
    public static Course[] ME = new Course[5];
    public static Course[] CE = new Course[5];
    
    static{

        CSE[0] = new Course("Digital Design Logic", "CS 202", 2, "CSE");
        CSE[1] = new Course("Design and Analysis of Algorithms", "CS 203", 2, "CSE");
        CSE[2] = new Course("Object Oriented Programming", "CS 204", 2, "CSE");
        CSE[3] = new Course("Theory of Computation", "CS 205", 2, "CSE");
        CSE[4] = new Course("Numerical Methods", "ES 211", 2, "ALL");

        EEE[0] = new Course("Digital Electronics", "EE 205", 2, "EEE");
        EEE[1] = new Course("Linear Electronics", "EE 206", 2, "EEE");
        EEE[2] = new Course("Digital Signal Processing", "EE 207", 2, "EEE");
        EEE[3] = new Course("Electronmagnetic Waves", "EE 208", 2, "EEE");
        EEE[4] = new Course("Numerical Methods", "ES 211", 2, "EEE");
        
    } 
}
    

    
    