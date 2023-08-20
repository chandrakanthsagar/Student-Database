
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
public class PersonalDataDelete extends JFrame implements ActionListener{
    JFrame f=new JFrame("Student_Database_personal_DELETE");
    JLabel l1 = new JLabel("Hallticket");
    JButton b3=new JButton("Delete");
    JTextField t1=new JTextField();
   
    JLabel l3=new JLabel();
   public  PersonalDataDelete(){
    l1.setForeground(new Color(25, 25, 112));
    l1.setFont(new Font("Tahoma", Font.BOLD, 20));
    l1.setBounds(50, 90, 200, 20);
  
        t1.setBounds(200, 100, 150, 30);
        b3.setBounds(200,230,100,30);
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
        
			
			if(e.getSource()==b3)
			{Statement st=con.createStatement();
				String sql="delete from Personaldata where hallticket=\'"+t1.getText()+"\'";
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
        new PersonalDataDelete();
    }

}
