package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class ViewBookedHotel extends JFrame implements ActionListener{
    
    JButton back;
    JLabel labelusername, labeldays, labelnumber, labelprice, labelphone, labelpackage, labelpersons;
    JLabel labelrooms, labelfood, labelid;
    ViewBookedHotel(String username){
        setBounds(300,100,1000, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setBounds(60, 0,400,30);
        text.setFont(new Font("Tahoma", Font.BOLD , 20));
        add(text);
        
        JLabel lusername = new JLabel("Username");
        lusername.setBounds(30,50, 150, 25);
        add(lusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220,50, 150, 25);
        add(labelusername);
        
        JLabel lpackage = new JLabel("Hotel Name");
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

        
        JLabel ldays= new JLabel("Total Days");
        ldays.setBounds(30,170, 150, 20);
        //lid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(ldays);
    
        labeldays = new JLabel(); //JLabel can't be edited that's why we didnt choose textfield
        labeldays.setBounds(220, 170, 150, 25);
        add(labeldays);
    
        
        JLabel lrooms = new JLabel("Ac/Non-Ac");
        lrooms.setBounds(30,210, 150, 25);
        //lnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lrooms);
    
        labelrooms= new JLabel();
        labelrooms.setBounds(220,210, 150, 25);
        add(labelrooms);
        
        JLabel lfood = new JLabel("Food Included ?");
        lfood.setBounds(30,250, 150, 25);
        //lnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lfood);
    
        labelfood= new JLabel();
        labelfood.setBounds(220,250, 150, 25);
        add(labelfood);
        
        JLabel lid= new JLabel("Id");
        lid.setBounds(30,290, 150, 25);
        //lnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lid);
    
        labelid= new JLabel();
        labelid.setBounds(220,290, 150, 25);
        add(labelid);
        
        JLabel lnumber= new JLabel("Number");
        lnumber.setBounds(30,330, 150, 25);
        //lnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lnumber);
    
        labelnumber= new JLabel();
        labelnumber.setBounds(220,330, 150, 25);
        add(labelnumber);
    
    
        JLabel lphone = new JLabel("Phone");
        lphone.setBounds(30,370,150, 25);
        //lphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lphone);
    
        labelphone = new JLabel();
        labelphone.setBounds(220,370, 150, 25);
        add(labelphone);
    
        JLabel lprice = new JLabel("Price");
        lprice.setBounds(30,410,150, 25);
        //lprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lprice);
    
        labelprice = new JLabel();
        labelprice.setBounds(220, 410, 150, 25);
        add(labelprice);
        
        back =new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,460,100,25);
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
        
        String query = "select * from bookhotel where username = '"+username+"'";
        ResultSet rs = c.s.executeQuery(query);
        while(rs.next()){
            labelusername.setText(rs.getString("username"));
            labelid.setText(rs.getString("id"));
            labelpackage.setText(rs.getString("name"));
            labelprice.setText(rs.getString("price"));
            labelpersons.setText(rs.getString("persons"));
            labelphone.setText(rs.getString("phone"));
            labelnumber.setText(rs.getString("number"));
            labelfood.setText(rs.getString("food"));
            labelrooms.setText(rs.getString("rooms"));
            labeldays.setText(rs.getString("days"));
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
        new ViewBookedHotel("Lallu");
    
    }
    
}