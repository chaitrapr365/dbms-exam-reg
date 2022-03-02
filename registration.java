// CREATE TABLE COURSE(COURSEID VARCHAR(20) PRIMARY KEY,COURSENAME VARCHAR(50),CREDIT NUMBER(8));
//CREATE TABLE CANDIDATE(STUDID VARCHAR(10) PRIMARY KEY,NAME VARCHAR(40),SEMESTER VARCHAR(10),COURSEID VARCHAR(20) REFERENCES COURSE,COLLEGE VARCHAR(70),PASSWORD VARCHAR(30));
//CREATE TABLE EXAMDETAIL(STUDID VARCHAR(10) REFERENCES CANDIDATE,CENTRENAME VARCHAR(50),TIME VARCHAR(20));
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.ImageIcon;
public class RegistrationF implements ActionListener
{
    JFrame frame,f2,f1;
    String[] gender={"Male","Female"};
    String[] coursename={"Linear Algebra And Calculus","Vector Calculus Differential Equations And Transforms","Engineering Physics A","Engineering Chemistry","Engineering Mechanics","Engineering Graphics","Basics Of Civil And Mechanical Engineering","Basics Of Electrical And Electronics Engineering","Engineering Physics Lab","Programming In C","Life Skills","Professional Communication"};
    String[] courseid={"MAT101","MAT102","PHT100","CYT100","EST100","EST110","EST120","EST130","PHL120","EST102","HUN101","HUN102"};
    String[] semester={"S1","S2","S3","S4","S5","S6","S7","S8"};
    String[] time={"FN","AN"};
    JLabel w=new JLabel("Click here for exam registration");
    JLabel studidLabel=new JLabel("STUDID");
    JLabel nameLabel=new JLabel("NAME");
    JLabel genderLabel=new JLabel("GENDER");
    JLabel coursenameLabel=new JLabel("COURSENAME");
    JLabel courseidLabel=new JLabel("COURSEID");
    JLabel creditLabel=new JLabel("CREDIT");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JLabel confirmpasswordLabel=new JLabel("CONFIRMPASSWORD");
    JLabel collegeLabel=new JLabel("SEMESTER");
    JLabel semesterLabel=new JLabel("COLLEGE");
    JLabel centrenameLabel=new JLabel("CENTRENAME");
    JLabel timeLabel=new JLabel("TIME");
    JTextField studidTextField=new JTextField();
    JTextField nameTextField=new JTextField();
    JComboBox genderComboBox=new JComboBox(gender);
    JComboBox coursenameComboBox=new JComboBox(coursename);
    JComboBox courseidComboBox=new JComboBox(courseid);
    JTextField creditTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JPasswordField confirmPasswordField=new JPasswordField();
    JTextField collegeTextField=new JTextField();
    JComboBox semesterComboBox=new JComboBox(semester);
    JTextField centrenameTextField=new JTextField();
    JComboBox timeComboBox= new JComboBox(time);
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");
    JButton enterButton=new JButton("ENTER");
    JScrollPane scroll=new JScrollPane(frame);
    ImageIcon i1=new ImageIcon("examreg.png");
    JLabel li = new JLabel(i1);
   
    RegistrationF()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        f2=new JFrame();
        f1=new JFrame();
 
