

package calculator;
 
  
import java.awt.Container;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class percentage extends JFrame {
     private Container c;
     private JLabel lb,lb1,lb2,lb3;
     private JTextField percent,total,result;
     private JButton enter;
     
    percentage(){
        method();
        setDefaultCloseOperation(JFrame. DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setBounds(200,50,400,500);
        setResizable(false);
        setTitle("Percentage");
        
        
        
    }
    public void method(){
        
        c = this.getContentPane(); 
        c.setBackground(Color.black); 
        c.setLayout(null);
        
        
         lb=new JLabel("FIND PERCENTAGE");
         lb.setBounds(150,20,200,100);
         lb.setForeground(Color.WHITE);
         c.add(lb);
   
         lb1=new JLabel("Percent:");
         lb1.setBounds(15,80,200,60);
         lb1.setForeground(Color.WHITE);
         c.add(lb1);
     
    
    
    
         percent=new JTextField();
         percent.setBounds(100, 90, 200, 30);
         c.add(percent);
    
         lb2=new JLabel("Total:");
         lb2.setBounds(15,110,60,60);
         lb2.setForeground(Color.WHITE);
         c.add(lb2); 
    
    
         total=new JTextField();
         total.setBounds(100, 130, 200, 30);
         c.add(total);
        
         lb3=new JLabel("Result:");
         lb3.setBounds(15,150,60,60);
         lb3.setForeground(Color.WHITE);
         c.add(lb3); 
    
    
          result=new JTextField();
          result.setBounds(100, 170, 200, 30);
          result.setEditable(false);
          c.add(result);
            
          enter =new JButton("ENTER");
          enter.setBounds(150,210,100,40);
          c.add(enter);
          
          
          
          percent.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent ke) {
              
            String value = percent.getText();
            int l = value.length();
            if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')||ke.getKeyChar()=='.'||ke.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
               
                percent.setEditable(true);
               
            } else {
               //percent.setEditable(false);
               JOptionPane.showMessageDialog(null, " Enter only numeric digits(0-9)");
               percent.setText("");
               
            }
         }
        
        
        
    });
          
          
    total.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent ke) {
             
            String value = total.getText();
            int l = value.length();
            if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')||ke.getKeyChar()=='.'||ke.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
               percent.setEditable(true);
               
            } else {
               
               JOptionPane.showMessageDialog(null, " Enter only numeric digits(0-9)");
               total.setText("");
               
            }
         }
        
        
        
    });
    
     enter.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
        double r=(Double.parseDouble(total.getText())*Double.parseDouble(percent.getText()))/100;
        result.setText(""+r);
           
    }  
    });  
}
}  

