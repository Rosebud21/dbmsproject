import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Upload extends JFrame {

     // Variables declaration 
     private JButton jButton1;
     private JFileChooser jFileChooser1;
     private JLabel jLabel1;

    public Upload() {
        initComponents();
    }

    private void initComponents() {

        jFileChooser1 = new JFileChooser();
        jLabel1 = new JLabel();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));

        jFileChooser1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new Font("Segoe UI Emoji", 0, 36)); 
        jLabel1.setText("Upload Assignment");

        jButton1.setFont(new Font("Segoe UI Emoji", 0, 24)); 
        jButton1.setText("BACK");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        contentPaneLayout();

        pack();
    }

    private void jFileChooser1ActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Uploaded successfully!");
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
       this.dispose();
    }
    
    void contentPaneLayout(){
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(jFileChooser1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jFileChooser1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }
    
}

