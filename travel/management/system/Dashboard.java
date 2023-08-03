package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{

    String username;
    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails,checkPackages,bookPackages,viewPackages, viewhotels;
    JButton destinations, bookhotels, viewbookedhotels, payments,calculators, notepad, about, deletePersonalDetails;
    Dashboard(String username){
    this.username = username;
    
    
    setBounds(0,0, 1600, 1000);
    setExtendedState(JFrame.MAXIMIZED_BOTH);// To open on full size screen
    setLayout(null);
    
    JPanel p1 = new JPanel();
    p1.setLayout(null);
    p1.setBackground(new Color(0,0, 102));
    p1.setBounds(0, 0, 1600, 65);
    add(p1);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
    Image i2= i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
    ImageIcon i3= new ImageIcon(i2);
    JLabel icon=new JLabel(i3);//put icons in frame
    icon.setBounds(5, 0, 70, 70);
    p1.add(icon);
     
    JLabel heading = new JLabel("Dashboard");
    heading.setBounds(80, 10, 300,  40);
    heading.setForeground(Color.WHITE);
    heading.setFont(new Font("TAHOMA", Font.BOLD,28));
    p1.add(heading);
    
    JPanel p2 = new JPanel();
    p2.setLayout(null);
    p2.setBackground(new Color(0,0, 102));
    p2.setBounds(0, 65, 300, 900);
    add(p2);
    
    addPersonalDetails= new JButton("Add Personal Details");
    addPersonalDetails.setBackground(new Color(0,0, 102));
    addPersonalDetails.setForeground(Color.WHITE);
    addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
    addPersonalDetails.setBounds(0, 0, 300,50);
    addPersonalDetails.setMargin(new Insets(0,0,0,60));
    addPersonalDetails.addActionListener(this);
    p2.add(addPersonalDetails);
    
    
    updatePersonalDetails= new JButton("Update Personal Details");
    updatePersonalDetails.setBackground(new Color(0,0, 102));
    updatePersonalDetails.setForeground(Color.WHITE);
    updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
    updatePersonalDetails.setBounds(0, 45, 300,50);
    updatePersonalDetails.setMargin(new Insets(0,0,0,30));
    updatePersonalDetails.addActionListener(this);
    p2.add(updatePersonalDetails);
    
    viewPersonalDetails= new JButton("View Details");
    viewPersonalDetails.setBackground(new Color(0,0, 102));
    viewPersonalDetails.setForeground(Color.WHITE);
    viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
    viewPersonalDetails.setBounds(0,90, 300,50);
    viewPersonalDetails.setMargin(new Insets(0,0,0,130));
    viewPersonalDetails.addActionListener(this);
    p2.add(viewPersonalDetails);
    
    deletePersonalDetails= new JButton("Delete Personal Details");
    deletePersonalDetails.setBackground(new Color(0,0, 102));
    deletePersonalDetails.setForeground(Color.WHITE);
    deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
    deletePersonalDetails.setBounds(0, 135, 300,50);
    deletePersonalDetails.setMargin(new Insets(0,0,0,30));
    deletePersonalDetails.addActionListener(this);
    p2.add(deletePersonalDetails);
    
    checkPackages= new JButton("Check Packages");
    checkPackages.setBackground(new Color(0,0, 102));
    checkPackages.setForeground(Color.WHITE);
    checkPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
    checkPackages.setBounds(0, 180, 300,50);
    checkPackages.setMargin(new Insets(0,0,0,100));
    checkPackages.addActionListener(this);
    p2.add(checkPackages);
    
    bookPackages= new JButton("Book Packages");
    bookPackages.setBackground(new Color(0,0, 102));
    bookPackages.setForeground(Color.WHITE);
    bookPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
    bookPackages.setBounds(0, 225, 300,50);
    bookPackages.setMargin(new Insets(0,0,0,110));
    bookPackages.addActionListener(this);
    p2.add(bookPackages);
    
    viewPackages= new JButton("View Package");
    viewPackages.setBackground(new Color(0,0, 102));
    viewPackages.setForeground(Color.WHITE);
    viewPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
    viewPackages.setBounds(0, 270, 300,50);
    viewPackages.setMargin(new Insets(0,0,0,130));
    viewPackages.addActionListener(this);
    p2.add(viewPackages);
    
    viewhotels = new JButton("View Hotel");
    viewhotels.setBackground(new Color(0,0, 102));
    viewhotels.setForeground(Color.WHITE);
    viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
    viewhotels.setBounds(0, 315, 300,50);
    viewhotels.setMargin(new Insets(0,0,0,150));
    viewhotels.addActionListener(this);
    p2.add(viewhotels);
    
    bookhotels = new JButton("Book Hotel");
    bookhotels.setBackground(new Color(0,0, 102));
    bookhotels.setForeground(Color.WHITE);
    bookhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
    bookhotels.setBounds(0, 360, 300,50);
    bookhotels.setMargin(new Insets(0,0,0,150));
    bookhotels.addActionListener(this);
    p2.add(bookhotels);
    
    viewbookedhotels = new JButton("View Booked Hotel");
    viewbookedhotels.setBackground(new Color(0,0, 102));
    viewbookedhotels.setForeground(Color.WHITE);
    viewbookedhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
    viewbookedhotels.setBounds(0, 405, 300,50);
    viewbookedhotels.setMargin(new Insets(0,0,0,80));
    viewbookedhotels.addActionListener(this);
    p2.add(viewbookedhotels);
    
    destinations= new JButton("Destination");
    destinations.setBackground(new Color(0,0, 102));
    destinations.setForeground(Color.WHITE);
    destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
    destinations.setBounds(0, 450, 300,50);
    destinations.setMargin(new Insets(0,0,0,150));
    destinations.addActionListener(this);
    p2.add(destinations);
    
    payments= new JButton("Payment");
    payments.setBackground(new Color(0,0, 102));
    payments.setForeground(Color.WHITE);
    payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
    payments.setBounds(0, 495, 300,50);
    payments.setMargin(new Insets(0,0,0,170));
    payments.addActionListener(this);
    p2.add(payments);
    
    calculators= new JButton("Calculator");
    calculators.setBackground(new Color(0,0, 102));
    calculators.setForeground(Color.WHITE);
    calculators.setFont(new Font("Tahoma", Font.PLAIN, 20));
    calculators.setBounds(0, 540, 300,50);
    calculators.setMargin(new Insets(0,0,0,160));
    calculators.addActionListener(this);
    p2.add(calculators);
    
    notepad= new JButton("Notepad");
    notepad.setBackground(new Color(0,0, 102));
    notepad.setForeground(Color.WHITE);
    notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
    notepad.setBounds(0, 585, 300,50);
    notepad.setMargin(new Insets(0,0,0,170));
    notepad.addActionListener(this);
    p2.add(notepad);
    
    about= new JButton("About");
    about.setBackground(new Color(0,0, 102));
    about.setForeground(Color.WHITE);
    about.setFont(new Font("Tahoma", Font.PLAIN, 20));
    about.setBounds(0, 630, 300,50);
    about.setMargin(new Insets(0,0,0,190));
    about.addActionListener(this);
    p2.add(about);
    
    ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
    Image i5= i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
    ImageIcon i6= new ImageIcon(i5);
    JLabel image=new JLabel(i6);//put icons in frame
    image.setBounds(0, 0, 1650, 1000);
    add(image);
    
    JLabel text = new JLabel("TOUR AND TRAVEL MANAGEMENT");
    text.setBounds(400, 70, 1200, 70);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN,50));
    image.add(text);
    
    
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource() == addPersonalDetails){
            new AddCustomer(username);
        
      }else if(ae.getSource() == viewPersonalDetails){
            new ViewCustomer(username);
      }else if(ae.getSource() == updatePersonalDetails){
          new UpdateCustomer(username);
      }else if(ae.getSource() == checkPackages){
          new CheckPackage();
      }else if (ae.getSource() == bookPackages){
          new BookPackage(username);
      }else if (ae.getSource() == viewPackages){
          new ViewPackage(username);
      }else if (ae.getSource() == viewhotels){
          new CheckHotels();
      }else if (ae.getSource() == destinations){
          new Destinations();
      }else if (ae.getSource() == bookhotels){
          new BookHotel(username);
      }else if (ae.getSource() == viewbookedhotels){
          new ViewBookedHotel(username);
      }else if (ae.getSource() == payments){
          new Payment();
      }else if (ae.getSource() == calculators){
          try{
          Runtime.getRuntime().exec("calc.exe");
          }catch(Exception e){
          e.printStackTrace();
          }
      }else if (ae.getSource() == notepad){
          try{
          Runtime.getRuntime().exec("notepad.exe");    
          }catch(Exception e){
          e.printStackTrace();
          }
      }else if(ae.getSource() == about){
          new About();
      }else if(ae.getSource() == deletePersonalDetails){
          new DeleteDetails(username);
      }
    
    
    }
    
    
      public static void main(String[] args){
            new Dashboard("");
      }




    
}
