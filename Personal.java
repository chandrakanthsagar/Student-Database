import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Personal extends JFrame implements ActionListener {

    JFrame j=new JFrame("OPERATIONS ON STUDENT PERSONAL DATABASE");
    JButton j1 = new JButton("Insert Student Data");
    JButton j2 = new JButton("Delete Student Data");
    JButton j3 = new JButton("Update Student Data");
    JLabel imageLabel;
    public Personal() {
        setTitle("Student Database Management");
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
        j1.addActionListener(this);
        j2.addActionListener(this);
        j3.addActionListener(this);
        ((JComponent) getContentPane()).setOpaque(false);
        setLayout(null);
        setVisible(true);
        setSize(1800, 1800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
