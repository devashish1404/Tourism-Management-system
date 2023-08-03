package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class DeleteDetails extends JFrame implements ActionListener{
    
    JButton delete;
    String username;
    DeleteDetails(String username){
        this.username = username;
        setBounds(300,120,870,625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lusername = new JLabel("Username");
        lusername.setBounds(30,50, 150, 25);
        add(lusername);
        
        JLabel lablusername = new JLabel();
        lablusername.setBounds(220,50, 150, 25);
        add(lablusername);
        
        JLabel lid = new JLabel("Id");
        lid.setBounds(30,110, 150, 25);
        add(lid);
        
        JLabel lablid = new JLabel();
        lablid.setBounds(220,110, 150, 25);
        add(lablid);
        
        JLabel lnumber = new JLabel("Number");
        lnumber.setBounds(30,170, 150, 25);
        add(lnumber);
        
        JLabel lablnumber = new JLabel();
        lablnumber.setBounds(220,170, 150, 25);
        add(lablnumber);

        
        JLabel lname = new JLabel("Name");
        lname.setBounds(30,230, 150, 25);
        add(lname);
        
        JLabel lablname = new JLabel();
        lablname.setBounds(220,230, 150, 25);
        add(lablname);

        JLabel lgender = new JLabel("Gender");
        lgender.setBounds(30,290, 150, 25);
        add(lgender);
        
        JLabel lablgender = new JLabel();
        lablgender.setBounds(220,290, 150, 25);
        add(lablgender);
        
        JLabel lcountry = new JLabel("Country");
        lcountry.setBounds(500,40, 150, 25);
        add(lcountry);
        
        JLabel lablcountry = new JLabel();
        lablcountry.setBounds(690,40, 150, 25);
        add(lablcountry);

        JLabel laddress = new JLabel("Address");
        laddress.setBounds(500,100, 150, 25);
        add(laddress);
        
        JLabel labladdress = new JLabel();
        labladdress.setBounds(690,100, 150, 25);
        add(labladdress);
        
        JLabel lphone = new JLabel("Phone");
        lphone.setBounds(500,160, 150, 25);
        add(lphone);
        
        JLabel lablphone = new JLabel();
        lablphone.setBounds(690,160, 150, 25);
        add(lablphone);
        
        JLabel lemail = new JLabel("Email");
        lemail.setBounds(500,220, 150, 25);
        add(lemail);
        
        JLabel lablemail = new JLabel();
        lablemail.setBounds(690,220, 150, 25);
        add(lablemail);
        
        delete =new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBounds(350,350,100,25);
        delete.addActionListener(this);
        add(delete);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 400, 600, 200);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600, 400, 600, 200);
        add(image2);
        
        try{
        Conn c = new Conn();
        
        String query = "select * from customer where username = '"+username+"'";
        ResultSet rs = c.s.executeQuery(query);
        while(rs.next()){
            lablusername.setText(rs.getString("username"));
            lablid.setText(rs.getString("id"));
            lablnumber.setText(rs.getString("number"));
            lablname.setText(rs.getString("name"));
            lablgender.setText(rs.getString("gender"));
            lablcountry.setText(rs.getString("country"));
            labladdress.setText(rs.getString("address"));
            lablphone.setText(rs.getString("phone"));
            lablemail.setText(rs.getString("email"));
        
        }
        
        
        }catch (Exception e){
        e.printStackTrace();
        }
            
        
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
    
       try{
          Conn c = new Conn();
          c.s.executeUpdate("delete from account where username = '"+username+"'");
          c.s.executeUpdate("delete from customer where username = '"+username+"'");
          c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
          c.s.executeUpdate("delete from bookhotel where username = '"+username+"'");
          
          JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
          
          System.exit(0);
       }catch (Exception e){
       e.printStackTrace();
       }
    }
    
    public static void main(String[] args){
        new DeleteDetails("Lallu");
    
    }
    
}
