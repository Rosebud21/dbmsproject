import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

public class Faculty_login1 extends JFrame implements ActionListener {

	JPanel panel;
	JLabel l;
	JFrame frame;
	JLabel l1;
	JLabel l2;
	JTextField ta;
	JPasswordField p1;
	JButton b1;
	JButton b3;
	JCheckBox showPassword;

	Faculty_login1() {
		frame = new JFrame();
		frame.setTitle("FACULTY LOGIN");
		frame.getContentPane().setBackground(new java.awt.Color(0, 0, 102));
		frame.setLayout(null);
		frame.setSize(600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
		frame.setVisible(true);

		l = new JLabel("Faculty Login");
		l.setBounds(145, 50, 300, 30);
		l.setForeground(Color.WHITE);
		l.setFont(new Font("Segoe UI Emoji", Font.BOLD, 26));
		frame.add(l);

		l1 = new JLabel("ID Number:");
		l1.setBounds(100, 150, 150, 30);
		l1.setForeground(Color.WHITE);
		frame.add(l1);
		l2 = new JLabel("Password:");
		l2.setBounds(100, 220, 150, 30);
		l2.setForeground(Color.WHITE);
		frame.add(l2);
		ta = new JTextField();
		ta.setBounds(200, 150, 150, 30);
		frame.add(ta);
		p1 = new JPasswordField();
		p1.setBounds(200, 220, 150, 30);
		frame.add(p1);
		b1 = new JButton("LOGIN");
		b1.setBounds(100, 300, 100, 30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(new java.awt.Color(51, 133, 255));
		frame.add(b1);
		b3 = new JButton("BACK");
		b3.setBounds(250, 300, 100, 30);
		b3.setForeground(Color.WHITE);
		b3.setBackground(new java.awt.Color(51, 133, 255));
		frame.add(b3);
		b1.addActionListener(this);
		b3.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae) {
		// for login button
		if (ae.getSource() == b1) {
			String password = p1.getText();
			String id = ta.getText();



			try {
				URL urlForGetRequest = new URL("http://localhost:5499/faculty/login/?eid="+id.toString()+"&pass="+password);
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

						System.out.println(conection.getHeaderField("eid"));
						String eid = conection.getHeaderField("eid");

						System.out.println(conection.getHeaderField("password"));
						String pass = conection.getHeaderField("password");

						System.out.println(conection.getHeaderField("branch"));
						String branch = conection.getHeaderField("branch");
						JOptionPane.showMessageDialog(null, "Logged in successfully!");
						Faculty f = new Faculty(eid, name, pass, branch);
						// Faculty f = new Faculty("123", "Rohan", "xyz", "CSE");
						faculty_page page = new faculty_page(f);
						page.setVisible(true);
						frame.dispose();
					}
					else{
						System.out.println("errorrrr!!!");
						JOptionPane.showMessageDialog(null, "Incorrect Credentials.");    
					}
				} else {
					System.out.println("GET NOT WORKED");
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			// boolean found = false;
			// for (Faculty f : Faculty.fac_list) {
			// 	if (id.equals(f.eid) && (password.equals(f.pwd))) {
			// 		JOptionPane.showMessageDialog(null, "Logged in successfully!");
			// 		faculty_page page = new faculty_page(f);
			// 		found = true;
			// 		page.setVisible(true);
			// 		frame.dispose();
			// 		break;
			// 	}
			// }
			// if (found == false) {
			// 	JOptionPane.showMessageDialog(null, "Incorrect Credentials.");
			// }
		}

		// backbutton
		if (ae.getSource() == b3) {
			home_page page = new home_page();
			page.setVisible(true);
			frame.dispose();
		}
	}

}
