import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class timetable extends JFrame {

    // Variables declaration - do not modify                     
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable jTable1;
    private JTable jTable2;

    public timetable() {
        initComponents();
    }
                         
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jButton1 = new JButton();
        jScrollPane2 = new JScrollPane();
        jTable2 = new JTable();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(102, 102, 255));
        setPreferredSize(new Dimension(700, 380));

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {
                {"MON", " CS 203", "CS 205", "FL 204", "CS 204 LAB", "CS 204 LAB", "L ", "ES 211", null},
                {"TUES", "ES 211", "FL 204", "CS 204", "CS 203 ", "", "U", null, null},
                {"WED", "ES 211", "CS 203", "CS 204 ", "CS 202 ", null, "N", null, null},
                {"THU", "ES 211", "CS 205", "CS 202 (T)", "CS 203 LAB  ", "CS 203LAB ", "C", null, null},
                {"FRI ", "SE 203 LAB ", "SE 203 LAB", "CS 205 ", "", null, "H", null, null},
                {"SAT", null, "CS 202 ", null, null, null, null, null, null}
            },
            new String [] {
                "", "8:25-9:20", "9:25-10:20 ", "10:35-11:30 ", "11:35-12:30 ", "12:35-1:30", "1:35-2:30", "2:35-3:30", "3:35-4:30"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("BACK ");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new DefaultTableModel(
            new Object [][] {
                {"MON ", "CS 203 ", "CS 205", "FL 204", "   CS 204 LAB ", "CS 204 LAB ", "L  ", "ES 211", null},
                {"TUES", "ES 211", "FL 204", "CS 204", "CS 202 (T)", "", "U", null, null},
                {"WED ", "ES 211 ", "CS 203", "CS 204 ", "CS 202", null, "N ", null, null},
                {"THU", "ES 211", "CS 205", "CS 203(T)", "CS 203 LAB ", " CS 203 LAB", "C ", null, null},
                {"FRI", " SE 203 LAB  ", "SE 203  LAB", "CS 202 ", "CS 205", "", "H ", null, null},
                {"SAT ", "", "CS 202 ", null, null, null, null, null, null}
            },
            new String [] {
                "", "8:25-9:20", "9:25-10:20", "10:35-11:30", "11:35-12:30", "12:35-1:30", "1:35-2:30", "2:35-3:30", "3:35-4:30"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel1.setText("CSE BATCH 1");

        jLabel2.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel2.setText("CSE BATCH 2");

       contentPaneLayout();

        pack();
    }                        

    private void jButton1ActionPerformed(ActionEvent evt) {                                         
        dispose();
    }                                        
    
    void contentPaneLayout(){
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 91,GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }
}
