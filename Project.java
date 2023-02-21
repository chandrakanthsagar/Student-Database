
import javax.swing.*;

import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    JFrame j=new JFrame("STDENT_DATABASE_ADMISTRATION");
    JButton j1 = new JButton("STUDENT PERSONAL INFO");
    JButton j2 = new JButton("STUDENT MARKS");
    JButton j3 = new JButton("DATABASE");

    Project() {
        j1.setBounds(150, 150, 200, 50);
        j2.setBounds(150, 250, 200, 50);
        j3.setBounds(150, 350, 200, 50);
        add(j1);
        add(j2);
        add(j3);
        j1.addActionListener(this);
        j2.addActionListener(this);
        j3.addActionListener(this);
        setLayout(null);
        setVisible(true);
        setSize(600, 600);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == j1) {
            Personal ttt=new Personal();
        }
        if (e.getSource() == j2) {
            
           studentacademics t=new studentacademics();
        }
        if (e.getSource() == j3) {
            databaseacess tt = new databaseacess();
        }
    }

    public static void main(String agrs[]) {
        new Project();
    }

}
