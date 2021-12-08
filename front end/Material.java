
public class Material {
    String date;
    String filename;
    
    static Material[] sample = new Material[3];
    static{
    sample[0] = new Material("20 May", "Lecture 1 - 5 Notes.pdf");
    sample[1] = new Material("21 May", "Lecture 2 - 10 Notes.pdf");
    sample[2] = new Material("22 May", "Recording.mp4");
    }

    Material (String date, String filename)
    {
	this.date = date;
	this.filename = filename;
    }
}
