

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


import javax.swing.JOptionPane;
 
public class Student_login1 extends JFrame implements ActionListener {
    JPanel panel;
    JFrame frame; 
    JLabel l;
    JLabel l1;
    JLabel l2;
    JTextField ta;
    JPasswordField p1;
    JButton b1;
    JButton b2;
    JButton b3;
    JCheckBox showPassword;
 
 
     Student_login1()
    {
       frame=new JFrame();
       frame.setTitle("STUDENT LOGIN");
       frame.setLayout(null);
       frame.getContentPane().setBackground(new java.awt.Color(0, 0, 102));
       frame.setSize(600,500);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.show();
       frame.setVisible(true);
       
      
        l=new JLabel("Student Login");
        l.setBounds(140,50,300,30);
        l.setForeground(Color.WHITE);
        l.setFont(new Font("Segoe UI Emoji",Font.BOLD,28));
        frame.add(l);
        l1=new JLabel("Roll Number:");
        l1.setBounds(100,150,100,30);
        l1.setForeground(Color.WHITE);
        frame.add(l1);
        l2=new JLabel("Password:");
        l2.setBounds(100,220,100,30);
        l2.setForeground(Color.WHITE);
        frame.add(l2);
        ta=new JTextField();
        ta.setBounds(200,150,150,30);
        frame.add(ta);
        p1=new JPasswordField();
        p1.setBounds(200,220,150,30);
        frame.add(p1);

        b1=new JButton("LOGIN");
        b1.setBounds(100,300,100,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(new java.awt.Color(51, 133, 255));
        frame.add(b1);
        b2=new JButton("SIGN UP");
        b2.setBounds(250,300,100,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(new java.awt.Color(51, 133, 255));
        frame.add(b2);
        b3=new JButton("BACK");
        b3.setBounds(175,370,100,30);
        b3.setForeground(Color.WHITE);
        b3.setBackground(new java.awt.Color(51, 133, 255));
        frame.add(b3);  

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);  
   }
  
    @Override
    public void actionPerformed(ActionEvent ae){

       //for login button
        if(ae.getSource()==b1){ 
			System.out.println("entered");
			String password = p1.getText();
			String id = ta.getText();
			System.out.println(id + " " + password);
			//Get Response  
			try {
				URL urlForGetRequest = new URL("http://localhost:5499/student/login/?id="+id.toString()+"&pass="+password);
				String readLine = null;
				HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
				conection.setRequestMethod("GET");
				int responseCode = conection.getResponseCode();
				System.out.println(responseCode);

				if (responseCode == HttpURLConnection.HTTP_OK) {
					BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
					StringBuffer response = new StringBuffer();
					while ((readLine = in .readLine()) != null) {
						response.append(readLine);
					} 
					in .close();
					String status = response.toString();
                              System.out.println(status);
                              if(status.toString().equals("True")){
                                    System.out.println("ok!!!");
                                    System.out.println(conection.getHeaderField("name"));
                                    String name = conection.getHeaderField("name");

                                    System.out.println(conection.getHeaderField("rollnumber"));
                                    String rollnumber = conection.getHeaderField("rollnumber");

                                    System.out.println(conection.getHeaderField("password"));
                                    String pass = conection.getHeaderField("password");

                                    System.out.println(conection.getHeaderField("year"));
                                    String year = conection.getHeaderField("year");

                                    System.out.println(conection.getHeaderField("branch"));
                                    String branch = conection.getHeaderField("branch");

                                    JOptionPane.showMessageDialog(null,"LOGIN SUCCESSFUL");

                                    Student s = new Student(rollnumber, name, pass, Integer.parseInt(year), branch);
                                    student_page page = new student_page(s);

                                    page.setVisible(true);
                                    frame.dispose();
                              }
                              else{
                                    System.out.println("errorrrr!!!");
                                    JOptionPane.showMessageDialog(null,"LOGIN FAILED.TRY AGAIN");    
                              }
				} else {
					System.out.println("GET NOT WORKED");
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
      	}
       //signupbutton
		if(ae.getSource() == b2){
			frame.dispose();
			Student_signup2 ss = new Student_signup2();
			ss.setVisible(true);
		}
       //backbutton
       if(ae.getSource() == b3){
             home_page page = new home_page();
             page.setVisible(true);
             frame.dispose();
           }
      }
}
  
   
          
   