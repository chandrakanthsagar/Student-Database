import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class PersonaDataInsert extends JFrame implements ActionListener {
    JFrame f = new JFrame("STUDENT PERSONAL INFO");
    JLabel l0 = new JLabel("Name");
    JLabel l1 = new JLabel("SSC_Hallticket");
    JLabel l2 = new JLabel("Address");
    JLabel l3 = new JLabel("phone_number");
    JLabel l4 = new JLabel();
	JLabel l10 = new JLabel();
    JTextField t0 = new JTextField();
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
	JPanel labelPanel = new JPanel(); 

    JButton b1 = new JButton("Insert");

    public PersonaDataInsert() {
		labelPanel.setLayout(null); // Set layout to null for precise label placement

        JLabel l0 = new JLabel("Name");
        l0.setForeground(new Color(25, 25, 112));
        l0.setFont(new Font("Tahoma", Font.BOLD, 20));
        l0.setBounds(50, 60, 200, 20);
        labelPanel.add(l0); // Add label to the labelPanel

        JLabel l1 = new JLabel("SSC_Hallticket");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        l1.setBounds(50, 90, 200, 20);
        labelPanel.add(l1); // Add label to the labelPanel

        JLabel l2 = new JLabel("Address");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        l2.setBounds(50, 120, 200, 20);
        labelPanel.add(l2); // Add label to the labelPanel

        JLabel l3 = new JLabel("phone_number");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.BOLD, 20));
        l3.setBounds(50, 150, 200, 20);
        labelPanel.add(l3); // Add label to the labelPanel

        l0.setOpaque(false); // Make label background transparent
        l1.setOpaque(false);
        l2.setOpaque(false);
        l3.setOpaque(false);

        l0.setBounds(50, 60, 200, 25);
        l1.setBounds(50, 90, 200, 25);
        l2.setBounds(50, 120, 200, 25);
        l3.setBounds(50, 150, 200, 25);
        l4.setBounds(300, 300, 200, 40);

        t0.setBounds(250, 60, 100, 25);
        t1.setBounds(250, 90, 100, 25);
        t2.setBounds(250, 120, 100, 25);
        t3.setBounds(250, 150, 100, 25);
        b1.setBounds(50, 230, 200, 30);
        f.add(l0);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(t0);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(b1);
        f.add(l4);
		

        b1.addActionListener(this);
		((JComponent) getContentPane()).setOpaque(false); 
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(800, 600); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Adjust the size here
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chandru", "root", "");
                Statement st = con.createStatement();
                String sql = "insert into Personaldata(name,hallticket,address,phonenumber) values(\'" + t0.getText()
                        + "\'," + t1.getText() + ",\'" + t2.getText() + "\'," + t3.getText() + ")";
                st.executeUpdate(sql);

                con.close();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            new PersonaDataInsert();
        });
    }
}
