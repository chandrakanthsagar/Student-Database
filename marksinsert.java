import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.sql.SQLException;
public class marksinsert extends JFrame implements ActionListener{
  JFrame f=new JFrame();
  JLabel l1=new JLabel("Hallticket");
  JLabel l2=new JLabel("Name");
  
  JLabel l3=new JLabel("Grand Total");
  JLabel l4=new JLabel("Grade" );
  JLabel l13=new JLabel("Status");
  JLabel l5=new JLabel("Subject");
  JLabel l6=new JLabel("Marks");
  JLabel l7=new JLabel("Sanskrit");
  JLabel l8=new JLabel("English") ;
  JLabel l9=new JLabel("Maths-1");
  JLabel l10=new JLabel("Maths-2");
  JLabel l11=new JLabel("Physics");
  JLabel l12=new JLabel("Chemistry");
  JTextField t1=new JTextField();
  JTextField t2=new JTextField();
  JTextField t3=new JTextField();
  JTextField t4=new JTextField();
  JTextField t7=new JTextField();
  JTextField t8=new JTextField();
  JTextField t9=new JTextField();
  JTextField t10=new JTextField();
  JTextField t11=new JTextField();
  JTextField t12=new JTextField();
  JTextField t13=new JTextField();
  JButton b1=new JButton("RESULT");
  JButton b2=new JButton("CANCEL");
  JButton b3=new JButton("INSERT");
  

public marksinsert(){
    l1.setBounds(50,100,100,20);
l2.setBounds(50,120,100,20);
l3.setBounds(50,140,100,20);
l4.setBounds(50, 160, 100, 20);
l13.setBounds(50,180,100,20);
l5.setBounds(20, 200, 100, 20);
l6.setBounds(130, 200, 100, 20);
l7.setBounds(20, 230, 100, 20);
l8.setBounds(20, 260, 100, 20);
l9.setBounds(20, 290, 100, 20);
l10.setBounds(20, 310, 100, 20);
l11.setBounds(20, 340, 100, 20);
l12.setBounds(20, 370, 100, 20);
t1.setBounds(150,100,100,20);
t2.setBounds(150,120,100,20);
t3.setBounds(150,140,100,20);
t4.setBounds(150, 160, 100, 20);
t13.setBounds(150, 180, 100, 20);
t7.setBounds(130, 230, 100, 20);
t8.setBounds(130, 260, 100, 20);
t9.setBounds(130, 290, 100, 20);
t10.setBounds(130, 310, 100, 20);
t11.setBounds(130, 340, 100, 20);
t12.setBounds(130, 370, 100, 20);
b1.setBounds(250, 250, 100, 30);
b2.setBounds(350, 250, 100, 30);
b3.setBounds(350, 380, 100, 30);

f.add(l1);
f.add(l2);
f.add(l3);
f.add(l4);
f.add(l5);
f.add(l6);
f.add(l7);
f.add(l8);
f.add(l9);
f.add(l10);
f.add(l11);
f.add(l12);
f.add(l13);

f.add(t1);
f.add(t2);
f.add(t3);
f.add(t4);
f.add(t7);
f.add(t8);
f.add(t9);
f.add(t10);
f.add(t11);
f.add(t12);
f.add(t13);

f.add(b1);
f.add(b2);
f.add(b3);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
f.setLayout(null);
f.setVisible(true);
f.setSize(500,500);
}


public void actionPerformed(ActionEvent e)
{
String x=(t2.getText());
int n1=Integer.parseInt(t7.getText());
int n2=Integer.parseInt(t8.getText());
int n3=Integer.parseInt(t9.getText());
int n4=Integer.parseInt(t10.getText());
int n5=Integer.parseInt(t11.getText());
int n6=Integer.parseInt(t12.getText());


double total;
String w;

char grade;

total=(n1+n2+n3+n4+n5+n6);
String j=String.valueOf(total);
if(n1>=35 && n2>=35 && n3>=28 && n4>=28 && n5>= 24 && n6>=23){
    

    w="PASS";
  
    total=(n1+n2+n3+n4+n5+n6);
    if(total>455)
      grade='A';
    else if(total>400 && total<=455)
        grade='B';
    else if(total>350 && total<=400)
       grade='C';
    else if(total>280 && total<=350)
        grade='D';
    else{
    grade='F';
}
}
else
  {
    
    
      w="FAIL";
      grade='-';
  }



if(e.getSource()==b1)
{
       
t3.setText(j);
      
t4.setText(String.valueOf(grade));

t13.setText(String.valueOf(w));
}

if(e.getSource()==b2)
{
System.exit(0);
}
// Connection con=null;
// 		PreparedStatement ps=null;
// 		ResultSet rs=null;
    try
		{
        if(e.getSource()==b3){
		
      Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chandru","root","");  
        //   Class.forName("oracle.jdbc.driver.OracleDriver");
				// con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","chandrakanth","padma");
				Statement st=con.createStatement();
        String sql = "insert into marksheet(HALLTICKET ,NAME,SANSKRIT,ENG ,MATH1,MATH2,PHY,CHEM ,TOTAL ,GRADE,STASTUS )values('"+t1.getText()+"','"+t2.getText()+"',"+t7.getText()+","+t8.getText()+","+t9.getText()+","+t10.getText()+","+t11.getText()+","+t12.getText()+","+t3.getText()+",'"+t4.getText()+"','"+t13.getText()+"')";

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
public static void main(String...s)
{
new marksinsert();}
}
