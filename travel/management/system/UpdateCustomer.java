package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCustomer extends JFrame implements ActionListener {
    
    JLabel labelusername, labelname;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfphone, tfemail, tfid, tfgender;
    JRadioButton rmale, rfemale, rother;
    JButton add,back;
    
    UpdateCustomer(String username){
    setBounds(500, 200, 850, 550);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    
    
    
    JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
    text.setBounds(300,10,350,25);
    text.setFont(new Font("Tahoma", Font.PLAIN , 20));
    add(text);
    
    JLabel lusername= new JLabel("Username");
    lusername.setBounds(30, 50, 150, 25);
    //lusername.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    add(lusername);
    
    labelusername= new JLabel();// regarding username answer
    labelusername.setBounds(220, 50, 150, 25);
    //lusername.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    add(labelusername);
    
    JLabel lblid= new JLabel("Id");
    lblid.setBounds(30, 90, 150, 25);
    //lusername.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    add(lblid);
    
    tfid = new JTextField(); // textfield are editable
    tfid.setBounds(220, 90, 150, 25);
    add(tfid);
    
    JLabel lnumber= new JLabel("Number");
    lnumber.setBounds(30, 130, 150, 25);
    //lusername.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    add(lnumber);
    
    tfnumber = new JTextField(); // textfield are editable
    tfnumber.setBounds(220, 130, 150, 25);
    add(tfnumber);
    
    
    JLabel lname= new JLabel("Name");
    lname.setBounds(30,170, 150, 25);
    add(lname);
    
    labelname = new JLabel(); //JLabel can't be edited that's why we didnt choose textfield
    labelname.setBounds(220, 170,150, 25);
    add(labelname);
    
    JLabel lgender= new JLabel("Gender");
    lgender.setBounds(30,210, 150, 25);
    add(lgender);
    
    tfgender = new JTextField(); // textfield are editable
    tfgender.setBounds(220, 210, 150, 25);
    add(tfgender);
    
    JLabel lcountry= new JLabel("Country");
    lcountry.setBounds(30, 250, 150, 25);
    //lusername.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    add(lcountry);
    
    tfcountry = new JTextField(); // textfield are editable
    tfcountry.setBounds(220, 250, 150, 25);
    add(tfcountry);
    
    JLabel laddress= new JLabel("Address");
    laddress.setBounds(30, 290, 150, 25);
    //lusername.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    add(laddress);
    
    tfaddress = new JTextField(); // textfield are editable
    tfaddress.setBounds(220, 290, 150, 25);
    add(tfaddress);
    
    JLabel lphone = new JLabel("Phone");
    lphone.setBounds(30, 330, 150, 25);
    //lusername.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    add(lphone);
    
    tfphone = new JTextField(); // textfield are editable
    tfphone.setBounds(220, 330, 150, 25);
    add(tfphone);
    
    JLabel lemail = new JLabel("Email");
    lemail.setBounds(30, 370, 150, 25);
    //lusername.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    add(lemail);
    
    tfemail = new JTextField(); // textfield are editable
    tfemail.setBounds(220, 370, 150, 25);
    add(tfemail);
    
    add= new JButton("Update");
    add.setBackground(Color.BLACK);
    add.setForeground(Color.WHITE);
    //back.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    add.setBounds(70, 430, 100,25);
    add.addActionListener(this);
    add(add);
    
    back= new JButton("Back");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    //back.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    back.setBounds(220, 430, 100,25);
    back.addActionListener(this);
    add(back);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
    Image i2 = i1.getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(400,100, 450,300);
    add(image);
    
    try{
    Conn c = new Conn();
    ResultSet rs = c.s.executeQuery("select * from customer where username ='"+username+"'");//ddl command
    while(rs.next()){
            labelusername.setText(rs.getString("username"));
            labelname.setText(rs.getString("name"));
            tfnumber.setText(rs.getString("number"));
            tfgender.setText(rs.getString("gender"));
            tfcountry.setText(rs.getString("country"));
            tfaddress.setText(rs.getString("address"));
            tfphone.setText(rs.getString("phone"));
            tfemail.setText(rs.getString("email"));
    }
    
    }catch (Exception e){
    e.printStackTrace();
    }
    
    setVisible(true);
    
   }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            
            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            
            try {
               Conn c= new Conn();
               String query = "update customer set username = '"+username+"',id = '"+id+"',number = '"+number+"',name =  '"+name+"',gender = '"+gender+"', country = '"+country+"',address =  '"+address+"', phone = '"+phone+"',email = '"+email+"'";
               c.s.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
               setVisible(false);
               
            }catch (Exception e){
                e.printStackTrace();
            }
            
            
        
        }else {
        
        setVisible(false);
        }
    }
    
    
public static void main(String[] args){

    new UpdateCustomer("Lallu");
}

    
}
