
import javax.swing.*;
import java.awt.event.*;

public class Personal extends JFrame implements ActionListener {

    JFrame j=new JFrame("OPERATIONS ON STUDENT PERSONAL DATABASE");
    JButton j1 = new JButton("Insert Student Data");
    JButton j2 = new JButton("Delete Student Data");
    JButton j3 = new JButton("Update Student Data");

    Personal() {
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
            PersonaDataInsert t1 = new PersonaDataInsert();
        }
        if (e.getSource() == j2) {
            
           PersonalDataDelete t2=new PersonalDataDelete();
        }
        if (e.getSource() == j3) {
    PersonalDataUpdate t3=new PersonalDataUpdate();
        }
    }

    public static void main(String agrs[]) {
        new Personal();
    }

}
