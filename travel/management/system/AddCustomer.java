package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomer extends JFrame implements ActionListener {
    
    JLabel labelusername, labelname;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfphone, tfemail;
    JRadioButton rmale, rfemale, rother;
    JButton add,back;
    
    AddCustomer(String username){
    setBounds(350, 200, 850, 550);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    
    
    
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
    
    comboid = new JComboBox(new String[]{"Aadhar Card", "Pan Card","Passport","Ration card"});
    comboid.setBounds(220, 90, 150, 25);
    comboid.setBackground(Color.WHITE);
    add(comboid);
    
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
    
    rmale = new JRadioButton("Male");
    rmale.setBounds(220,210, 70 ,25);
    rmale.setBackground(Color.WHITE);
    add(rmale);
    
    rfemale = new JRadioButton("Female");
    rfemale.setBounds(290,210, 70 ,25);
    rfemale.setBackground(Color.WHITE);
    add(rfemale);
    
    rother = new JRadioButton("Other");
    rother.setBounds(380,210, 70 ,25);
    rother.setBackground(Color.WHITE);
    add( rother);
    
    ButtonGroup bg = new ButtonGroup();
    bg.add(rmale);
    bg.add(rfemale);
    bg.add(rother);
    
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
    
    add= new JButton("Add");
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
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
    Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(400,40, 450,420);
    add(image);
    
    try{
    Conn c = new Conn();
    ResultSet rs = c.s.executeQuery("select * from account where username ='"+username+"'");//ddl command
    while(rs.next()){
        labelusername.setText(rs.getString("username"));
        labelname.setText(rs.getString("name"));
    }
    
    }catch (Exception e){
    e.printStackTrace();
    }
    
    setVisible(true);
    
   }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            
            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if(rmale.isSelected()){
                 gender = "Male";
                 
            }else if(rfemale.isSelected()){
                 gender = "Female";
            
            }else {
                gender = "Other";
            }
            
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            
            try {
               Conn c= new Conn();
               String query = "insert into customer values('"+username+"','"+id+"','"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"','"+email+"')";
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

    new AddCustomer("");
}

    
}
