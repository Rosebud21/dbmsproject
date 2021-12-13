

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
public class addMaterials extends JFrame implements ActionListener 
{
	JFrame frame = new JFrame ();
	Container container = getContentPane();
	JLabel heading = new JLabel ("Add course material");

	JLabel name = new JLabel ("Course Name:");
	JLabel date = new JLabel ("Date:");
	JLabel filename = new JLabel ("File Name:");

	JTextField date_field = new JTextField ();
	JTextField filename_field = new JTextField ();

	String courses [] = {"CS 202","CS 203","CS 204","CS 205"};  
	JComboBox cb = new JComboBox (courses);

	JButton upload = new JButton ("Upload");
	JButton cancel = new JButton ("Back");

	addMaterials()
	{
		initComponents ();
		addComponents ();
		addActionEvent ();
	}

	public void initComponents ()
	{
		frame.setTitle("Course Materials Form");
		frame.setBounds(10, 10, 400, 500);
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	frame.setResizable(false);
        	frame.setVisible(true);

		container.setBackground(Color.WHITE);
        	container.setLayout(null);

        	Font font1 = new Font("SansSerif", Font.BOLD, 24);
        	heading.setFont(font1);

		heading.setBounds (50,70,300,30);
		name.setBounds (50,150,100,30);
		date.setBounds (50,200,100,30);
		filename.setBounds (50,250,100,30);

		date_field.setBounds (150,200,150,30);
		filename_field.setBounds (150,250,150,30);
		cb.setBounds (150,150,150,30);

		upload.setBounds (100,350,100,30);
		cancel.setBounds (100,400,100,30);
	}

	public void addComponents ()
	{
		container.add(heading);
		container.add(name);
		container.add(date);
		container.add(filename);
		//container.add(name_field);
		container.add(date_field);
		container.add(filename_field);
		container.add (cb);
		container.add(upload);
		container.add(cancel);
		frame.add(container);
	}

	public void addActionEvent()
	{
		upload.addActionListener(this);
		cancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == upload)
		{
			String m_date = date_field.getText();
			String m_filename = filename_field.getText();
			try {
                URL urlForGetRequest = new URL("http://localhost:5499/material/");
                String readLine = null;
                HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
                conection.setRequestMethod("POST");
                conection.setRequestProperty("Subcode", cb.getSelectedItem().toString());
                conection.setRequestProperty("Filename", m_filename);
                conection.setRequestProperty("Date", m_date);
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
                    JOptionPane.showMessageDialog (null,"Upload Successful!");
					date.setText("");
					filename.setText("");
                } else {
                    System.out.println("GET NOT WORKED");
                    JOptionPane.showMessageDialog(null, "Backend Error!");
                }
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
			// Material m = new Material (m_date, m_filename);
		
			// if (cb.getSelectedItem().equals("CS 202"))
			// {
            // 			Course DLDCA = Course.CSE[0];
            // 			DLDCA.mat_list.add(m);
          	// 	}
            // 		else if (cb.getSelectedItem().equals("CS 203"))
			// {
            // 			Course DAA = Course.CSE[1];
            // 			DAA.mat_list.add(m);
            // 		}
            // 		else if (cb.getSelectedItem().equals("CS 204"))
			// {
            // 			Course OOP = Course.CSE[2];
            // 			OOP.mat_list.add(m);
            // 		}
            // 		else if (cb.getSelectedItem().equals("CS 205"))
			// {
            // 			Course TOC = Course.CSE[3];
            // 			TOC.mat_list.add(m);
            // 		}

			// JOptionPane.showMessageDialog (null,"Upload Successful!");
			// date.setText("");
			// filename.setText("");
		}
		else if (event.getSource()==cancel)
		{
			frame.dispose();
		}
	}


	public static void main (String[] args)
	{
		addMaterials obj = new addMaterials();
	}
	

}