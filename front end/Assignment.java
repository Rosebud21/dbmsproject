
public class Assignment{
    
    String title;
    String description;
    String deadline;
    boolean completed;
    
    static Assignment[] sample = new Assignment[3];
    // static{
    // sample[0] = new Assignment("homework 1", "Submit tutorial", "29 May");
    // sample[1] = new Assignment("homework 2", "Lab assignment", "30 May");
    // sample[2] = new Assignment("homework 3", "Submit notes", "2 April");
    // }
    
    Assignment(String title, String description, String deadline){
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.completed = false;
    }
 }
