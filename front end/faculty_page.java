import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.lang.*;

public class faculty_page extends JFrame 
{

    // Variables declaration 
    private JButton b1;
    private JButton b11;
    private JButton b12;
    private JButton b2;
    private JButton b3;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JLabel l1;
    private JLabel l10;
    private JLabel l11;
    private JLabel l12;
    private JLabel l13;
    private JLabel l2;
    private JLabel l25;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;
    private JLabel l7;
    private JLabel l8;
    private JLabel l9;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JScrollPane scrollpane10;
    private JScrollPane scrollpane8;
    private JScrollPane scrollpane9;
    private JTabbedPane tabbedpane;
    private JTable table1;
    private JTable table2;
    private JTable table3;

    public faculty_page() 
    {
        initComponents();  
    }
    
    public faculty_page(Faculty f) {
        initComponents();
        
        setSize(900, 700);
        
        l3.setText("Name: " + f.name);
        l4.setText("EID: " + f.eid);
        
        //Tab colours
        tabbedpane.setBackgroundAt(0, Color.ORANGE);
        tabbedpane.setBackgroundAt(1, Color.YELLOW);
        tabbedpane.setBackgroundAt(2, Color.GREEN);
        tabbedpane.setBackgroundAt(3, Color.CYAN);
        
        //Tab Titles
        tabbedpane.setTitleAt(0, "Home");
        tabbedpane.setTitleAt(1, f.courses[0].code);
        tabbedpane.setTitleAt(2, f.courses[1].code);
        tabbedpane.setTitleAt(3, f.courses[2].code);
        
        //Tab components initialization
        initTab1(f.courses[0]);
        initTab2(f.courses[1]);
        initTab3(f.courses[2]);
          
    }
    
    private void initTab1(Course c){
        l5.setText(c.name);
        
        //assignments
        DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
        int i = 1;
        for (Assignment A : c.assign_list){
           model1.insertRow(0, new Object[]{i, A.title, A.description, A.deadline});
           i++;
        }
    }
    
    private void initTab2(Course c){
        l9.setText(c.name);
        
        //assignments
        DefaultTableModel model1 = (DefaultTableModel) table2.getModel();
        int i = 1;
        for (Assignment A : c.assign_list){
           model1.insertRow(0, new Object[]{i, A.title, A.description, A.deadline});
           i++;
        }
    }
    
    private void initTab3(Course c){
        l13.setText(c.name);
        
        //assignments
        DefaultTableModel model1 = (DefaultTableModel) table3.getModel();
        int i = 1;
        for (Assignment A : c.assign_list){
           model1.insertRow(0, new Object[]{i, A.title, A.description, A.deadline});
           i++;
        }
    }

    private void initComponents() {
        panel1 = new JPanel();
        l1 = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        b1 = new JButton();
        tabbedpane = new JTabbedPane();
        panel3 = new JPanel();
        b7 = new JButton();
        l25 = new JLabel();
        l8 = new JLabel();
        l12 = new JLabel();
        b8 = new JButton();
        panel2 = new JPanel();
        l5 = new JLabel();
        scrollpane8 = new JScrollPane();
        table1 = new JTable();
        b2 = new JButton();
        l7 = new JLabel();
        b3 = new JButton();
        panel4 = new JPanel();
        l9 = new JLabel();
        b11 = new JButton();
        b12 = new JButton();
        l11 = new JLabel();
        scrollpane10 = new JScrollPane();
        table3 = new JTable();
        panel5 = new JPanel();
        l13 = new JLabel();
        b6 = new JButton();
        b9 = new JButton();
        l10 = new JLabel();
        scrollpane9 = new JScrollPane();
        table2 = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(900, 700));

        panel1.setBackground(new Color(0, 0, 0));
        panel1.setMinimumSize(new Dimension(900, 150));
        panel1.setPreferredSize(new Dimension(900, 150));

        l1.setFont(new Font("Segoe UI Emoji", 1, 38)); 
        l1.setForeground(new Color(255, 255, 255));
        l1.setText("Faculty Dashboard");

        l2.setIcon(new ImageIcon(getClass().getResource("/images/Mahindra_University.png"))); 

        l3.setFont(new Font("Segoe UI Emoji", 0, 22)); 
        l3.setForeground(new Color(255, 255, 255));
        l3.setText("Name: <name here>");

        l4.setFont(new Font("Segoe UI Emoji", 0, 22)); 
        l4.setForeground(new Color(255, 255, 255));
        l4.setText("ID number: <eid no here>");

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

        tabbedpane.setPreferredSize(new Dimension(900, 550));

        panel3.setBackground(new Color(255, 255, 255));
        panel3.setPreferredSize(new Dimension(900, 550));

