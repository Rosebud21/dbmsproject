import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    public void actionPerformed(ActionEvent ae) 
       {
       //for login button
        if(ae.getSource()==b1)
       { 
        //System.out.println("entered");
        String password = p1.getText();
         String id = ta.getText();
         boolean found=false;
          
            
         try{
            Class.forName("com.mysql.jdbc.Driver");  
               Connection con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/student","root","ivansj2102");   
           Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from Student_signup");  
       while(rs.next())
        {  
           String rollno=rs.getString(2);
          String pwd=rs.getString(5);
          if(rollno.equals(id) && pwd.equals(password))
             {
                 JOptionPane.showMessageDialog(null,"LOGIN SUCCESSFUL");
                 student_page page = new student_page();
                 page.setVisible(true);
                 found = true;
                 frame.dispose();
                 break;
              
            }
          }
           con.close();  
            }
         
          catch(Exception ae1)
          { 
            System.out.println(ae1);
             }  
 
          if(found == false)
          {
            JOptionPane.showMessageDialog(null,"LOGIN FAILED.TRY AGAIN");    
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
  
   
          
   