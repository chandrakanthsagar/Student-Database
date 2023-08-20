import javax.swing.*;
import javax.swing.JFrame;  
import javax.swing.JTextArea; 
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.String;
import java.awt.event.*; 
public class databaseacess extends JFrame implements ActionListener{
    JFrame f=new JFrame("Student_Database");

   
    
     
      JLabel l1 = new JLabel("Hallticket");
    JButton b2=new JButton("LOGIN_result");
    JButton b1=new JButton("LOGIN_personal_info");
   
      JLabel l3=new JLabel();
     JTextField t1=new JTextField();
	 JTextArea ta=new JTextArea();
    
    public databaseacess(){
        l1.setBounds(50,100,100,30);
        t1.setBounds(200, 100, 150, 30);
        
        b1.setBounds(200, 150, 200, 30);
        b2.setBounds(200,190,200,30);
       
		l3.setBounds(50, 280, 250, 40);
		ta.setBounds(20,320,550,200);

        
        f.add(l1);
       
        f.add(t1);
       
        f.add(l3);
        f.add(b1);
        f.add(b2);
        
		 f.add(ta);
        b1.addActionListener(this);
b2.addActionListener(this);

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
			
			if(e.getSource()==b1)
			{Statement st=con.createStatement();
				String sql = "select * from personaldata where hallticket="+t1.getText()+"";
				
				
			ResultSet rs = st.executeQuery(sql);
				ta.setText("");
				while(rs.next())
           			{           	   
					ta.append("\nNAME: "+rs.getString(1)+", HALLTICKET: "+rs.getString(2)+", ADDRESS "+rs.getString(3)+", PHONENUMBER"+rs.getString(4)+".");
            			}
				
			}
			
			if(e.getSource()==b2)
			{Statement st=con.createStatement();
				String sql = "select * from marksheet where hallticket="+t1.getText()+"";
				
				
			ResultSet rs = st.executeQuery(sql);
				ta.setText("");
				while(rs.next())
           			{           	   
					ta.append("\nHALLTICKET: "+rs.getString(1)+",\n NAME: "+rs.getString(2)+", \nSANSKRIT"+rs.getString(3)+", \nENGLISH"+rs.getString(4)+",\nMaths1"+rs.getString(5)+",\nMaths2:"+rs.getString(6)+",\nPhysics:"+rs.getString(7)+",\nChemistry:"+rs.getString(8)+",\nTotal:"+rs.getString(9)+",\nGrade:"+rs.getString(10)+",\nStastus:"+rs.getString(11)+".");
            			}
				
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
        new databaseacess();
    }

}