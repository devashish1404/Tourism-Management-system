package travel.management.system;
import javax.swing.*;
import java.awt.*;






public class CheckPackage extends JFrame{
    CheckPackage(){
    setBounds(300,120,870,625);
    
    String[] package1 = {"PREMIUM PACKAGE", "6 Days and 7 Nights", "Airport Assistance", "5 star Hotel","Breakfast,Lunch and Dinner", "Relax and WanderZone", "Visit to Premium ISLANDS", "Marine Adventures", "Book Package", "Summer Special Per Person*", "Only 12000/-","package1.jpg" };
    String[] package2 = {"ADVANCED PACKAGE", "5 Days and 4 Nights", "Airport Assistance", "3 star Hotel", "Lunch and Dinner", "Daily Wandering","Visit to few ISLANDS", "Boating","Book Now", "Summer Special Per Person*", "Only 10,500/-","package2.jpg"};
    String[] package3 = {"STANDARD PACKAGE", "3 Days and 2 Nights", "Airport Assistance", "Simple Hotel","Only Dinner","Few Places", "No Visiting to ISLANDS", "No Boating","Book Now","Summer Special Per Person*","Only 8500/-","package3.jpg"};
    
    JTabbedPane tab = new JTabbedPane();
    JPanel p1 = createPackage(package1);
    tab.addTab("Package 1", null,  p1);
    
    
    JPanel p2 = createPackage(package2);
    tab.addTab("Package 2", null,  p2);
    
    JPanel p3 = createPackage(package3);
    tab.addTab("Package 3", null,  p3);
    
    
    
    add(tab);
    
    
    setVisible(true);
    
    }
    
    public JPanel createPackage(String[] pack){
    
        
    JPanel p1 = new JPanel();
    p1.setLayout(null);
    p1.setBackground(Color.WHITE);
    
    JLabel l1 = new JLabel(pack[0]);
    l1.setBounds(30,20,300,30);
    l1.setBackground(Color.WHITE);
    l1.setForeground(Color.YELLOW);
    l1.setFont(new Font("Tahoma", Font.BOLD, 28));
    p1.add(l1);
    
    JLabel l2 = new JLabel(pack[1]);
    l2.setBounds(30,80,300,30);
    //l2.setBackground(Color.RED);
    l2.setForeground(Color.RED);
    l2.setFont(new Font("Tahoma", Font.BOLD, 20));
    p1.add(l2);
    
    JLabel l3 = new JLabel(pack[2]);
    l3.setBounds(30,130,300,30);
    //l2.setBackground(Color.RED);
    l3.setForeground(Color.GREEN);
    l3.setFont(new Font("Tahoma", Font.BOLD, 20));
    p1.add(l3);
    
    JLabel l4 = new JLabel(pack[3]);
    l4.setBounds(30,180,300,30);
    //l2.setBackground(Color.RED);
    l4.setForeground(Color.RED);
    l4.setFont(new Font("Tahoma", Font.BOLD, 20));
    p1.add(l4);
    
    JLabel l5 = new JLabel(pack[4]);
    l5.setBounds(30,230,300,30);
    //l2.setBackground(Color.RED);
    l5.setForeground(Color.GREEN);
    l5.setFont(new Font("Tahoma", Font.BOLD, 20));
    p1.add(l5);
    
    JLabel l6 = new JLabel(pack[5]);
    l6.setBounds(30,280,300,30);
    //l2.setBackground(Color.RED);
    l6.setForeground(Color.RED);
    l6.setFont(new Font("Tahoma", Font.BOLD, 20));
    p1.add(l6);
    
    JLabel l7 = new JLabel(pack[6]);
    l7.setBounds(30,330,300,30);
    //l2.setBackground(Color.RED);
    l7.setForeground(Color.GREEN);
    l7.setFont(new Font("Tahoma", Font.BOLD, 20));
    p1.add(l7);
    
    JLabel l8 = new JLabel(pack[7]);
    l8.setBounds(30,380,300,30);
    //l2.setBackground(Color.RED);
    l8.setForeground(Color.RED);
    l8.setFont(new Font("Tahoma", Font.BOLD, 20));
    p1.add(l8);
    
    JLabel l9 = new JLabel(pack[8]);
    l9.setBounds(30,430,300,30);
    //l2.setBackground(Color.RED);
    l9.setForeground(Color.BLACK);
    l9.setFont(new Font("Tahoma", Font.BOLD, 25));
    p1.add(l9);
    
    JLabel l0 = new JLabel(pack[9]);
    l0.setBounds(30,480,300,30);
    //l2.setBackground(Color.RED);
    l0.setForeground(Color.magenta);
    l0.setFont(new Font("Tahoma", Font.BOLD, 20));
    p1.add(l0);
    
    JLabel l11 = new JLabel(pack[10]);
    l11.setBounds(500,480,300,30);
    //l2.setBackground(Color.RED);
    l11.setForeground(Color.cyan);
    l11.setFont(new Font("Tahoma", Font.BOLD, 20));
    p1.add(l11);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
    Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l12 = new JLabel(i3);
    l12.setBounds(340, 90, 500, 300);
    p1.add(l12);
    
    
    return p1;
    }
    
    public static void main(String[] args){
        new CheckPackage();
    }
}
