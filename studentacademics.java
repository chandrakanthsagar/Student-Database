
import javax.swing.*;
import java.awt.event.*;

public class studentacademics extends JFrame implements ActionListener {

    JFrame j;
    JButton j1 = new JButton("Insert Student Data");
    JButton j2 = new JButton("UPDATE Student Data");
    JButton j3 = new JButton("DELETE Student Data");

    studentacademics() {
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
