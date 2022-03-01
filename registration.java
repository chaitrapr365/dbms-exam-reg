import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Registration implements ActionListener
{
  
  JFrame f1,f2,f3;
  JLabel jlab1,jlab2,jlab3,jlab4,jlab5,jlab6,jlab7,jlab8,l1,l2;
  JTextField tf1,tf2,tf3,tf5,tf6,tf7,t1,t2;
  TextField pass;
  JButton b1,b2,b3,b4;
  JRadioButton jb1,jb2,jb3;
  ButtonGroup bg;
  Connection c;
  Statement stmt;
  ResultSet rs;
  String s,name,studid,courseid,semester,year,course,stmt1;
  Registration() throws Exception
  {
   Class.forName("org.postgresql.Driver");
    c = DriverManager.getConnection("jdbc:postgresql://ziggy.db.elephantsql.com:5432/dgmvslal","dgmvslal","Z9rYgKjyec0JM2iKRWfF5GAtmbLM7lBH");
    stmt = c.createStatement();

    f1 = new JFrame("Home Page");

    f1.setSize(600,600);

    jlab1 = new JLabel("UNIVERSITY");
    JPanel pane=new JPanel(); 
    //pane.setBackground(Color.black);
    //pane.setBounds(50,20,500,10); 
    jlab1.setBounds(50,10,120,30);
    f1.add(jlab1);
    //f1.add(pane);

    jlab2 = new JLabel("Click Here for Login:",JLabel.CENTER);

    jlab2.setBounds(100,50,120,30);

    f1.add(jlab2);
        
    JPanel panel=new JPanel();  
	 //JPanel pane=new JPanel(); 
     panel.setBounds(40,80,500,500);    
     panel.setBackground(Color.blue); 
        //pane.setBackground(Color.black);
	 //pane.setBounds(0,80,500,10); 
     l1 = new JLabel("USERNAME");    
     l1.setBounds(100,100,120,30);    	
     t1=new JTextField(15);
        //b3.setBackground(Color.yellow);   
     l2=new JLabel("PASSWORD");   
     l2.setBounds(200,200,120,15);  
     pass=new TextField(15);
     pass.setEchoChar('*');
        //b4.setBackground(Color.green);   
     panel.add(l1);
     panel.add(t1);
     panel.add(l2); 
     panel.add(pass); 
        //f1.add(pane);
     f1.add(panel);  
     
     f1.add(jlab1);

     jlab2 = new JLabel("Click Here for Login:",JLabel.CENTER);

     b1=new JButton("SIGNUP");
     b2=new JButton("LOGIN");

    b1.setBounds(100,300,120,30);
    b2.setBounds(500,300,120,30);
    panel.add(b1); 
    panel.add(b2); 

    b1.addActionListener(this);
    b2.addActionListener(this);

    f1.add(panel);  

    f1.setLayout(null);
    

    f1.setVisible(true);

    f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);



//FRAME 2 _LOGIN PAGE
   JLabel d_name,d_;
   JTextField tf1,tf2,tf3,t1,t2;

    f2 = new JFrame("LOGIN PAGE");

    f2.setSize(600,400);
    f2.setLayout(null);
    f2.setVisible(false);

    jlab3 = new JLabel("Welcome to registration!",JLabel.CENTER);
    jlab3.setBounds(60,60,200,60);
    
    d_name= new JLabel("");
    d_name.setBounds(60,100,200,60)
    tf1 = new JTextField(45);
    f2.add(jlab3);
    f2.add(d_name);

    f2.add(tf1);
    jlab4 = new JLabel("studid");

    jlab4.setBounds(60,60,220,40);
    tf2 = new JTextField(45);

    f2.add(jlab4);
    f2.add(tf2);
    jlab5 = new JLabel("Course");
    jlab5.setBounds(60,60,240,30);
    f2.add(jlab5);
    tf4=new JTextField(45);
    f2.add(tf4);
    jlab6 = new JLabel("Courseid");
    f2.add(jlab6);
    tf5=new JTextField(45);
    f2.add(tf5);
    jlab7 = new JLabel("Semester");
    f2.add(jlab7);
    tf6=new JTextField(45);
    f2.add(tf6);
    jlab8 = new JLabel("Year");
    f2.add(jlab8);
    tf7=new JTextField(45);
    f2.add(tf7);
    jb1 = new JRadioButton("Java");
    jb2 = new JRadioButton("C++");
    jb3 = new JRadioButton("HTML");

    bg = new ButtonGroup();

    f2.add(jb1);

    f2.add(jb2);

    f2.add(jb3);

    bg.add(jb1);

    bg.add(jb2);

    bg.add(jb3);

    jb1.addActionListener(this);

    jb2.addActionListener(this);

    jb3.addActionListener(this);

    tf3 = new JTextField(30);

    f2.add(tf3);

    b2 = new JButton("SUBMIT");
    b2.setBounds(60,50,300,20);

    f2.add(b2);

    b2.addActionListener(this);
  }
  public void actionPerformed(ActionEvent ae)
  {

    s = ae.getActionCommand();

    try
    {
 
     if(s.equals("LOGIN"))

      {
        f2.setVisible(true);
        userid=t1.getText();
        /* //FROM DETAILS TABLE?
	 statfetch ="select * from -table name- where st_id='"+userid+"';";
        rs = stmt.executeQuery(statfetch);
        while(rs.next())
        {
          //as per details in table
          String Name=(rs.getString("name"));
          //..String course=(rs.getInt("phoneno"));
          //..System.out.println(rs.getString("course"));
        }
         d_name.setText(Name);
	  */
      }
else if(s.equals("SIGNUP"))
      {
        name = tf1.getText();
        phoneno = tf2.getText();
        course = tf3.getText();
        stmt1 = "Insert into registration values('"+name+"','"+phoneno+"','"+course+"');";
        int p = stmt.executeUpdate(stmt1);
        stmt1 ="select * from registration where name = '"+name+"';";
        rs = stmt.executeQuery(stmt1);
        while(rs.next())
        {
          System.out.println(rs.getString("name"));
          System.out.println(rs.getInt("phoneno"));
          System.out.println(rs.getString("course"));
        }
        JOptionPane.showMessageDialog(f2,"Successfully Registered.","Alert",JOptionPane.WARNING_MESSAGE);
        f2.dispose();
        f1.dispose();
      }
   }
   catch(SQLException e)

   {
  
   e.printStackTrace();
      }
 
    }
 public static void main(String args[]) throws Exception
 {
   new Registration();
 }
}
