 
package calculator;
 import java.awt.*;
import static java.awt.Color.black;
import javax.swing.*;

import java.awt.event.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import static javafx.scene.paint.Color.color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public  class volume extends JFrame implements KeyListener{
    
    private Container c;
    private JTextArea taxt1,taxt2;
    private JButton convert;
    private Font arial_bold;
    private JLabel label1,label2,label3,label4;
    private JComboBox unit;
    private String[] unit_list = {"cm","mm","micrometer","nanometer" ,"foot","mile","ich"};
    volume(){
        
      framekey();  
      setDefaultCloseOperation(JFrame. DISPOSE_ON_CLOSE);
      this.setLocationRelativeTo(null);
      setBounds(200,50,600,300);
      setResizable(false);
    } 
    
    public void framekey(){
       
        c=this.getContentPane();
        c.setBackground(black);
        c.setLayout(null);
        
        label1 = new JLabel();
        label1.setText("UNIT CONVERTER");
        label1.setBounds(230, 10,300, 40);
        label1.setForeground(Color.WHITE);
        c.add(label1);
        
        label2 = new JLabel();
        label2.setText("Convert to unit");
        label2.setForeground(Color.WHITE);
        label2.setBounds(100 ,40,200,60);
        c.add(label2);
        
        label3 = new JLabel();
        label3.setText("Enter value");
        label3.setForeground(Color.WHITE);
        label3.setBounds(100,80,200,60);
        c.add(label3);
        
        label4 = new JLabel();
        label4.setText("Result");
        label4.setForeground(Color.WHITE);
        label4.setBounds(100,120,60,60);
        c.add(label4);
        
        unit= new JComboBox(unit_list);
        unit.setBounds(250, 60, 300, 20);
        unit.setSelectedItem("cm");
        c.add(unit);
        
        taxt1 = new JTextArea();
        taxt1.setBounds(250,100,300, 20);
        taxt1.setFont(arial_bold);
        taxt1.setLineWrap(true);
        c.add(taxt1);
        
        convert = new JButton();
        convert.setText("Convert");
        convert.setBounds(350,170,90,30);
        c.add(convert);
        
       
        
        taxt2 = new JTextArea();
        taxt2.setBounds(250,140,300,20);
        taxt2.setFont(arial_bold);
        taxt2.setLineWrap(true);
        c.add(taxt2);
        
         taxt1.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {

                String selected_type = unit.getSelectedItem().toString();
               
                if (selected_type == "cm") {
                    char c = ke.getKeyChar();

                    if (!(Character.isDigit(c))) {

                        ke.consume();

                    }
                } else if (selected_type == "mm") {
                    char c = ke.getKeyChar();
                       if (!(Character.isDigit(c))) {

                        ke.consume();

                    }
                   
                } else if (selected_type == "micrometer") {
                    char c = ke.getKeyChar();
                     if (!(Character.isDigit(c))) {

                        ke.consume();

                    }
  
                } 
                else if (selected_type == "foot") {
                    char c = ke.getKeyChar();
                     
                    if (!(Character.isDigit(c))) {

                        ke.consume();

                    }
                
                       
                }
                else if (selected_type == "ich") {
                    char c = ke.getKeyChar();
                     
                    if (!(Character.isDigit(c))) {

                        ke.consume();

                    }
                
                       
                }
                else if (selected_type == "mile") {
                    char c = ke.getKeyChar();
                     
                    if (!(Character.isDigit(c))) {

                        ke.consume();

                    }
                
                       
                }
                

            }

            @Override
            public void keyPressed(KeyEvent ke) {

                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    ke.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {

                int position = taxt1.getCaretPosition();
                taxt1.setText(taxt1.getText().toUpperCase());
                taxt1.setCaretPosition(position);

            }

        });
         
         convert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String type = unit.getSelectedItem().toString();
                
                String value = taxt1.getText();
                
                if(value.isEmpty()){
                //do nothing
                }else{
                 
                if ( type== "cm") {

                    double temp =0;
                     temp=Double.parseDouble(value)*100;
                     taxt2.setText(String.valueOf(temp));
                      
                }
                if (type == "mm") {

                     double temp =0;
                     temp=Double.parseDouble(value)*1000;
                     taxt2.setText(String.valueOf(temp));
                }

                if (type == "micrometer" ) {
                       double temp =0;
                     temp=Double.parseDouble(value)*1000000;
                     taxt2.setText(String.valueOf(temp));
                }
                if (type == "nanometer") {

                    double temp =0;
                     temp=Double.parseDouble(value)*1000000000;
                     taxt2.setText(String.valueOf(temp));  
                }
                if (type == "foot") {

                    double temp =0;
                     temp=Double.parseDouble(value)*3.28;
                     taxt2.setText(String.valueOf(temp));  
                }
                if (type == "ich") {

                    double temp =0;
                     temp=Double.parseDouble(value)*39.28;
                     taxt2.setText(String.valueOf(temp));  
                }
                if (type == "mile") {

                    double temp =0;
                     temp=Double.parseDouble(value)*0.00062;
                     taxt2.setText(String.valueOf(temp));  
                }
            }
            }
        });

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
          
    
      
            }
    
    
       
