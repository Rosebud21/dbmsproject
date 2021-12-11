

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class addAssignment extends JFrame implements ActionListener {

	JFrame frame = new JFrame();
	Container container = getContentPane();
	JLabel heading = new JLabel("Add assignment");

    JLabel title = new JLabel("Title:");
    JLabel desc = new JLabel("Description:");
    JLabel deadline = new JLabel("Deadline:");
    JLabel course = new JLabel("Course:");

    JTextField title_field = new JTextField();
    JTextField desc_field = new JTextField();
    JTextField deadline_field = new JTextField();

    String courses[]={"CS 202","CS 203","CS 204","CS 205"};  
    JComboBox cb = new JComboBox(courses);  
    
    JButton addButton = new JButton("ADD");
    JButton cancelButton = new JButton("Back");

    addAssignment(){
     //constructor
    	initComponents();
        addComponents();
        addActionEvent();
    }

   public void initComponents(){
   		//initializes components
   		frame.setTitle("Login Form");
        frame.setBounds(10, 10, 400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        container.setBackground(Color.WHITE);
        container.setLayout(null);

        Font font1 = new Font("SansSerif", Font.BOLD, 24);
        heading.setFont(font1);

        //setting locations
        heading.setBounds(50, 70, 200, 30);
        title.setBounds(50, 150, 100, 30);
        desc.setBounds(50, 200, 100, 30);
        deadline.setBounds(50, 250, 100, 30);
        course.setBounds(50, 300, 100, 30);
        title_field.setBounds(150, 150, 150, 30);
        desc_field.setBounds(150, 200, 150, 30);
        deadline_field.setBounds(150, 250, 150, 30);
        cb.setBounds(150, 300, 150, 30);   
        addButton.setBounds(100, 350, 100, 30);
        cancelButton.setBounds(100, 400, 100, 30);
   }

   public void addComponents() {
        //adds components to the frame
        container.add(heading);
        container.add(title);
        container.add(desc);
        container.add(deadline);
        container.add(course);
        container.add(title_field);
        container.add(desc_field);
        container.add(deadline_field);
        container.add(cb);
        container.add(addButton);
        container.add(cancelButton);
        frame.add(container);
   	}

   	public void addActionEvent() {
   		//adding action listeners to buttons
        addButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == addButton) {
        	String a_title = title_field.getText();
        	String a_desc = desc_field.getText();
        	String a_deadline = deadline_field.getText();
            try {
                URL urlForGetRequest = new URL("http://localhost:5499/assignments/");
                String readLine = null;
                HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
                conection.setRequestMethod("POST");
                conection.setRequestProperty("Subcode", cb.getSelectedItem().toString());
                conection.setRequestProperty("Title", a_title);
                conection.setRequestProperty("Description", a_desc);
                conection.setRequestProperty("Deadline", a_deadline);
                int responseCode = conection.getResponseCode();
                System.out.println(responseCode);
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
                    ArrayList<String[]> assignments = new ArrayList<>();
                    StringBuffer response = new StringBuffer();
                    while ((readLine = in .readLine()) != null) {
                        String [] assignment = readLine.split(" ");
                        assignments.add(assignment);
                        response.append(readLine);
                    } 
                    in .close();
                    String status = response.toString();
                    System.out.println(status);
                    //resetting all textfields
                    JOptionPane.showMessageDialog(null, "Assignment added!");
                    title.setText("");
                    desc.setText("");
                    deadline.setText("");
                } else {
                    System.out.println("GET NOT WORKED");
                    JOptionPane.showMessageDialog(null, "Backend Error!");
                }
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        	//creating new assignment object
            // Assignment a = new Assignment(a_title, a_desc, a_deadline);
            // //adding assignment to respective course
            // if (cb.getSelectedItem().equals("CS 202")){
            // 	Course DLDCA = Course.CSE[0];
            // 	DLDCA.assign_list.add(a);
            // }
            // else if (cb.getSelectedItem().equals("CS 203")){
            // 	Course DAA = Course.CSE[1];
            // 	DAA.assign_list.add(a);
            // }
            // else if (cb.getSelectedItem().equals("CS 204")){
            // 	Course OOP = Course.CSE[2];
            // 	OOP.assign_list.add(a);
            // }
            // else if (cb.getSelectedItem().equals("CS 205")){
            // 	Course TOC = Course.CSE[3];
            // 	TOC.assign_list.add(a);
            // }


            // //resetting all textfields
            // JOptionPane.showMessageDialog(null, "Assignment added!");
        	// title.setText("");
        	// desc.setText("");
        	// deadline.setText("");

        }

        if (event.getSource() == cancelButton) {
            frame.dispose();
        } 
    }

    public static void main(String[] args){
    	addAssignment obj = new addAssignment();
    }

}