        b7.setBackground(new Color(0, 102, 255));
        b7.setFont(new Font("Segoe UI Emoji", 0, 24)); 
        b7.setForeground(new Color(255, 255, 255));
        b7.setText("Update grades");
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Grade g = new Grade();
                g.setVisible(true);
            }
        });

        l25.setFont(new Font("Segoe UI Emoji", 0, 34)); 
        l25.setText("<html> <body> Welcome to Mahindra University's <br> <b>Virtual Classroom </b><html>");

        l8.setFont(new Font("Segoe UI Emoji", 0, 24));
        l8.setForeground(new Color(204, 0, 0));
        l8.setText("Total teaching hours: 21 hours/week");

        l12.setFont(new Font("Tahoma", 0, 22)); 
        l12.setText("<html><body>\n\nUpcoming Events: <br>\n\n<li> May 28 - Faculty Meeting 1 </li>\n<li> May 29 - Faculty Meeting 2 </li>\n<li> June 3 - End Semester Examinations </li>\n</body>\n</html>\n");

        b8.setBackground(new Color(0, 102, 255));
        b8.setForeground(new Color(255, 255, 255));
        b8.setFont(new Font("Segoe UI Emoji", 0, 24)); 
        b8.setText("View Timetable");
        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                timetable t = new timetable();
                t.setVisible(true);
            }
        });

        panel3Layout();

        tabbedpane.addTab("tabbedpane", panel3);

        panel2.setBackground(new Color(255, 255, 255));

        l5.setFont(new Font("Segoe UI Emoji", 0, 48)); 
        l5.setText("<Course Name>");

        table1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "Title", "Description", "Deadline"
            }
        ) {
            Class[] types = new Class [] {
                Integer.class, String.class, String.class, Object.class
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
        scrollpane8.setViewportView(table1);

        b2.setText("Add Assignment");
        b2.setFont(new Font("Segoe UI Emoji", 0, 24)); 
        b2.setBackground(new Color(0, 102, 255));
        b2.setForeground(new Color(255, 255, 255));
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addAssignment page = new addAssignment();
                page.setVisible(true);
            }
        });

        l7.setText("Assignments given");

        b3.setText("Upload Course Material");
        b3.setFont(new Font("Segoe UI Emoji", 0, 24)); 
        b3.setBackground(new Color(0, 102, 255));
        b3.setForeground(new Color(255, 255, 255));
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addMaterials page = new addMaterials();
                page.setVisible(true);
            }
        });

        panel2Layout();

        tabbedpane.addTab("tab2", panel2);

        panel4.setBackground(new Color(255, 255, 255));

        l9.setFont(new Font("Segoe UI Emoji", 0, 48)); // NOI18N
        l9.setText("<Course Name>");

        b11.setText("Upload Course Material");
        b11.setFont(new Font("Segoe UI Emoji", 0, 24)); 
        b11.setBackground(new Color(0, 102, 255));
        b11.setForeground(new Color(255, 255, 255));
        b11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addMaterials page = new addMaterials();
                page.setVisible(true);
            }
        });

        b12.setText("Add Assignment");
        b12.setFont(new Font("Segoe UI Emoji", 0, 24)); 
        b12.setBackground(new Color(0, 102, 255));
        b12.setForeground(new Color(255, 255, 255));
        b12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addAssignment page = new addAssignment();
                page.setVisible(true);
            }
        });

        l11.setText("Assignments given");

        table3.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "Title", "Description", "Deadline"
            }
        ) {
            Class[] types = new Class [] {
                Integer.class, String.class,String.class, Object.class
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
        scrollpane10.setViewportView(table3);

        panel4Layout();

        tabbedpane.addTab("tab3", panel4);

        panel5.setBackground(new Color(255, 255, 255));

        l13.setFont(new Font("Segoe UI Emoji", 0, 48)); 
        l13.setText("<Course Name>");

        b6.setText("Upload Course Material");
        b6.setFont(new Font("Segoe UI Emoji", 0, 24)); 
        b6.setBackground(new Color(0, 102, 255));
        b6.setForeground(new Color(255, 255, 255));
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addMaterials page = new addMaterials();
                page.setVisible(true);
            }
        });

        b9.setText("Add Assignment");
        b9.setFont(new Font("Segoe UI Emoji", 0, 24)); 
        b9.setBackground(new Color(0, 102, 255));
        b9.setForeground(new Color(255, 255, 255));
        b9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addAssignment page = new addAssignment();
                page.setVisible(true);
            }
        });

        l10.setText("Assignments given");

        table2.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "Title", "Description", "Deadline"
            }
        ) {
            Class[] types = new Class [] {
                Integer.class, String.class, String.class, Object.class
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

        panel5Layout();

        tabbedpane.addTab("tab4", panel5);

        contentPaneLayout();

        pack();
    }

    void contentPaneLayout(){
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(tabbedpane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedpane, GroupLayout.PREFERRED_SIZE, 541, Short.MAX_VALUE))
        );
    }
    void panel1Layout(){
        GroupLayout panel1Layout = new GroupLayout (panel1);
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
                        .addContainerGap(316, Short.MAX_VALUE))))
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
                    .addComponent(b2, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l5, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollpane8, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l7)
                    .addComponent(b3, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(l5, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(b2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(l7)
                .addGap(18, 18, 18)
                .addComponent(scrollpane8, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
    }
    void panel3Layout(){
        GroupLayout panel3Layout = new GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(l25, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(220, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, panel3Layout.createSequentialGroup()
                                .addComponent(l12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(l8, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(226, 226, 226))))
            .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b7, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panel3Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(b8, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(570, Short.MAX_VALUE)))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l25, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(b7, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(l8)
                .addGap(41, 41, 41)
                .addComponent(l12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panel3Layout.createSequentialGroup()
                    .addGap(167, 167, 167)
                    .addComponent(b8, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(284, Short.MAX_VALUE)))
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
                    .addComponent(b9, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollpane9, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l10)
                    .addComponent(b6, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l13, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(l13, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(b6, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(b9, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(l10)
                .addGap(18, 18, 18)
                .addComponent(scrollpane9, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(b12, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollpane10, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l11)
                    .addComponent(b11, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l9, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(l9, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b11, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(b12, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(l11)
                .addGap(18, 18, 18)
                .addComponent(scrollpane10, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
    }
   
}
