package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread thread;
    Splash(){
     //setSize(1200, 600);// to make a framesize(set size taken two argument)
     //setLocation(100, 100);
     
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
     Image i2= i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
     ImageIcon i3= new ImageIcon(i2);
     JLabel image=new JLabel(i3);//put icons in frame
     add(image);
     
     
     setVisible(true);//visualize the frame
     thread = new Thread(this);
     thread.start();
     run();

    }
    public void run(){
      try{  
     Thread.sleep(2000);
     //new login
     //setVisible(false);    
    }catch (Exception e){
        
    }
 }

public static void main(String[] args){
    
    new Splash();
    Splash frame= new Splash();
    int x=1;
    for(int i=1;i<=500;x+=7, i+=6){
    frame.setSize(x+i,i);
    frame.setLocation(1000-(x+i/2), 370-i/2);
    
    
    try{
       Thread.sleep(20); 
    }catch(Exception e){
    
}
    
    
    
    
    
    }   
}
} 
