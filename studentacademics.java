import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class studentacademics extends JFrame implements ActionListener {

    JFrame j;
    JButton j1 = new JButton("GENERATE REPORT");
    JButton j2 = new JButton("UPDATE REPORT");
    JLabel imageLabel;
    JButton j3 = new JButton("DELETE REPORT");

    public studentacademics() {
        j1.setBounds(550, 150, 250, 70);
        j2.setBounds(550, 250, 250, 70);
        j3.setBounds(550, 350, 250, 70);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/school.jpg"));
    Image i3 = i1.getImage().getScaledInstance(1800, 1800, Image.SCALE_SMOOTH);
    ImageIcon i2 = new ImageIcon(i3);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel l1 = new JLabel(i2);
    l1.setBounds(0, 0, 1800, 1800);
    add(l1);
        add(j1);
        add(j2);
        add(j3);
        ((JComponent) getContentPane()).setOpaque(false);
     
        j1.addActionListener(this);
        j2.addActionListener(this);
        j3.addActionListener(this);
        setLayout(null);
        setVisible(true);
        setSize(1800, 1800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == j1) {
           marksinsert t1=new marksinsert();
        }
        if (e.getSource() == j2) {
            
           marksupdate t2=new marksupdate();
        }
        if (e.getSource() == j3) {
            marksdelete t3=new marksdelete();
        }
    }

    public static void main(String agrs[]) {
        new studentacademics() ;
    }

}