        f1.setVisible(true);
	 f2.setVisible(false);
        frame.setTitle("Registration Form");
        frame.setBounds(40,40,420,700);
        f2.setBounds(40,40,420,700);
        frame.getContentPane().setBackground(Color.gray);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(scroll,BorderLayout.CENTER);
        frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        f1.setBounds(40,40,420,700);
        li.setBounds(0,0,420,700);
        f1.getContentPane().setBackground(Color.gray);
        f1.getContentPane().setLayout(null);
    }
    public void setLocationAndSize()
    {
        w.setBounds(80,220,200,80);
        studidLabel.setBounds(20,10,140,70);
        nameLabel.setBounds(20,60,40,70);
        genderLabel.setBounds(20,100,80,70);
        coursenameLabel.setBounds(20,140,100,70);
        courseidLabel.setBounds(20,180,100,70);
        creditLabel.setBounds(20,220,100,70);
        passwordLabel.setBounds(20,260,140,70);
        confirmpasswordLabel.setBounds(20,300,140,70);
        centrenameLabel.setBounds(20,340,100,70);
        collegeLabel.setBounds(20,380,100,70);
        semesterLabel.setBounds(20,420,100,70);
        timeLabel.setBounds(20,460,100,70);
        studidTextField.setBounds(180,33,165,23);
        nameTextField.setBounds(180,73,165,23);
        genderComboBox.setBounds(180,113,165,23);
        coursenameComboBox.setBounds(180,153,165,23);
        courseidComboBox.setBounds(180,193,165,23);
        creditTextField.setBounds(180,233,165,23);
        passwordField.setBounds(180,273,165,23);
        confirmPasswordField.setBounds(180,313,165,23);
        collegeTextField.setBounds(180,353,165,23);
        semesterComboBox.setBounds(180,393,165,23);
        centrenameTextField.setBounds(180,433,165,23);
        timeComboBox.setBounds(180,473,165,23);
        registerButton.setBounds(70,540,100,35);
        enterButton.setBounds(120,270,100,70);
        resetButton.setBounds(220,540,100,35);
    }
    public void addComponentsToFrame()
    {
	 f1.add(w);
        f1.add(li);
        frame.add(studidLabel);
        frame.add(nameLabel);
        frame.add(genderLabel);
        frame.add(coursenameLabel);
        frame.add(courseidLabel);
        frame.add(creditLabel);
        frame.add(passwordLabel);
        frame.add(confirmpasswordLabel);
        frame.add(collegeLabel);
        frame.add(semesterLabel);
        frame.add(centrenameLabel);
        frame.add(timeLabel);
        frame.add(studidTextField);
        frame.add(nameTextField);
        frame.add(genderComboBox);
        frame.add(coursenameComboBox);
        frame.add(courseidComboBox);
        frame.add(creditTextField);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(collegeTextField);
        frame.add(semesterComboBox);
        frame.add(centrenameTextField);
        frame.add(timeComboBox);
        frame.add(registerButton);
        frame.add(resetButton);
	  f1.add(enterButton);


    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        enterButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        try{
        if(e.getSource()==enterButton)
        {
        	frame.setVisible(true);
        }
        if(e.getSource()==registerButton)
        {
                Class.forName("oracle.jdbc.driver.OracleDriver");  
                Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","chaidb");
                PreparedStatement Pstatement=connection.prepareStatement("insert into candidate values(?,?,?,?,?,?,?)");
                PreparedStatement P2statement=connection.prepareStatement("insert into examdetail values(?,?,?)");
                  if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText()))
                     {
                        JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                        Pstatement.setString(1,studidTextField.getText());
                	    Pstatement.setString(2,nameTextField.getText());
	                 Pstatement.setString(3,semesterComboBox.getSelectedItem().toString());
                       Pstatement.setString(4,courseidComboBox.getSelectedItem().toString());
                       Pstatement.setString(5,collegeTextField.getText());
                       Pstatement.setString(6,passwordField.getText());
                       Pstatement.setString(7,genderComboBox.getSelectedItem().toString());
                 	   Pstatement.executeUpdate();
                       P2statement.setString(1,studidTextField.getText());
                       P2statement.setString(2,centrenameTextField.getText());
                       P2statement.setString(3,timeComboBox.getSelectedItem().toString());
                       P2statement.executeUpdate();
                   }
                else
                   {
                     JOptionPane.showMessageDialog(null,"Password does not match");
                   }
 
          } 

          else if(e.getSource()==resetButton)
          {
            studidTextField.setText(" ");
            nameTextField.setText("");
            genderComboBox.setSelectedItem(" ");
            coursenameComboBox.setSelectedItem(" ");
            courseidComboBox.setSelectedItem(" ");
            creditTextField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
            collegeTextField.setText("");
            semesterComboBox.setSelectedItem(" ");
            centrenameTextField.setText("");
            timeComboBox.setSelectedItem(" ");
        }
 
    } 
      catch (Exception e1) {
                e1.printStackTrace();
            }
}
        public static void main(String[] args)
    {
        new RegistrationF();
    }

}

