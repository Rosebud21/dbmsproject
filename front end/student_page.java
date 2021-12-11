import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.net.*;
import java.util.*;

public class student_page extends JFrame {

    //VARIABLE DECLARATIONS
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JLabel l1;
    private JLabel l10;
    private JLabel l11;
    private JLabel l12;
    private JLabel l13;
    private JLabel l14;
    private JLabel l15;
    private JLabel l16;
    private JLabel l17;
    private JLabel l18;
    private JLabel l19;
    private JLabel l2;
    private JLabel l21;
    private JLabel l22;
    private JLabel l23;
    private JLabel l25;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;
    private JLabel l6;
    private JLabel l7;
    private JLabel l8;
    private JLabel l9;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JScrollPane scrollpane1;
    private JScrollPane scrollpane11;
    private JScrollPane scrollpane13;
    private JScrollPane scrollpane15;
    private JScrollPane scrollpane17;
    private JScrollPane scrollpane18;
    private JScrollPane scrollpane19;
    private JScrollPane scrollpane2;
    private JScrollPane scrollpane20;
    private JScrollPane scrollpane21;
    private JScrollPane scrollpane3;
    private JScrollPane scrollpane4;
    private JScrollPane scrollpane5;
    private JScrollPane scrollpane6;
    private JScrollPane scrollpane8;
    private JScrollPane scrollpane9;
    private JTabbedPane tabbedpane;
    private JTable table1;
    private JTable table10;
    private JTable table2;
    private JTable table3;
    private JTable table4;
    private JTable table5;
    private JTable table6;
    private JTable table7;
    private JTable table8;
    private JTable table9;

    public student_page() {
        //initComponents(); 
    }
    
