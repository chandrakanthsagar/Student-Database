import javax.swing.JFrame;
import javax.swing.*;
import java.sql.*;
import java.sql.SQLException;
import java.lang.String;
import java.awt.event.*; 
public class PersonaDataInsert extends JFrame implements ActionListener
{
	JFrame f=new JFrame("STUDENT PERSONAL INFO");
	JLabel l0=new JLabel("Name");
	JLabel l1=new JLabel("SSC_Hallticket");
	JLabel l2=new JLabel("Address");
	JLabel l3=new JLabel("phone_number");
    JLabel l4=new JLabel();
	JTextField t0=new JTextField();
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	
	JButton b1=new JButton("Insert");
	PersonaDataInsert()
	{
		l0.setBounds(50,60,100,20);
		l1.setBounds(50,90,100,20);
		l2.setBounds(50,120,100,20);
		l3.setBounds(50,150,100,20);
        l4.setBounds(300, 300, 100, 40);
		
		t0.setBounds(200,60,100,20);
		t1.setBounds(200,90,100,20);
		t2.setBounds(200,120,100,20);

		t3.setBounds(200,150,100,20);
		b1.setBounds(50,180,200,30);
		
		
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
		
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(500,500);
	
	}
	public void actionPerformed(ActionEvent e)
	{

		try
		{
			if(e.getSource()==b1)
			{
				Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chandru","root","");  
        //   Class.forName("oracle.jdbc.driver.OracleDriver");
				// con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","chandrakanth","padma");
				Statement st=con.createStatement();
				String sql = "insert into Personaldata(name,hallticket,address,phonenumber) values(\'"+t0.getText()+"\',"+t1.getText()+",\'"+t2.getText()+"\',"+t3.getText()+")";
				st.executeUpdate(sql);
			
			con.close();  
                

			}
			
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
	}
	public static void main(String args[])
	{
		new PersonaDataInsert();			
	}
}