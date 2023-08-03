package travel.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;


public class Login extends JFrame implements ActionListener {
    
    JButton login, signup, password;
    JTextField tfpassword, tfusername;
    
    Login(){
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2= i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);//put icons in frame
        image.setBounds(100,100,200,200);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);
        
        JLabel lusername= new JLabel("Username");
        lusername.setBounds(60, 20, 100, 25);
        lusername.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
        p2.add(lusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        JLabel lpassword= new JLabel("Password:");
        lpassword.setBounds(60, 110, 100, 25);
        lpassword.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
        p2.add(lpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword );
        
        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
        login.addActionListener(this);
        p2.add(login);
  
        signup = new JButton("Signup");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133,193,233)));
        signup.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
        signup.addActionListener(this);
        p2.add(signup);
        
        password = new JButton("Forget Password");
        password.setBounds(130,250,130,30);
        password.setBackground(new Color(133,193,233));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(133,193,233)));
        password.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 18));
        password.addActionListener(this);
        p2.add(password);
        
        JLabel text = new JLabel("Trouble in signing?");
        text.setBounds(300, 250, 150, 20);
        text.setForeground(Color.red);
        p2.add(text);
        
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == login){
        String username = tfusername.getText();
        String pass = tfpassword.getText();
        
        String query = "select * from accounts where username = '"+username+"' AND password = '"+pass+"'";
        Conn c = new Conn();
        ResultSet rs = null;
        try {
            rs = c.s.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(rs.next()){
                setVisible(false);
                new Loading(username);
            }else {
                JOptionPane.showMessageDialog(null, "Incorrect username or password");
            }   } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }else if (ae.getSource() ==  signup){
            setVisible(false);
            new Signup();
        
    }else {
        setVisible(false);
        new ForgetPassword();
    
    }
 
    }
    
    
    
    public static void main(String[] args){
       new Login();
    
    
    
    }
}
