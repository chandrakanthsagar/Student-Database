import javax.swing.*;
import java.sql.*;
import java.lang.String;
import java.awt.event.*; 
import java.awt.*;
public class marksupdate extends JFrame implements ActionListener
{
	JFrame f=new JFrame("STUDENT PERSONAL INFO");
	JLabel l0=new JLabel("Hallticket");
	JLabel l1=new JLabel("Subject_name");
	JLabel l2=new JLabel("Subject_marks");
	
	JTextField t0=new JTextField();
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	
	
	JButton b1=new JButton("UPDATE");
	public marksupdate()
	{
	 l1.setForeground(new Color(25, 25, 112));
    l1.setFont(new Font("Tahoma", Font.BOLD, 20));
    l1.setBounds(50, 90, 200, 20);
	l0.setForeground(new Color(25, 25, 112));
	l0.setFont(new Font("Tahoma", Font.BOLD, 20));
	l0.setBounds(50, 60, 200, 20);
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 20));
	l2.setBounds(50, 120, 200, 20);
		
		
		t0.setBounds(200,60,100,20);
		t1.setBounds(200,90,100,20);
		t2.setBounds(200,120,100,20);

		
		b1.setBounds(50,180,200,30);
		
		
		f.add(l0);
		f.add(l1);
		f.add(l2);

		f.add(t0);
		f.add(t1);
		f.add(t2);
		
		f.add(b1);
	
       
		
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
                String sql="select "+t1.getText()+" from marksheet where hallticket="+t0.getText()+"";
				
				ResultSet rs = st.executeQuery(sql);
                int marks=0;
                if(rs.next()){
                     marks=rs.getInt(1);
                }
                System.out.println(marks);
               
                String sq="UPDATE marksheet SET "+t1.getText()+"="+t2.getText()+" WHERE hallticket="+t0.getText()+"";
                st.executeUpdate(sq);
                String str="select TOTAL from marksheet where hallticket="+t0.getText()+"";
                ResultSet r = st.executeQuery(str);
                int ma=0;
                if(r.next()){
                     ma=r.getInt(1);
                }
                ma=ma-marks+Integer.parseInt(t2.getText());
				String grade;
				String w="PASS";
				if(Integer.parseInt(t2.getText())>28){
				if(ma>455)
				grade="A";
			  else if(ma>400 && ma<=455)
				  grade="B";
			  else if(ma>350 && ma<=400)
				 grade="C";
			  else if(ma>280 && ma<=350)
				  grade="D";
			  else{
			  grade="E";
		  }}
		  else{
			grade="-";
			w="fail";
		  }
		  String ss="UPDATE marksheet SET GRADE= '" +grade+"',STASTUS='"+w+"' WHERE hallticket="+t0.getText()+"";
		  st.executeUpdate(ss);
                String s="UPDATE marksheet SET TOTAL="+ma+" WHERE hallticket="+t0.getText()+"";
			    st.executeUpdate(s);
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
		new marksupdate();		
	}
}