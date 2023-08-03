package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;


public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField tfusername,tfname, tfquestion, tfanswer, tfpassword;
    JButton search, retrieve, back;
    
    
    
    ForgetPassword() {
    setBounds(350,200,850,380);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
     Image i2= i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
     ImageIcon i3= new ImageIcon(i2);
     JLabel image=new JLabel(i3);//put icons in frame
     image.setBounds(580, 70, 200, 200);
     add(image); 
    
    JPanel p1= new JPanel();
    p1.setLayout(null);
    p1.setBounds(30,30,500,280);
    add(p1);
    
    JLabel lusername= new JLabel("Username");
    lusername.setBounds(40, 20, 100, 25);
    lusername.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    p1.add(lusername);
    
    tfusername = new JTextField();
    tfusername.setBounds(220,20,150,25);
    tfusername.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tfusername);
    
    search = new JButton("Search");
    search.setBackground(Color.gray);
    search.setForeground(Color.WHITE);
    search.setBounds(380, 20, 100, 25);
    search.addActionListener(this);
    p1.add(search);
    
    JLabel lname= new JLabel("Name");
    lname.setBounds(40, 60, 100, 25);
    lname.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    p1.add(lname);
    
    tfname = new JTextField();
    tfname.setBounds(220,60, 150,25);
    tfname.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tfname);
    
    JLabel lquestion= new JLabel("Security Question:");
    lquestion.setBounds(40, 100, 150, 25);
    lquestion.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    p1.add(lquestion);
    
    tfquestion = new JTextField();
    tfquestion.setBounds(220,100,150,25);
    tfquestion.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tfquestion);
    
    JLabel lanswer= new JLabel("Answer");
    lanswer.setBounds(40, 140, 150, 25);
    lanswer.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    p1.add(lanswer);
    
    tfanswer = new JTextField();
    tfanswer.setBounds(220,140,150,25);
    tfanswer.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tfanswer);

    retrieve = new JButton("Retrieve");
    retrieve.setBackground(Color.gray);
    retrieve.setForeground(Color.WHITE);
    retrieve.setBounds(380, 140, 100, 25);
    retrieve.addActionListener(this);
    p1.add(retrieve);
    
    JLabel lpassword= new JLabel("Password");
    lpassword.setBounds(40, 180, 150, 25);
    lpassword.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    p1.add(lpassword);
    
    tfpassword = new JTextField();
    tfpassword.setBounds(220,180,150,25);
    tfpassword.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tfpassword);
    
    back= new JButton("Back");
    back.setBackground(Color.GRAY);
    back.setForeground(Color.WHITE);
    back.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    back.setBounds(150, 230, 100,30);
    back.addActionListener(this);
    p1.add(back);
    
    setVisible(true);
    
    
    }
 public void actionPerformed(ActionEvent ae){
 
        if(ae.getSource() == search){
        
            try{
            String query ="select * from accounts where username = '"+tfusername.getText()+"'";
            Conn c= new Conn();
            
            
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                tfname.setText(rs.getString("name"));
                tfquestion.setText(rs.getString("security"));
                
                
            }
            }catch (Exception e) {
            e.printStackTrace();
            
            }
            
            
        }else if(ae.getSource() == retrieve){
            
             try{
            String query ="select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
            Conn c= new Conn();
            
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                tfpassword.setText(rs.getString("password"));
            }
            }catch (Exception e) {
            e.printStackTrace();
            
            }
            
            
            
        }else {
            setVisible(false);
            new Login();
            }    
    }
    

    public static void main(String[] args){
    new ForgetPassword();


    }
}