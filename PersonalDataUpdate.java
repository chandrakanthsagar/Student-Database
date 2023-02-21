

import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PersonalDataUpdate extends JFrame implements ActionListener {
    JFrame f=new JFrame("Student_Database_personal_UPDATE");
    JLabel l1 = new JLabel("Hallticket");
    JLabel l2=new JLabel("Address");
    JButton b1=new JButton("Update");
    JTextField t1=new JTextField();
	JTextField t2=new JTextField();
PersonalDataUpdate(){
    l1.setBounds(50,90,100,20);
    l2.setBounds(50,120,100,20);
    b1.setBounds(50,180,200,30);
    t1.setBounds(200,90,100,20);
		t2.setBounds(200,120,100,20);
    f.add(l1);
	f.add(l2);
    f.add(b1);
    f.add(t1);
		f.add(t2);
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
			Statement st=con.createStatement(); 
            String qry = "UPDATE personaldata SET address='"+t2.getText()+"' WHERE hallticket="+t1.getText()+"";	
            st.executeUpdate(qry);
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
public static void main(String args[]){
    new PersonalDataUpdate();
}
}
