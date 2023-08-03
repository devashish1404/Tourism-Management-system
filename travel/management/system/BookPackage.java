
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BookPackage extends JFrame implements ActionListener{
    
    JLabel labelusername, labelid, labelnumber, labelprice, labelphone;
    JTextField tfpersons;
    Choice cpackage;
    String username;
    JButton checkprice, bookpackage,back;
    
    BookPackage(String username){
    this.username = username;
    setBounds(350,120,950,500);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    
    JLabel text = new JLabel("BOOK PACKAGE");
    text.setBounds(100, 10, 200, 30);
    text.setFont(new Font("Tahoma", Font.BOLD, 20));
    add(text);
   
    JLabel lusername= new JLabel("Username");
    lusername.setBounds(40, 70, 100, 20);
    lusername.setFont(new Font("Tahoma", Font.BOLD, 16));
    add(lusername);
    
    labelusername= new JLabel();// regarding username answer
    labelusername.setBounds(250, 70, 100, 20);
    lusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(labelusername);
    
    JLabel lpackage= new JLabel("Select Package");
    lpackage.setBounds(40, 110, 150, 20);
    lpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lpackage);
    
    cpackage = new Choice();
    cpackage.add("PREMIUM PACKAGE");
    cpackage.add("ADVANCED PACKAGE");
    cpackage.add("STANDARD PACKAGE");
    cpackage.setBounds(250, 110, 180, 20);
    add(cpackage);

    JLabel lperson= new JLabel("Total Person");
    lperson.setBounds(40, 145, 150, 25);
    lperson.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
    add(lperson);
    
    tfpersons = new JTextField(); // textfield are editable
    tfpersons.setBounds(250, 150, 180, 20);
    add(tfpersons);
    
    
    JLabel lid= new JLabel("Id");
    lid.setBounds(40,190, 150, 20);
    lid.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lid);
    
    labelid = new JLabel(); //JLabel can't be edited that's why we didnt choose textfield
    labelid.setBounds(250, 190, 230, 20);
    add(labelid);
    
    JLabel lnumber= new JLabel("Number");
    lnumber.setBounds(40,230, 150, 25);
    lnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lnumber);
    
    labelnumber= new JLabel();
    labelnumber.setBounds(250,230, 150, 25);
    add(labelnumber);
    
    
    JLabel lphone = new JLabel("Phone");
    lphone.setBounds(40,270,150, 25);
    lphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lphone);
    
    labelphone = new JLabel();
    labelphone.setBounds(250,270, 200, 25);
    add(labelphone);
    
    JLabel lprice = new JLabel("Total Price");
    lprice.setBounds(40,310,150, 25);
    lprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lprice);
    
    labelprice = new JLabel();
    labelprice.setBounds(250,310, 150, 25);
    add(labelprice);
    
    try{
    Conn c = new Conn();
    ResultSet rs = c.s.executeQuery("select * from customer where username ='"+username+"'");//ddl command
    while(rs.next()){
            labelusername.setText(rs.getString("username"));
            labelid.setText(rs.getString("id"));
            labelnumber.setText(rs.getString("number"));
            labelphone.setText(rs.getString("phone"));
           
    }
    
    }catch (Exception e){
    e.printStackTrace();
    }
    
    checkprice= new JButton("Check Price");
    checkprice.setBackground(Color.BLACK);
    checkprice.setForeground(Color.WHITE);
    //back.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    checkprice.setBounds(60, 380, 120,25);
    checkprice.addActionListener(this);
    add(checkprice);
    
    bookpackage= new JButton("Book Package");
    bookpackage.setBackground(Color.BLACK);
    bookpackage.setForeground(Color.WHITE);
    //back.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    bookpackage.setBounds(200, 380, 120,25);
    bookpackage.addActionListener(this);
    add(bookpackage);
    
    back= new JButton("Back");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    //back.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    back.setBounds(340, 380, 120,25);
    back.addActionListener(this);
    add(back);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
    Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l12 = new JLabel(i3);
    l12.setBounds(500, 50, 400, 300);
    add(l12);
    
   
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("PREMIUM PACKAGE")){
                cost += 12000;
            }else if(pack.equals("ADVANCED PACKAGE")){
                cost += 10500;
            }else {
                cost += 8500;
            }
         int persons = Integer.parseInt(tfpersons.getText());
         cost *= persons;
         labelprice.setText("Rs "+cost);
        }else if(ae.getSource() == bookpackage){
        try{
            Conn c = new Conn();
            c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
            JOptionPane.showMessageDialog(null, "Package Book Successfully");
            setVisible(false);
        }catch (Exception e){
        e.printStackTrace();
        }
        }else {
            setVisible(false);
        }
    
    }
    
    
    public static void main(String[] args){
    
        new BookPackage("Lallu");
    }
}
