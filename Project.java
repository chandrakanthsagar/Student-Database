import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    

    JFrame j = new JFrame("STUDENT_DATABASE_ADMISTRATION");
    JButton j1 = new JButton("STUDENT_PERSONAL_INFO");
    JButton j2 = new JButton("STUDENT_MARKS");
    JButton j3 = new JButton("DATABASE");
    JLabel imageLabel;
// ...
 public Project() {
    setTitle("Student Database Management");
    j1.setBounds(550, 150, 250, 70);
    j2.setBounds(550, 250, 250, 70);
    j3.setBounds(550, 350, 250, 70);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/school.jpg"));
    Image i3 = i1.getImage().getScaledInstance(1800, 1800, Image.SCALE_SMOOTH);
    ImageIcon i2 = new ImageIcon(i3);

    JLabel l1 = new JLabel(i2);
    l1.setBounds(0, 0, 1800, 1800); // Set label bounds// Set label bounds
 
    add(l1); // Add the image label
    add(j1);
    add(j2);
    add(j3);
    j1.addActionListener(this);
    j2.addActionListener(this);
    j3.addActionListener(this);
   
    ((JComponent) getContentPane()).setOpaque(false); // Set content pane to non-opaque
    setLayout(null);
    setVisible(true);
    setSize(1800, 1800); // Adjust frame size
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
// ...


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == j1) {
            Personal ttt = new Personal();
        }
        if (e.getSource() == j2) {

            studentacademics t = new studentacademics();
        }
        if (e.getSource() == j3) {
            databaseacess tt = new databaseacess();
        }
    }

    public static void main(String agrs[]) {
        new Project();
    }
}
