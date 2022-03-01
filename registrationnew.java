import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class RegistrationForm implements ActionListener
{
    JFrame frame;
    String[] gender={"Male","Female"};
    String[] coursename={"Linear Algebra And Calculus","Vector Calculus Differential Equations And Transforms","Engineering Physics A","Engineering Chemistry","Engineering Mechanics","Engineering Graphics","Basics Of Civil And Mechanical Engineering","Basics Of Electrical And Electronics Engineering","Engineering Physics Lab","Programming In C","Life Skills","Professional Communication"};
    String[] courseid={"MAT101","MAT102","PHT100","CYT100","EST100","EST110","EST120","EST130","PHL120","EST102","HUN101","HUN102"};
    String[] semester={"S1",S2","S3","S4","S5","S6","S7","S8"};
    String[] time={"FN","AN"};
    JLabel studidLabel=new JLabel("STUDID");
    JLabel nameLabel=new JLabel("NAME");
    JLabel genderLabel=new JLabel("GENDER");
    JLabel coursenameLabel=new JLabel("COURSENAME");
    JLabel courseidLabel=new JLabel("COURSEID");
    JLabel creditLabel=new JLabel("CREDIT");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JLabel collegeLabel=new JLabel("COLLEGE");
    JLabel semesterLabel=new JLabel("SEMESTER");
    JLabel centrenameLabel=new JLabel("CENTRENAME");
    JLabel timeLabel=new JLabel("TIME");
    JTextField studidTextField=new JTextField();
    JTextField nameTextField=new JTextField();
    JComboBox genderComboBox=new JComboBox(gender);
    JComboBox coursenameComboBox=new JComboBox(coursename);
    JComboBox courseidComboBox=new JComboBox(courseid);
    JTextField creditTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JTextField collegeTextField=new JTextField();
    JComboBox semesterComboBox=new JComboBox(semester);
    JTextField centrenameTextField=new JTextField();
    JComboBox timeComboBox= new JComboBox(time);
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");
   
    RegistrationForm()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(40,40,380,700);
        frame.getContentPane().setBackground(Color.pink);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        studidLabel.setBounds(20,20,40,70);
        nameLabel.setBounds(20,70,40,70);
        genderLabel.setBounds(20,120,80,70);
        coursenameLabel.setBounds(20,170,100,70);
        courseidLabel.setBounds(20,220,100,70);
        creditLabel.setBounds(20,270,100,70);
        passwordLabel.setBounds(20,320,140,70);
        centrenameLabel.setBounds(20,370,100,70);
        collegeLabel.setBounds(20,420,100,70);
        semesterLabel.setBounds(20,470,100,70);
        timeLabel.setBounds(20,520,100,70);
        studidTextField.setBounds(180,43,165,23);
        nameTextField.setBounds(180,93,165,23);
        genderComboBox.setBounds(180,143,165,23);
        coursenameComboBox.setBounds(180,193,165,23);
        courseidComboBox.setBounds(180,243,165,23);
        creditTextField.setBounds(180,293,165,23);
        passwordField.setBounds(180,343,165,23);
        collegeTextField.setBounds(180,393,165,23);
        semesterComboBox.setBounds(180,443,165,23);
        centrenameTextField.setBounds(180,493,165,23);
        timeComboBox.setBounds(180,553,165,23);
        registerButton.setBounds(70,600,100,35);
        resetButton.setBounds(220,600,100,35);
    }
    public void addComponentsToFrame()
    {
        frame.add(studidLabel);
        frame.add(nameLabel);
        frame.add(genderLabel);
        frame.add(coursenameLabel);
        frame.add(courseidLabel);
        frame.add(creditLabel);
        frame.add(passwordLabel);
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
        frame.add(collegeTextField);
        frame.add(semesterComboBox);
        frame.add(centrenameTextField);
        frame.add(timeComboBox);
        frame.add(registerButton);
        frame.add(resetButton);
    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerButton)
        {
            try {
                //Creating Connection Object
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase","root","root");
                //Preapared Statement
                PreparedStatement Pstatement=connection.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
                //Specifying the values of it's parameter
                Pstatement.setString(0,studidTextField.getText());
                Pstatement.setString(1,nameTextField.getText());
                Pstatement.setString(2,genderComboBox.getSelectedItem().toString());
                Pstatement.setString(3,coursenameComboBox.getSelectedItem().toString());
                Pstatement.setString(4,courseidComboBox.getSelectedItem().toString());
                Pstatement.setString(5,creditTextField.getText());
                Pstatement.setString(6,passwordField.getText());
                Pstatement.setString(7,collegeTextField.getText());
                Pstatement.setString(8,semesterComboBox.getSelectedItem().toString());
                Pstatement.setString(9,centrenameTextField.getText());
                Pstatement.setString(A,timeComboBox.getSelectedItem().toString());
                //Checking for the Password match
                /*if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText()))
                {
                    //Executing query
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"password did not match");
                }*/
 
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
 
 
        }
        if(e.getSource()==resetButton)
        {
            //Clearing Fields
            studidTextField.setText(" ");
            nameTextField.setText("");
            genderComboBox.setSelectedItem(" ");
            coursenameComboBox.setSelectedItem(" ");
            courseidComboBox.setSelectedItem(" ");
            creditTextField.setText("");
            passwordField.setText("");
            collegeTextField.setText("");
            semesterComboBox.setSelectedItem(" ");
            centrenameTextField.setText("");
            timeComboBox.setSelectedItem(" ");
        }
 
    }
}

public class Main {
    public static void main(String[] args)
    {
        new RegistrationForm();
    }
 
 }
