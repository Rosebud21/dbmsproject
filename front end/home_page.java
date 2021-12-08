import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class home_page extends JFrame {

    private JButton b1;
    private JButton b2;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JPanel panel1;
    private JPanel panel2;

   public home_page() {
        initComponents();
    }

    private void initComponents() {

        setSize(900, 700);
        panel1 = new JPanel();
        l2 = new JLabel();
        l3 = new JLabel();
        b1 = new JButton();
        b2 = new JButton();
        panel2 = new JPanel();
        l1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(900, 700));
        setResizable(false);
        setSize(new Dimension(900, 700));

        panel1.setBackground(new Color(255, 255, 255));
        panel1.setMinimumSize(new Dimension(400, 700));
        panel1.setPreferredSize(new Dimension(400, 700));

        l2.setIcon(new ImageIcon(getClass().getResource("/images/Mahindra_University.png"))); 

        l3.setFont(new Font("Segoe UI Black", 0, 36));
        l3.setText("<html>\n<font size = 100>Welcome to </font> <br>\n<font size = 100>Virtual Classroom </font>\n\n</html>");

        b1.setBackground(new Color(51, 153, 255));
        b1.setFont(new Font("Segoe UI Historic", 1, 30)); 
        b1.setForeground(new Color(255, 255, 255));
        b1.setText("Student Login");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Student_login1 page = new Student_login1();
                page.setVisible(true);
                dispose();
            }
        });

        b2.setBackground(new Color(51, 153, 255));
        b2.setFont(new Font("Segoe UI Historic", 1, 30)); 
        b2.setForeground(new Color(255, 255, 255));
        b2.setText("Faculty Login");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Faculty_login1 page = new Faculty_login1();
                page.setVisible(true);
                dispose();
            }
        });

        panel1Layout();

        panel2.setMinimumSize(new Dimension(500, 700));

        l1.setIcon(new ImageIcon(getClass().getResource("/images/online-teaching.jpg")));

        panel2Layout();

        pack();
    }

   
void panel1Layout(){
    GroupLayout panel1Layout = new GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(l2)
                    .addComponent(l3)
                    .addComponent(b1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l2)
                .addGap(115, 115, 115)
                .addComponent(l3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(b1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
}

void panel2Layout(){
    GroupLayout panel2Layout = new GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(l1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(l1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

}
    
}
