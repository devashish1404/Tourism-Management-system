
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BookHotel extends JFrame implements ActionListener{
    
    JLabel labelusername, labelid, labelnumber, labelprice, labelphone;
    JTextField tfpersons, tfdays;
    Choice chotel, crooms, cfood;
    String username;
    JButton checkprice, bookhotel,back;
    
    BookHotel(String username){
    this.username = username;
    setBounds(200,120,1100,600);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    
    JLabel text = new JLabel("BOOK HOTEL");
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
    
    JLabel lpackage= new JLabel("Select Hotel");
    lpackage.setBounds(40, 110, 150, 20);
    lpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lpackage);
    
    chotel = new Choice();
    chotel.setBounds(250, 110, 180, 20);
    add(chotel);
    
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from hotels");
        while(rs.next()){
            chotel.add(rs.getString("name"));
        
        }
    }catch (Exception e){
        e.printStackTrace();
    }

    JLabel lperson= new JLabel("Total Person");
    lperson.setBounds(40, 145, 150, 25);
    lperson.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
    add(lperson);
    
    tfpersons = new JTextField(); // textfield are editable
    tfpersons.setBounds(250, 150, 180, 20);
    add(tfpersons);
    
    JLabel ldays = new JLabel("No. of Days");
    ldays.setBounds(40, 190, 150, 25);
    ldays.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
    add(ldays);
    
    tfdays = new JTextField(); // textfield are editable
    tfdays.setBounds(250, 190, 180, 20);
    add(tfdays);
    
    JLabel lrooms = new JLabel("Ac/Non-Ac");
    lrooms.setBounds(40, 230, 150, 25);
    lrooms.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
    add(lrooms);
    
    crooms = new Choice();
    crooms.add("Ac");
    crooms.add("Non-Ac");
    crooms.setBounds(250, 230, 180, 20);
    add(crooms);
    
    JLabel lfood = new JLabel("Food Included");
    lfood.setBounds(40, 270, 150, 25);
    lfood.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
    add(lfood);
    
    cfood = new Choice();
    cfood.add("Yes");
    cfood.add("No");
    cfood.setBounds(250, 270, 180, 20);
    add(cfood);
    
    JLabel lid= new JLabel("Id");
    lid.setBounds(40,310, 150, 20);
    lid.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lid);
    
    labelid = new JLabel(); //JLabel can't be edited that's why we didnt choose textfield
    labelid.setBounds(250, 310, 230, 20);
    add(labelid);
    
    JLabel lnumber= new JLabel("Number");
    lnumber.setBounds(40,350, 150, 25);
    lnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lnumber);
    
    labelnumber= new JLabel();
    labelnumber.setBounds(250,350, 150, 25);
    add(labelnumber);
    
    
    JLabel lphone = new JLabel("Phone");
    lphone.setBounds(40,390,150, 25);
    lphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lphone);
    
    labelphone = new JLabel();
    labelphone.setBounds(250,390, 200, 25);
    add(labelphone);
    
    JLabel lprice = new JLabel("Total Price");
    lprice.setBounds(40,430,150, 25);
    lprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lprice);
    
    labelprice = new JLabel();
    labelprice.setBounds(250,430, 150, 25);
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
    checkprice.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    checkprice.setBounds(60, 490, 120,25);
    checkprice.addActionListener(this);
    add(checkprice);
    
    bookhotel= new JButton("Book Hotel");
    bookhotel.setBackground(Color.BLACK);
    bookhotel.setForeground(Color.WHITE);
    bookhotel.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    bookhotel.setBounds(200, 490, 120,25);
    bookhotel.addActionListener(this);
    add(bookhotel);
    
    back= new JButton("Back");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
    back.setBounds(340, 490, 120,25);
    back.addActionListener(this);
    add(back);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
    Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l12 = new JLabel(i3);
    l12.setBounds(470, 40, 600, 400);
    add(l12);
    
   
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotels where name = '"+chotel.getSelectedItem()+"'");
            while(rs.next()){
                int cost = Integer.parseInt(rs.getString("costperperson"));//return string and convert into int
                int food = Integer.parseInt(rs.getString("foodincluded"));
                int room = Integer.parseInt(rs.getString("acroom"));
            
                int persons = Integer.parseInt(tfpersons.getText());
                int days = Integer.parseInt(tfdays.getText());
                
                String acselected = crooms.getSelectedItem();
                String foodselected = cfood.getSelectedItem();
                
                if(persons * days > 0){     //calculate per person cost
                
                    int total = 0;
                    total += acselected.equals("Ac") ? room : 0;
                    total += foodselected.equals("Yes") ? food : 0;
                    total += cost;
                    total = total * persons * days;
                    labelprice.setText("Rs "+total);
                }else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                }
            
            
            }
            }catch (Exception e){
            e.printStackTrace();
            }
        }else if(ae.getSource() == bookhotel){
        try{
            Conn c = new Conn();
            c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdays.getText()+"','"+crooms.getSelectedItem()+"','"+cfood.getSelectedItem()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
            JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
            setVisible(false);
        }catch (Exception e){
        e.printStackTrace();
        }
        }else {
            setVisible(false);
        }
    
    }
    
    
    public static void main(String[] args){
    
        new BookHotel("Lallu");
    }
}

