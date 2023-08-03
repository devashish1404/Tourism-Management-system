package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class ViewPackage extends JFrame implements ActionListener{
    
    JButton back;
    JLabel labelusername, labelid, labelnumber, labelprice, labelphone, labelpackage, labelpersons;
    
    ViewPackage(String username){
        setBounds(350,200,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setBounds(60, 0,300,30);
        text.setFont(new Font("Tahoma", Font.BOLD , 20));
        add(text);
        
        JLabel lusername = new JLabel("Username");
        lusername.setBounds(30,50, 150, 25);
        add(lusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220,50, 150, 25);
        add(labelusername);
        
        JLabel lpackage = new JLabel("Package");
        lpackage.setBounds(30,90, 150, 25);
        add(lpackage);
        
        labelpackage = new JLabel();
        labelpackage.setBounds(220,90, 150, 25);
        add(labelpackage);
        
        JLabel lpersons = new JLabel("Total Persons");
        lpersons.setBounds(30,130, 150, 25);
        add(lpersons);
        
        labelpersons = new JLabel();
        labelpersons.setBounds(220,130, 150, 25);
        add(labelpersons);

        
        JLabel lid= new JLabel("Id");
        lid.setBounds(30,170, 150, 20);
        //lid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lid);
    
        labelid = new JLabel(); //JLabel can't be edited that's why we didnt choose textfield
        labelid.setBounds(220, 170, 150, 25);
        add(labelid);
    
        JLabel lnumber= new JLabel("Number");
        lnumber.setBounds(30,210, 150, 25);
        //lnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lnumber);
    
        labelnumber= new JLabel();
        labelnumber.setBounds(220,210, 150, 25);
        add(labelnumber);
    
    
        JLabel lphone = new JLabel("Phone");
        lphone.setBounds(30,250,150, 25);
        //lphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lphone);
    
        labelphone = new JLabel();
        labelphone.setBounds(220,250, 150, 25);
        add(labelphone);
    
        JLabel lprice = new JLabel("Price");
        lprice.setBounds(30,290,150, 25);
        //lprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lprice);
    
        labelprice = new JLabel();
        labelprice.setBounds(220, 290, 150, 25);
        add(labelprice);
        
        back =new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,360,100,25);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookeddetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 500, 400);
        add(image);

        
        try{
        Conn c = new Conn();
        
        String query = "select * from bookpackage where username = '"+username+"'";
        ResultSet rs = c.s.executeQuery(query);
        while(rs.next()){
            labelusername.setText(rs.getString("username"));
            labelid.setText(rs.getString("id"));
            labelpackage.setText(rs.getString("package"));
            labelprice.setText(rs.getString("price"));
            labelpersons.setText(rs.getString("persons"));
            labelphone.setText(rs.getString("phone"));
            labelnumber.setText(rs.getString("number"));
        }
        
        
        }catch (Exception e){
        e.printStackTrace();
        }
            
        
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
    
        setVisible(false);
    }
    
    public static void main(String[] args){
        new ViewPackage("Lallu");
    
    }
    
}