    public student_page(Student s) {
        initComponents();

        for (Student stu: Student.student_list){
            System.out.println(stu.name);
        }

        l3.setText("Name: " + s.name);
        l4.setText("Roll no: " + s.roll);
        l8.setText("My Grade: " + s.grade);
        
        //Tab colours
        tabbedpane.setBackgroundAt(0, Color.LIGHT_GRAY);
        tabbedpane.setBackgroundAt(1, Color.CYAN);
        tabbedpane.setBackgroundAt(2, Color.GREEN);
        tabbedpane.setBackgroundAt(3, Color.YELLOW);
        tabbedpane.setBackgroundAt(4, Color.ORANGE);
        tabbedpane.setBackgroundAt(5, Color.PINK);

        //Tab Titles
        tabbedpane.setTitleAt(0, "Home");
        tabbedpane.setTitleAt(1, s.courses[0].code);
        tabbedpane.setTitleAt(2, s.courses[1].code);
        tabbedpane.setTitleAt(3, s.courses[2].code);
        tabbedpane.setTitleAt(4, s.courses[3].code);
        tabbedpane.setTitleAt(5, s.courses[4].code);

        //Tab components initialization
        initTab1(s.courses[0]);
        initTab2(s.courses[1]);
        initTab3(s.courses[2]);
        initTab4(s.courses[3]);
        initTab5(s.courses[4]);
    }
    private ArrayList<String[]> getAssignments(String subcode){
        ArrayList<String[]> assignments = new ArrayList<>();
        try {
            URL urlForGetRequest = new URL("http://localhost:5499/assignments/?subcode="+subcode);
            String readLine = null;
            HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
            conection.setRequestMethod("GET");
            int responseCode = conection.getResponseCode();
            System.out.println(responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
                StringBuffer response = new StringBuffer();
                while ((readLine = in .readLine()) != null) {
                    String [] assignment = readLine.split(" ");
                    assignments.add(assignment);
                    response.append(readLine);
                } 
                in .close();
            } else {
                System.out.println("GET NOT WORKED");
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return assignments;
    }

    private void initTab1(Course c){
        l5.setText(c.name);
        
        
        //course material
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        int i = 1;
        for (Material M : c.mat_list){
           model.insertRow(0, new Object[]{i, M.filename, M.date});
           i++;
        }
        
        //assignments
        DefaultTableModel model1 = (DefaultTableModel) table6.getModel();
        ArrayList<String [] >Assignments = getAssignments(c.code.replace(" ", "-"));
        i = 1;
        for( String [] assignment: Assignments){
            model1.insertRow(0, new Object[]{i, 
                assignment[2], 
                assignment[3], 
                assignment[4]}
            );
            i++;
        }
        // int j = 1;
        // for (Assignment A : c.assign_list){
        //    model1.insertRow(0, new Object[]{j, A.title, A.description, A.deadline});
        //    i++;
        // }
    }
    
    private void initTab2(Course c){
        l9.setText(c.name);
        
        
        //course material
        DefaultTableModel model = (DefaultTableModel) table7.getModel();
        int i = 1;
        for (Material M : c.mat_list){
           model.insertRow(0, new Object[]{i, M.filename, M.date});
           i++;
        }
    
        
        //assignments
        DefaultTableModel model1 = (DefaultTableModel) table2.getModel();
        ArrayList<String [] >Assignments = getAssignments(c.code.replace(" ", "-"));
        i = 1;
        for( String [] assignment: Assignments){
            model1.insertRow(0, new Object[]{i, 
                assignment[2], 
                assignment[3], 
                assignment[4]}
            );
            i++;
        }
        // int j = 1;
        // for (Assignment A : c.assign_list){
        //    model1.insertRow(0, new Object[]{j, A.title, A.description, A.deadline});
        //    i++;
        // }
    }
    
    private void initTab3(Course c){
        l13.setText(c.name);
        
        
        //course material
        DefaultTableModel model = (DefaultTableModel) table8.getModel();
        int i = 1;
        for (Material M : c.mat_list){
           model.insertRow(0, new Object[]{i, M.filename, M.date});
           i++;
        }
        
        //assignments
        DefaultTableModel model1 = (DefaultTableModel) table3.getModel();
        ArrayList<String [] >Assignments = getAssignments(c.code.replace(" ", "-"));
        i = 1;
        for( String [] assignment: Assignments){
            model1.insertRow(0, new Object[]{i, 
                assignment[2], 
                assignment[3], 
                assignment[4]}
            );
            i++;
        }
        // int j = 1;
        // for (Assignment A : c.assign_list){
        //    model1.insertRow(0, new Object[]{j, A.title, A.description, A.deadline});
        //    i++;
        // }
    }

    private void initTab4(Course c){
        l17.setText(c.name);
        
        
        //course material
        DefaultTableModel model = (DefaultTableModel) table9.getModel();
        int i = 1;
        for (Material M : c.mat_list){
           model.insertRow(0, new Object[]{i, M.filename, M.date});
           i++;
        }
    
        
        //assignments
        DefaultTableModel model1 = (DefaultTableModel) table4.getModel();
        ArrayList<String [] >Assignments = getAssignments(c.code.replace(" ", "-"));
        i = 1;
        for( String [] assignment: Assignments){
            model1.insertRow(0, new Object[]{i, 
                assignment[2], 
                assignment[3], 
                assignment[4]}
            );
            i++;
        }
        // int j = 1;
        // for (Assignment A : c.assign_list){
        //    model1.insertRow(0, new Object[]{j, A.title, A.description, A.deadline});
        //    i++;
        // }
    }
    
    private void initTab5(Course c){
        l21.setText(c.name);
        
       
        //course material
        DefaultTableModel model = (DefaultTableModel) table10.getModel();
        int i = 1;
        for (Material M : c.mat_list){
           model.insertRow(0, new Object[]{i, M.filename, M.date});
           i++;
        }
    
        
        //assignments
        DefaultTableModel model1 = (DefaultTableModel) table5.getModel();
        ArrayList<String [] >Assignments = getAssignments(c.code.replace(" ", "-"));
        i = 1;
        for( String [] assignment: Assignments){
            model1.insertRow(0, new Object[]{i, 
                assignment[2], 
                assignment[3], 
                assignment[4]}
            );
            i++;
        }
        // int j = 1;
        // for (Assignment A : c.assign_list){
        //    model1.insertRow(0, new Object[]{j, A.title, A.description, A.deadline});
        //    i++;
        // }
    }
    
    //INITIALIZING
    private void initComponents() {

        //setSize(900, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(900, 700));

        panel1 = new JPanel();
        l1 = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        b1 = new JButton();
        tabbedpane = new JTabbedPane();
        scrollpane1 = new JScrollPane();
        panel3 = new JPanel();
        b7 = new JButton();
        l25 = new JLabel();
        l8 = new JLabel();
        l12 = new JLabel();
        scrollpane2 = new JScrollPane();
        panel2 = new JPanel();
        l5 = new JLabel();
        scrollpane8 = new JScrollPane();
        table1 = new JTable();
        b2 = new JButton();
        l6 = new JLabel();
        l7 = new JLabel();
        scrollpane17 = new JScrollPane();
        table6 = new JTable();
        scrollpane3 = new JScrollPane();
        panel4 = new JPanel();
        l9 = new JLabel();
        scrollpane9 = new JScrollPane();
        table2 = new JTable();
        b3 = new JButton();
        l10 = new JLabel();
        l11 = new JLabel();
        scrollpane18 = new JScrollPane();
        table7 = new JTable();
        scrollpane4 = new JScrollPane();
        panel5 = new JPanel();
        l13 = new JLabel();
        scrollpane11 = new JScrollPane();
        table3 = new JTable();
        b4 = new JButton();
        l14 = new JLabel();
        l15 = new JLabel();
        l16 = new JLabel();
        scrollpane19 = new JScrollPane();
        table8 = new JTable();
        scrollpane5 = new JScrollPane();
        panel6 = new JPanel();
        l17 = new JLabel();
        scrollpane13 = new JScrollPane();
        table4 = new JTable();
        b5 = new JButton();
        l18 = new JLabel();
        l19 = new JLabel();
        scrollpane20 = new JScrollPane();
        table9 = new JTable();
        scrollpane6 = new JScrollPane();
        panel7 = new JPanel();
        l21 = new JLabel();
        scrollpane15 = new JScrollPane();
        table5 = new JTable();
        b6 = new JButton();
        l22 = new JLabel();
        l23 = new JLabel();
        scrollpane21 = new JScrollPane();
        table10 = new JTable();

         //TOP PANEL

        panel1.setBackground(new Color(0, 0, 0));
        panel1.setMinimumSize(new Dimension(900, 150));
        panel1.setPreferredSize(new Dimension(900, 150));

        l1.setFont(new Font("Segoe UI Emoji", 1, 38)); 
        l1.setForeground(new Color(255, 255, 255));
        l1.setText("Student Dashboard");

        l2.setIcon(new ImageIcon(getClass().getResource("/images/Mahindra_University.png"))); 

        l3.setFont(new Font("Segoe UI Emoji", 0, 22)); 
        l3.setForeground(new Color(255, 255, 255));
        l3.setText("Name: <name here>");

        l4.setFont(new Font("Segoe UI Emoji", 0, 22)); 
        l4.setForeground(new Color(255, 255, 255));
        l4.setText("Roll number: <roll no here>");

        b1.setBackground(new Color(51, 102, 255));
        b1.setForeground(new Color(255, 255, 255));
        b1.setText("LOGOUT");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?");
                if (input == JOptionPane.YES_OPTION){
                    home_page page = new home_page();
                    page.setVisible(true);
                    dispose(); 
                }
            }
        });

