
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.sql.*;


 
 public class Student_signup2 extends JFrame implements ActionListener
 {
    JFrame ss;
    JLabel l;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6; 
    JTextField jTextField1;
    JTextField jTextField2;
    JComboBox Combo1;
    JComboBox Combo2;
    JPasswordField jPasswordField1;
    JPasswordField jPasswordField2;
    JButton jButton1;
    JButton jButton2;

   
   public Student_signup2()
    {
       ss=new JFrame();
       ss.setTitle("STUDENT SIGNUP");
       ss.setLayout(null);
       ss.setSize(600,800);
       ss.getContentPane().setBackground(new Color(0, 0, 102));
       ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ss.show();
       ss.setVisible(true);
       
       l=new JLabel("Student Signup");
       l.setBounds(135,50,300,30);
       l.setForeground(Color.WHITE);
        l.setFont(new Font("Segoe UI Emoji",Font.BOLD,26));
       ss.add(l);

       l1 =new JLabel("NAME:");
       l1.setBounds(100,150,150,30);
       l1.setForeground(Color.WHITE);
       ss.add(l1);
       l2 =new JLabel("ROLL NUMBER:");
       l2.setBounds(100,220,200,30);
       l2.setForeground(Color.WHITE);
       ss.add(l2);
      l3= new JLabel("COURSE:");
      l3.setBounds(100,290,150,30);
      l3.setForeground(Color.WHITE);
      ss.add(l3);
      l4 = new JLabel("YEAR:");
      l4.setBounds(100,360,150,30);
      l4.setForeground(Color.WHITE);
      ss.add(l4);
      l5 = new JLabel("PASSWORD:");
      l5.setBounds(100,430,150,30);
      l5.setForeground(Color.WHITE);
      ss.add(l5);
      l6 = new JLabel("CONFIRM PASSWORD:"); 
      l6.setBounds(100,500,170,30);
      l6.setForeground(Color.WHITE);
      ss.add(l6);
     jTextField1 =new JTextField();
     jTextField1.setBounds(250,150,150,30);
     ss.add(jTextField1);
     jTextField2= new JTextField();
     jTextField2.setBounds(250,220,150,30);
     ss.add(jTextField2);
     Combo1=new JComboBox();
     Combo1.addItem("CSE");
     Combo1.addItem("EEE");
     Combo1.addItem("ME");
     Combo1.addItem("CE");
     Combo1.setBounds(250,290,150,30);
     ss.add(Combo1);
     Combo2=new JComboBox();
     Combo2.addItem("1");
     Combo2.addItem("2");
     Combo2.addItem("3");
     Combo2.addItem("4");
     Combo2.setBounds(250,360,150,30);
     ss.add(Combo2);
     jPasswordField1=new JPasswordField();
     jPasswordField1.setBounds(250,430,150,30);
     ss.add(jPasswordField1);
     jPasswordField2= new JPasswordField();
     jPasswordField2.setBounds(250,500,150,30);
     ss.add(jPasswordField2);

     jButton1=new JButton("SIGN UP");
     jButton1.setBounds(100,570,130,30);
     jButton1.setForeground(Color.WHITE);
     jButton1.setBackground(new Color(51, 133, 255));
     ss.add(jButton1);
     jButton2=new JButton("BACK");
     jButton2.setBounds(250,570,130,30);
     jButton2.setForeground(Color.WHITE);
     jButton2.setBackground(new Color(51, 133, 255));
     ss.add(jButton2);
     jButton1.addActionListener(this);
     jButton2.addActionListener(this);

   }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //signupbutton 
       String name=null,roll=null,branch=null,pwd=null,pwd2=null;
       int year=0;
       if(e.getSource()==jButton1)
      { 
        name=jTextField2.getText();
        roll=jTextField1.getText();
        branch = (String) Combo1.getSelectedItem();
        year = Integer.parseInt((String)Combo2.getSelectedItem());
        pwd=jPasswordField1.getText();
        pwd2=jPasswordField2.getText();
        try{
            
            Class.forName("com.mysql.jdbc.Driver");  
            System.out.println("Connection established");
            
            Connection con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/student","root","ivansj2102");   
             Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from Student_signup");  
       while(rs.next())
         {  
          System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
            }
           con.close();  
            
            }
          catch(Exception ae)
          { 
            ae.printStackTrace();
             }  
         } 

       if((jTextField1.getText().equals(""))||(jTextField2.getText().equals(""))||(Combo1.getSelectedItem()==(""))||(Combo2.getSelectedItem()==(""))||(jPasswordField1.getText().equals(""))||(jPasswordField2.getText().equals(""))||(!pwd.equals(pwd2)))
        {
           JOptionPane.showMessageDialog(null,"INVALID DETAILS.PLEASE TRY AGAIN");
           
        }
   else  {
       
       Student s = new Student(roll, name ,pwd, year, branch); 
       
        JOptionPane.showMessageDialog(null,"You've been registered successfully.");
        System.out.println("Student registered - " + s.roll + s.name + s.pwd + s.year + s.branch);
        ss.dispose();
        student_page page = new student_page(s);
        page.setVisible(true);
      }
    
    
   //backbutton
     if(e.getSource()==jButton2)
       { 
        ss.dispose();
         Student_login1 frame = new Student_login1();
          frame.setVisible(true);
        }
   }
}
 

