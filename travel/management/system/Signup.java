package travel.management.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Signup extends JFrame implements ActionListener {
    
    JButton create, back;
    JTextField tfusername, tfpassword, tfname, tfanswer;
    Choice security;
    
    
    Signup(){
    setBounds(350, 200, 900, 360);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JPanel p1=new JPanel();
    p1.setBackground(new Color(133,193,233));
    p1.setBounds(0, 0, 500, 400);
    p1.setLayout(null);
    add(p1);
    
    JLabel lusername= new JLabel("Username");
    lusername.setBounds(50, 20, 125, 25);
    lusername.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    p1.add(lusername);
    
    tfusername = new JTextField();
    tfusername.setBounds(200,20,200,25);
    tfusername.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tfusername);
    
    JLabel lname= new JLabel("Name");
    lname.setBounds(50, 60, 125, 25);
    lname.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    p1.add(lname);
    
    tfname = new JTextField();
    tfname.setBounds(200,60,200,25);
    tfname.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tfname);
    
    JLabel lpassword= new JLabel("Password");
    lpassword.setBounds(50, 100, 125, 25);
    lpassword.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    p1.add(lpassword);
    
    tfpassword = new JTextField();
    tfpassword.setBounds(200,100,200,25);
    tfpassword.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tfpassword);

    JLabel lsecurity= new JLabel("Security Question:");
    lsecurity.setBounds(50, 140, 125, 25);
    lsecurity.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    p1.add(lsecurity);
    
    security=new Choice();
    security.add("Favourite cricket player");
    security.add("Favourite holiday destination");
    security.add("Where you were born");
    security.add("Your childhood school");
    security.add("Favourite person in the world");
    security.setBounds(200, 140, 200,25);
    p1.add(security);
    
    JLabel lanswer= new JLabel("Answer");
    lanswer.setBounds(50, 180, 125, 25);
    lanswer.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    p1.add(lanswer);
    
    tfanswer = new JTextField();
    tfanswer.setBounds(200,180,200,25);
    tfanswer.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tfanswer);
    
    create= new JButton("Create");
    create.setBackground(Color.WHITE);
    create.setForeground(new Color(133, 193, 233));
    create.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    create.setBounds(80, 250, 100,30);
    create.addActionListener(this);
    p1.add(create);
    
    back= new JButton("Back");
    back.setBackground(Color.WHITE);
    back.setForeground(new Color(133, 193, 233));
    back.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    back.setBounds(250, 250, 100,30);
    back.addActionListener(this);
    p1.add(back);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
    Image i2= i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
    ImageIcon i3= new ImageIcon(i2);
    JLabel image=new JLabel(i3);//put icons in frame
    image.setBounds(580,50,250,250);
    add(image);
    
    setVisible(true);
    }
    
    
    public static void main(String[] args){
        new Signup();
    
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if (ae.getSource() == create) {
           String username = tfusername.getText();
           String name = tfname.getText();
           String password = tfpassword.getText();
           String question = security.getSelectedItem();
           String answer = tfanswer.getText();
           
           String query = "insert into accounts values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
           try{
               Conn c = new Conn();
               c.s.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null, "Account Created Succesfully");
               setVisible(false);
               new Login();
           }catch (Exception e){
               e.printStackTrace();
           }
       }else if(ae.getSource() == back){
           setVisible(false);
           new Login();
           
     }
        
  //To change body of generated methods, choose Tools | Templates.
    }


}
