
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class marksdelete extends JFrame implements ActionListener{
    JFrame f=new JFrame("Student_Database_MARKS_DELETE");
    JLabel l1 = new JLabel("Hallticket");
    JButton b3=new JButton("Delete");
    JTextField t1=new JTextField();
   
    JLabel l3=new JLabel();
   marksdelete(){
        l1.setBounds(50,100,100,30);
        t1.setBounds(200, 100, 150, 30);
        b3.setBounds(250,230,100,30);
        l3.setBounds(50, 280, 250, 40);
        f.add(l1);
        f.add(t1);
        f.add(b3);
       
        b3.addActionListener(this);
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(600,600);
    }
    public void actionPerformed(ActionEvent e)
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chandru","root","");  
        //   Class.forName("oracle.jdbc.driver.OracleDriver");
			
			if(e.getSource()==b3)
			{Statement st=con.createStatement();
				String sql="delete from marksheet where hallticket=\'"+t1.getText()+"\'";
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
  
    public static void main(String ars[]){
        new marksdelete();
    }

}