        panel1Layout();

        //TABBED PANE
        tabbedpane.setFont(new Font("Segoe UI Emoji", 0, 24)); 
        tabbedpane.setMinimumSize(new Dimension(900, 550));
        tabbedpane.setPreferredSize(new Dimension(900, 550));

        //HOME PAGE

        panel3.setBackground(new Color(255, 255, 255));

        b7.setBackground(new Color(0, 102, 255));
        b7.setFont(new Font("Segoe UI Emoji", 0, 24)); 
        b7.setForeground(new Color(255, 255, 255));
        b7.setText("View Timetable");
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                timetable t1 = new timetable();
                t1.setVisible(true);
            }
        });

        l25.setFont(new Font("Segoe UI Emoji", 0, 34)); 
        l25.setText("<html> <body> Welcome to Mahindra University's <br> <b>Virtual Classroom </b><br> Your one-stop destination to all online <br>  learning resources. <br> <body> <html>");

        l8.setFont(new Font("Segoe UI Emoji", 0, 24)); 
        l8.setForeground(new Color(204, 0, 0));
        l8.setText("Grade Point Average: <grade here>");

        l12.setFont(new Font("Tahoma", 0, 22)); 
        l12.setText("<html><body>\n\nUpcoming Events: <br>\n\n<li> May 29 - TEDxMahindraUniversity\n<li> June 3 - End Semester Examinations </li>\n<li> June 15 - Summer Break </li>\n</body>\n</html>\n");

        panel3Layout();

        scrollpane1.setViewportView(panel3);

        tabbedpane.addTab("tab1", scrollpane1);

        //COURSE PAGE 1
        panel2.setBackground(new Color(255, 255, 255));

        l5.setFont(new Font("Segoe UI Emoji", 0, 48)); 
        l5.setText("<Course Name>");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "File", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollpane8.setViewportView(table1);

        b2.setText("Upload assignment");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Upload page = new Upload();
                page.setVisible(true);
            }
        });

        l6.setText("Course Materials");

        l7.setText("Assignments");

        table6.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "Title", "Description", "Deadline"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollpane17.setViewportView(table6);

        panel2Layout();

        scrollpane2.setViewportView(panel2);

        tabbedpane.addTab("tab2", scrollpane2);

        //COURSE PAGE 2
        panel4.setBackground(new Color(255, 255, 255));

        l9.setFont(new Font("Segoe UI Emoji", 0, 48));
        l9.setText("<Course Name>");

        table2.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "Title", "Description", "Deadline"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollpane9.setViewportView(table2);

        b3.setText("Upload assignment");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Upload page = new Upload();
                page.setVisible(true);
            }
        });

        l10.setText("Course Materials");

        l11.setText("Assignments");

        table7.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "File", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollpane18.setViewportView(table7);

       panel4Layout();

        scrollpane3.setViewportView(panel4);

        tabbedpane.addTab("tab3", scrollpane3);

        //COURSE PAGE 3
        panel5.setBackground(new Color(255, 255, 255));

        l13.setFont(new Font("Segoe UI Emoji", 0, 48));
        l13.setText("<Course Name>");

        table3.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "Title", "Description", "Deadline"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollpane11.setViewportView(table3);

        b4.setText("Upload assignment");
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Upload page = new Upload();
                page.setVisible(true);
            }
        });

        l14.setText("Course Materials");

        l15.setText("Assignments");

        l16.setText("Grade Point Average : <grade here>");

        table8.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "File", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollpane19.setViewportView(table8);

        panel5Layout();

        scrollpane4.setViewportView(panel5);

        tabbedpane.addTab("tab6", scrollpane4);

        //COURSE PAGE 4
        panel6.setBackground(new Color(255, 255, 255));

        l17.setFont(new Font("Segoe UI Emoji", 0, 48)); 
        l17.setText("<Course Name>");

        table4.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "Title", "Description", "Deadline"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollpane13.setViewportView(table4);

        b5.setText("Upload assignment");
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Upload page = new Upload();
                page.setVisible(true);
            }
        });

        l18.setText("Course Materials");

        l19.setText("Assignments");

        table9.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "File", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollpane20.setViewportView(table9);

        panel6Layout();

        scrollpane5.setViewportView(panel6);

        tabbedpane.addTab("tab4", scrollpane5);
        
        //COURSE PAGE 5
        panel7.setBackground(new Color(255, 255, 255));

        l21.setFont(new Font("Segoe UI Emoji", 0, 48)); // NOI18N
        l21.setText("<Course Name>");

        table5.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "Title", "Description", "Deadline"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollpane15.setViewportView(table5);

        b6.setText("Upload assignment");
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Upload page = new Upload();
                page.setVisible(true);
            }
        });

        l22.setText("Course Materials");

        l23.setText("Assignments");

        table10.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "File", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollpane21.setViewportView(table10);

        panel7Layout();

        scrollpane6.setViewportView(panel7);

        tabbedpane.addTab("tab5", scrollpane6);

        contentPaneLayout();

        pack();
    }
    
    void panel1Layout(){
        GroupLayout panel1Layout = new GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(l4)
                            .addComponent(l3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l2)
                        .addGap(28, 28, 28))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(b1)
                        .addGap(117, 117, 117)
                        .addComponent(l1)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(l2)
                        .addGap(18, 18, 18)
                        .addComponent(l1))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(l3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b1))))
        );
    }
    void panel2Layout(){
        GroupLayout panel2Layout = new GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scrollpane17, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2, GroupLayout.PREFERRED_SIZE, 351,GroupLayout.PREFERRED_SIZE)
                    .addComponent(l6)
                    .addComponent(l5, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l7)
                    .addComponent(scrollpane8, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(l5, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(l6)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollpane8, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(l7)
                .addGap(20, 20, 20)
                .addComponent(scrollpane17, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

    }
    void panel3Layout(){
        GroupLayout panel3Layout = new GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(l25, GroupLayout.PREFERRED_SIZE, 630,GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(b7, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l8, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l12, GroupLayout.Alignment.LEADING)))
                .addContainerGap(638, Short.MAX_VALUE))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l25, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(b7, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(l8)
                .addGap(45, 45, 45)
                .addComponent(l12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
    }
    void panel4Layout(){
        GroupLayout panel4Layout = new GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scrollpane18, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l10)
                    .addComponent(l9, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l11)
                    .addComponent(scrollpane9, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(l9, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(l10)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollpane18, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(l11)
                .addGap(18, 18, 18)
                .addComponent(scrollpane9, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }
    void panel5Layout(){
        GroupLayout panel5Layout = new GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scrollpane19, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l16)
                    .addComponent(b4, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l14)
                    .addComponent(l13, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l15)
                    .addComponent(scrollpane11, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(l13, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(l14)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollpane19, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(l15)
                .addGap(18, 18, 18)
                .addComponent(scrollpane11, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(l16)
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }
    void panel6Layout(){
        GroupLayout panel6Layout = new GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scrollpane20, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE)
                    .addComponent(b5, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l18)
                    .addComponent(l17, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l19)
                    .addComponent(scrollpane13, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(l17, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(l18)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollpane20, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(l19)
                .addGap(18, 18, 18)
                .addComponent(scrollpane13, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }
    void panel7Layout(){
        GroupLayout panel7Layout = new GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scrollpane21, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE)
                    .addComponent(b6, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l22)
                    .addComponent(l21, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l23)
                    .addComponent(scrollpane15, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(l21, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(l22)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollpane21, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(l23)
                .addGap(18, 18, 18)
                .addComponent(scrollpane15, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b6, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }
    void contentPaneLayout(){
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabbedpane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedpane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

}
