import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Registration implements ActionListener
{
  
  JFrame f1,f2,f3;

  JLabel jlab1,jlab2,jlab3,jlab4,jlab5,jlab6;

  JTextField tf1,tf2,tf3;

  JPanel jp1;
  JButton b1,b2;

  JRadioButton jb1,jb2,jb3;

  ButtonGroup bg;

  Connection c;

  Statement stmt;

  ResultSet rs;

  String s,name,phoneno,course,stmt1;

  Registration() throws Exception

  {
 
   Class.forName("org.postgresql.Driver");

    c = DriverManager.getConnection("jdbc:postgresql://ziggy.db.elephantsql.com:5432/dgmvslal","dgmvslal","Z9rYgKjyec0JM2iKRWfF5GAtmbLM7lBH");

    stmt = c.createStatement();


    f1 = new JFrame("Home Page");

    f1.setSize(600,600);

    jlab1 = new JLabel("UNIVERSITY");

    jlab1.setBounds(50,10,120,30);

    f1.add(jlab1);

    jlab2 = new JLabel("Click Here for Login:,JLabel.CENTER);

    jlab2.setBounds(150,90,120,30);

    f1.add(jlab2);
    jl1 = new JLabel("LOGIN");
    jp1=new  JPanel("LOGIN");  
    jp1.setSize(400,400);
    jp1.add(jl1);
    jl1.setBounds(50,10,120,30);
    f1.add(jp1);
    f1.add(jlab1);

    //jlab2 = new JLabel("Click Here for Login:",JLabel.CENTER);

    b1 = new JButton("REGISTER");

    b1.setBounds(150,90,120,30);

    f1.add(b1);

    b1.addActionListener(this);

    f1.setLayout(null);

    f1.setVisible(true);

    f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);



    f2 = new JFrame("Registration Page");

    f2.setSize(600,400);
    f2.setLayout(new FlowLayout());
    f2.setVisible(false);
    jlab3 = new JLabel("Name");
    jlab3.setBounds(60,60,200,60);
    tf1 = new JTextField(45);

    f2.add(jlab3);

    f2.add(tf1);
    jlab4 = new JLabel("Phone no");

    jlab4.setBounds(60,60,220,40);
    tf2 = new JTextField(45);

    f2.add(jlab4);
    f2.add(tf2);
    jlab5 = new JLabel("Course");
    jlab5.setBounds(60,60,240,30);
    f2.add(jlab5);
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
 
     if(s.equals("REGISTER"))

      {
        f2.setVisible(true);
      }
      else if(s.equals("Java") || s.equals("C++") || s.equals("HTML"))
      {
        tf3.setText(s);
      }
      else if(s.equals("SUBMIT"))
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