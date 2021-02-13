 
package calculator;
import java.applet.Applet;
import java.applet.AudioClip; 
import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
 
public class calculator extends history implements ActionListener{
    String oparand1,operator,oparand2,operator2 ;
    JTextField text_field;
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bp,badd,bsub,bmul,bdiv,beq,bcl,bh,delete,constants,percentage,unitconverter,age ;
    JButton pi,gravity,temparature, cos45,cos90,cos30,cos60,sin45,sin90,sin30,sin60,tan45,tan90,tan30,tan60 ;
    //count is for counting if we already done a calculation
    int count =0;
    JPanel panel_main,panel_constanttable;
    
    //this falg is for "." representation
    //if we have more than one point in a operand the flag becomes 1
    int flag=0;
    //creating frame
    JFrame frame_constanttable=new JFrame( );
    JFrame frame_main=new JFrame("Calculator");
    
    volume v=new volume();
    percentage p= new percentage();
     
    
    
       
     calculator(){
         
        oparand1=operator=oparand2=operator2=""; 
        Framekey_main();
 
    }
    
    //************************frame creation for main visible jframe************//
    public void Framekey_main(){
 
         //components
         panel_main= new JPanel();
         frame_main.add(panel_main);
         panel_main.setBackground(Color.black);
         panel_main.setLayout(new GridBagLayout());
         
        text_field=new JTextField(5); 
        text_field.setEditable(false);
        text_field.setFont(new Font(Font.SERIF, Font.BOLD,20));
        text_field.setBorder(BorderFactory.createCompoundBorder(
                    new CustomeBorder2() ,new EmptyBorder(new Insets(10,10,10,10)
                    )));
           
          
        //***********************button design *************************//
         b0=new JButton("0"); 
         button_design(b0);
         b1=new JButton("1"); 
         button_design(b1);
         b2=new JButton("2"); 
         button_design(b2);
         b3=new JButton("3"); 
         button_design(b3);
         b4=new JButton("4"); 
         button_design(b4);
         b5=new JButton("5"); 
         button_design(b5);
         b6=new JButton("6"); 
         button_design(b6);
         b7=new JButton("7"); 
         button_design(b7);
         b8=new JButton("8"); 
         button_design(b8);
         b9=new JButton("9"); 
         button_design(b9);
         bp=new JButton("."); 
         button_design(bp);
         badd=new JButton("+"); 
         button_design(badd);
         bsub=new JButton("-"); 
         button_design(bsub);
         bmul=new JButton("*"); 
         button_design(bmul);
         bdiv=new JButton("/"); 
         button_design(bdiv);
         beq=new JButton("="); 
         button_design(beq);
         bcl=new JButton("C"); 
         button_design(bcl);
         bh=new JButton("H"); 
         button_design(bh);
         delete=new JButton("D"); 
         button_design(delete);
         constants=new JButton("constant"); 
         button_design(constants);
         percentage =new JButton("%"); 
         button_design(percentage);
         unitconverter =new  JButton("Unit"); 
         button_design(unitconverter);
         age =new JButton("Age"); 
         button_design(age);
      
        
         
        //******************************************lay out*****************************//
        GridBagConstraints c = new GridBagConstraints();
        c.weightx=1;
        c.weighty=1;
        
        
        c.gridy = 0;
        c.gridwidth =1;
        c.fill = GridBagConstraints.BOTH; 
        c.insets = new Insets(5, 5, 5, 5);
       
        panel_main.add(bh, c);
        
        
        c.gridy = 0;
        c.gridwidth =1;
        c.fill = GridBagConstraints.BOTH; 
        c.insets = new Insets(5, 5, 5, 5);
       
        panel_main.add(bcl, c);
       
         
        c.gridy = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
       
         panel_main.add(delete,c);
       
         
        c.gridy = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
       
         panel_main.add(text_field,c);

       
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
   
         panel_main.add(b1, c);

     
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
 
        panel_main.add(b2, c);

     
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        
        panel_main.add(b3, c);

 
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
      
        panel_main.add(bdiv, c);

 
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
       
        panel_main.add(b4, c);

 
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5); 
        panel_main.add(b5, c);

 
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
     
        panel_main.add(b6, c);
         

 
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
      
        panel_main.add(bmul, c);

  
        c.gridy = 3;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
       
        panel_main.add(b7, c);

     
        c.gridy = 3;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
      
        panel_main.add(b8, c);

     
        c.gridy = 3;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
      
        panel_main.add(b9, c);
 
        c.gridy = 3;
        c.fill = GridBagConstraints.BOTH;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
    
        panel_main.add(bsub, c);

      
        c.gridy = 4;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        
        panel_main.add(b0, c);

     
        c.gridy = 4;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
       
        panel_main.add(bp, c);

      
        c.gridy = 4;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        
        panel_main.add(beq, c);

       
        c.gridy = 4;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
      
        panel_main.add(badd, c);
        
      
        c.gridy =5;
        c.fill = GridBagConstraints.BOTH; 
        c.gridwidth =1;
        c.insets = new Insets(5, 5, 5, 5);
        
         panel_main.add(age,c);
            
           
        c.gridy = 5;
        c.fill = GridBagConstraints.BOTH; 
        c.gridwidth =1;
        c.insets = new Insets(5, 5, 5, 5);
        
         panel_main.add(percentage,c);
     
        c.gridy = 5;
        c.fill = GridBagConstraints.BOTH; 
        c.gridwidth =1;
        c.insets = new Insets(5, 5, 5, 5);
        
         panel_main.add(unitconverter,c);
         
      
        c.gridy = 5;
        c.fill = GridBagConstraints.BOTH; 
        c.gridwidth =1;
        c.insets = new Insets(5, 5, 5, 5);
        
        panel_main.add(constants,c);
          
      
          
        //*************adding action listener
         b0.addActionListener(this);
         b1.addActionListener(this);
         b2.addActionListener(this);
         b3.addActionListener(this);
         b4.addActionListener(this);
         b5.addActionListener(this);
         b6.addActionListener(this);
         b7.addActionListener(this);
         b8.addActionListener(this);
         b9.addActionListener(this);
         bp.addActionListener(this);
         badd.addActionListener(this);
         bsub.addActionListener(this);
         bmul.addActionListener(this);
         bdiv.addActionListener(this);
         beq.addActionListener(this);
         bcl.addActionListener(this);
         bh.addActionListener(this);
         delete.addActionListener(this);
         constants.addActionListener(this);
         percentage.addActionListener(this);
         unitconverter.addActionListener(this);
         age.addActionListener(this);
          
        //*********************frame setting****************//
         frame_main.setDefaultCloseOperation(EXIT_ON_CLOSE);
         frame_main.setBounds(400, 180, 500, 420);
         frame_main.setLocationRelativeTo(null);
         frame_main.setResizable(false);
         frame_main.setVisible(true);   
    }
    
    
     //*********************framekey for constant table frame****************//
    public void Framekey_constanttable(){
 
         //components
         panel_constanttable= new JPanel();
         frame_constanttable.add(panel_constanttable);
         panel_constanttable.setLayout(new GridBagLayout());
         
       //*******button design  
       pi= new JButton("p");
       button_design(pi);
       gravity= new JButton("g");
       button_design(gravity);
       temparature= new JButton("t");
       button_design(temparature);
       cos45= new JButton("cos45");
       button_design(cos45);
       cos90= new JButton("cos90");
       button_design(cos90);
       cos30= new JButton("cos30");
       button_design(cos30);;
       cos60= new JButton("cos60");
       button_design(cos60);
       sin45= new JButton("sin45");
       button_design(sin45);
       sin90= new JButton("sin90");
       button_design(sin90);
       sin30= new JButton("sin30");
       button_design(sin30);
       sin60= new JButton("sin60");
       button_design(sin60);
       tan45= new JButton("tan45");
       button_design(tan45);
       tan90= new JButton("tan90");
       button_design(tan90);
       tan30= new JButton("tan30");
       button_design(tan30);
       tan60= new JButton("tan60");
       button_design(tan60);
       
        
        //*************lauout*******  
        GridBagConstraints cg = new GridBagConstraints();
        cg.weightx=1;
        cg.weighty=1;
        
        cg.gridy = 1;
        cg.gridwidth =1;
        cg.insets = new Insets(5, 5, 5, 5);
        cg.fill = GridBagConstraints.BOTH;
 
        panel_constanttable.add(pi, cg);
       
      
        cg.gridy = 1;
        cg.gridwidth = 1;
        cg.insets = new Insets(5, 5, 5, 5);
        cg.fill = GridBagConstraints.BOTH;
        
        panel_constanttable.add(gravity,cg);

     
        cg.gridy = 1;
        cg.gridwidth = 1;
        cg.insets = new Insets(5, 5, 5, 5);
        cg.fill = GridBagConstraints.BOTH;
        
        panel_constanttable.add(temparature, cg);
 
        cg.gridy = 1;
        cg.gridwidth =1;
        cg.insets = new Insets(5, 5, 5, 5);
        cg.fill = GridBagConstraints.BOTH;
 
        panel_constanttable.add(cos30, cg);

 
        cg.gridy = 1;
        cg.gridwidth = 1;
        cg.insets = new Insets(5, 5, 5, 5);
        cg.fill = GridBagConstraints.BOTH;
 
        panel_constanttable.add(cos45, cg);
        
 
        cg.gridy = 2;
        cg.gridwidth = 1; 
        cg.insets = new Insets(5, 5, 5, 5);
        cg.fill = GridBagConstraints.BOTH; 
        
        panel_constanttable.add(cos60, cg);
      
        cg.gridy = 2;
        cg.gridwidth = 1; 
        cg.insets = new Insets(5, 5, 5, 5);
        cg.fill = GridBagConstraints.BOTH; 
        
        panel_constanttable.add(cos90, cg);
        
 
        cg.gridy = 2;
        cg.gridwidth = 1; 
        cg.insets = new Insets(5, 5, 5, 5);
        cg.fill = GridBagConstraints.BOTH; 
        
        panel_constanttable.add(sin30, cg);
 
        cg.gridy = 2;
        cg.gridwidth = 1; 
        cg.insets = new Insets(5, 5, 5, 5);
        cg.fill = GridBagConstraints.BOTH;
  
        panel_constanttable.add(sin45, cg);
        
 
        cg.gridy = 2;
        cg.gridwidth = 1; 
        cg.insets = new Insets(5, 5, 5, 5);
        cg.fill = GridBagConstraints.BOTH;
 
        panel_constanttable.add(sin60, cg);
        
     
        cg.gridy = 3;
        cg.gridwidth =1; 
        cg.insets = new Insets(5, 5, 5, 5);
        cg.fill = GridBagConstraints.BOTH; 
        
        panel_constanttable.add(sin90, cg);
        
 
        cg.gridy = 3;
        cg.gridwidth =1; 
        cg.insets = new Insets(5, 5, 5, 5);
        cg.fill = GridBagConstraints.BOTH;
 
        panel_constanttable.add(tan30, cg);
        
         
        cg.gridy = 3;
        cg.gridwidth =1; 
        cg.insets = new Insets(5, 5, 5, 5);
        cg.fill = GridBagConstraints.BOTH;
 
        panel_constanttable.add(tan45, cg);
        
 
        cg.gridy = 3;
        cg.gridwidth =1; 
        cg.insets = new Insets(5, 5, 5, 5);
        cg.fill = GridBagConstraints.BOTH;
  
        panel_constanttable.add(tan60, cg);
        
 
        cg.gridy = 3;
        cg.gridwidth =1; 
        cg.insets = new Insets(5, 5, 5, 5);
        cg.fill = GridBagConstraints.BOTH; 
        
        panel_constanttable.add(tan90, cg);
        
    
        
         //adding action listener 
         pi.addActionListener(this);
         gravity.addActionListener(this);
         temparature.addActionListener(this);
         cos30.addActionListener(this);
         cos45.addActionListener(this);
         cos60.addActionListener(this);
         cos90.addActionListener(this);
         sin30.addActionListener(this);
         sin45.addActionListener(this);
         sin60.addActionListener(this);
         sin90.addActionListener(this);
         tan30.addActionListener(this);
         tan45.addActionListener(this);
         tan60.addActionListener(this);
         tan90.addActionListener(this); 
        
        //***********final frame work
        panel_constanttable.setBackground(Color.black); 
        frame_constanttable.setDefaultCloseOperation(frame_constanttable. DISPOSE_ON_CLOSE);
        frame_constanttable.setBounds(0, 0, 450, 250);
        frame_constanttable.setLocation(frame_main.getX() + frame_main.getWidth(), frame_main.getY());
        frame_constanttable.setVisible(true);
        frame_constanttable.setResizable(false);
         
            
      
          
    }
    
 
    //*************************Error sound function//
     private void sound(){
        try{
        AudioClip clip = Applet.newAudioClip(getClass().getResource("/calculator/error.wav"));
        clip.play();
        }
        catch (Exception e){
            System.out.println("sound"+e);     
        }
    
    }
    
  
     //*********************************Defining Button action************************//
     
     public void actionPerformed(ActionEvent e){
        
        String s=e.getActionCommand();
        
          
                 //******************checks for oparands***********************8//
 
        if((s.charAt(0)>='0'&&s.charAt(0)<='9')|| s.charAt(0)=='.'){
            
            //solution for point in a operand
            //if flag is 1 means we already have a point in operand then
            //so programm will not take point for operand
             if(s.charAt(0)=='.'){
                  
               if(flag==0){
                    flag=1;   
               }    
               else  { 
                   s="";   
               }                 
           }
            
            //if operator is available value goes to operand 2
            //if we have - takes - along with next operand
             if(!operator.equals("")){
            
                 if(!oparand1.equals("")&&!operator2.equals("")){
                   oparand2=operator2+s; 
                  text_field.setText(oparand1+operator+oparand2);
                  operator2="";
              }
                 else{
                  oparand2=oparand2+s;    
                 } 
            }
            
            //if we have - operator before first operand .operand goes to operand 1
            else if(!operator2.equals("")){
             
              oparand1=operator2+s; 
              text_field.setText(oparand1);
              operator2="";  
            }
            
            //if no operator vallue then goes to operand one
            else{
                
                //if we already got and output  then erases the feild
                if(count==1){
                     text_field.setText("");
                     oparand1=s;
                     count=0;
                   } 
                else{       
                    oparand1=oparand1+s;   
                }  
            }  
            //setting  all values in textfield
            text_field.setText(oparand1+operator+oparand2);
             
        } 
        
        
                  //***********************checks for operarss*********************//
        
         else if(s.charAt(0)=='+'|| s.charAt(0)=='-'||s.charAt(0)=='*'||s.charAt(0)=='/'){
             
             double result=0;
             flag=0;//for ponit
             
             //if there is no previous operator and 2nd operand
           if(operator.equals("")==true && oparand2.equals("")==true){
                
                //if the operator is before first operand
               if(oparand1.equals("")==true){
                   
                 if(s.charAt(0)=='-') {   
                 operator2=s; 
                 text_field.setText(operator2+oparand1+operator+oparand2);}
         
                 }
               
               else{
                     
                 operator=s;          
                 text_field.setText(oparand1+operator+oparand2);
              
                 }
                    
             }
           
         else if(!operator.equals("")){ 
             
             //if we have another minas
             if(s.charAt(0)=='-'&& oparand2.equals("")){
                 
                 operator2=s; 
                 text_field.setText( oparand1+operator+operator2+oparand2);
             }
             
             else if(oparand2.equals("")){
               JOptionPane.showMessageDialog(null, "Can not give another  operator");
               sound();
             }
             
             else{
                if(s.equals("+"))
                    result=Double.parseDouble(oparand1)+Double.parseDouble(oparand2);
                if(s.equals("-"))
                    result=Double.parseDouble(oparand1)-Double.parseDouble(oparand2);
                if(s.equals("*"))
                    result=Double.parseDouble(oparand1)*Double.parseDouble(oparand2);
                if(s.equals("/"))
                    result=Double.parseDouble(oparand1)/Double.parseDouble(oparand2);
                
                
                oparand1=Double.toString(result);
                operator=s;
                oparand2="";
                text_field.setText(oparand1+operator+oparand2);
                
                super.write_file(text_field.getText());
                frame_history.setVisible(false);
             }  
           }
             
        } 
     
          //*************************ans geting*************************8//
         
        else if(s.charAt(0)=='='){
            
            count=1;
            
            if((oparand1=="")||(operator!=""&&oparand2=="")||(oparand1==".")||(oparand2==".")){
               
                sound();  
                oparand1=operator=oparand2="";
                JOptionPane.showMessageDialog(null, "ERROR");
            }
            
            else if(oparand1!="" && oparand2==""){
                
                text_field.setText(oparand1+"="+oparand1);
            }
            
            else{
                
            double result=0;
            
            if(operator.equals("+")){
                result=Double.parseDouble(oparand1)+Double.parseDouble(oparand2);
             }
            
            else if(operator.equals("-")){
                result=Double.parseDouble(oparand1)-Double.parseDouble(oparand2);
             }
            
            else if(operator.equals("*")){
                result=Double.parseDouble(oparand1)*Double.parseDouble(oparand2);
             }
            
            else if(operator.equals("/")){
                  result=Double.parseDouble(oparand1)/Double.parseDouble(oparand2);
             }
            
            text_field.setText(oparand1+operator+oparand2+"="+result);
            operator="";
            
            
            //_____________Writting every ans in file history________//
            
             
             super.write_file(text_field.getText());
             frame_history.setVisible(false);
             
            //________________________________________________________//
            
            oparand1=Double.toString(result);
            operator="";
            oparand2="";
            
            
         }
               
        } 
    
//_______________________________other functions________________________________________//
       
        //Constant table
        else if(s =="constant"){
           Framekey_constanttable();
        }
        
        //Clearing textfeild
        else if(s.charAt(0)=='C'){
            
            oparand1=operator=oparand2="";
            text_field.setText("");
            flag=0;
        }
        
        //History frame showing
        else if(s.charAt(0)=='H'){
            
         v.setVisible(false);
         p.setVisible(false);
         frame_history.setLocation(frame_main.getX() + frame_main.getWidth(), frame_main.getY());
         super.inputBox.setText(null); 
         super.read_file(); 
         frame_history.setVisible(true);
        }
        
        //Volume calculation
        else if(s =="Unit"){
            
             frame_history.setVisible(false);
             p.setVisible(false);
             v.setLocation(frame_main.getX() + frame_main.getWidth(), frame_main.getY());
             v.setVisible(true);
        }
        //age calculation
        else if(s=="Age"){
           
            AgeCal agecal =new AgeCal();
           agecal.setLocation(frame_main.getX() + frame_main.getWidth(), frame_main.getY());
     
        }
        
        //Percentage calculation
        else if(s.charAt(0)=='%'){
            
            frame_history.setVisible(false);
             v.setVisible(false);
             p.setLocation(frame_main.getX() + frame_main.getWidth(), frame_main.getY());
             p.setVisible(true); 
        }
        
        //Deleting number by number
        else if(s.equals("D")){
 
            int length=text_field.getText().length();
            int n=length-1;
            
 
            /* s_oparand= oparand1.substring( oparand1.length()- 1);
             line=text_field.getText();
              */
            if (length > 0) {

                String line, value;
                line = text_field.getText();
                value = line.substring(line.length() - 1);

                StringBuilder str = new StringBuilder(text_field.getText());
                str.deleteCharAt(n);
                String text = str.toString();
                text_field.setText(text);

                if (operator.endsWith(value)) {
                    operator = "";
                } else if (!oparand2.endsWith(value)&& !operator.endsWith(value)&&!oparand1.equals("")) {

                    oparand1 = oparand1.substring(0, oparand1.length() - 1);

                } else if (oparand2.endsWith(value)&&oparand1.endsWith(value)) {

                    oparand2 = oparand2.substring(0, oparand2.length() - 1);

                }else{
                    oparand2 = oparand2.substring(0, oparand2.length() - 1);
                }

                /*   
                for (int i = 0 ; i != oparand1.length() ; i++) {
                 StringBuilder str1=new StringBuilder(oparand1);  
                     
                 if(str.charAt(i) ==value.charAt(i)){
                  str.deleteCharAt(i);
                 
                }     
            } */
            }
             
        }
          


//*******************************************constant table work***************************************//
       else{
                                          
        if(s=="p"){
             
             s="3.1416";
         }
        
         if(s=="t"){
             
             s="98";
            }
        
       else if(s =="g"){
            s="9.8";       } 
       
       else if( s=="cos45"){
            s="0.70";       
           }
       
       else if( s=="cos60"){
            s="0.5"; 
       }
       
       else if( s =="cos30"){
            s="0.866";    
           } 
       
       else if( s =="cos90"){
            s="0";
            
           }
       else if( s=="sin45"){
            s="0.70";
   
           }
       
       else if( s=="sin30"){
            s="0.5";
       }
       
       else if( s =="sin60"){
            s="0.86";
    
           }
       
       else if( s=="sin90"){
            s="1";
      
           }
       
       else if( s.equals("tan45")){
            s="1";     
           }
       
       else if( s=="tan30"){
            s=" 0.57"; 
           }
       
       else if( s =="tan60"){
            s="1.73";            }
       
       else if(s =="tan90"){
            s="";    
           } 
         
         
                    //*********** again operand taking from the constant value******************//
   //if no oparand with point                            
   if(s=="98"||s=="0"||s=="1"){
   
                 
             if(!operator.equals("")){
              
              oparand2=oparand2+s;  
            }
            
            //if we have operator before first operand .operand goes to operand 1
            else if(!operator2.equals("")){
              
              oparand1=operator2+s; 
              text_field.setText(oparand1);
              operator2="";
            }
            
            //if no operator vallue then goes to operand one
            else{
                
                //if we already got and output  then erases the feild
                if(count==1){
                    
                     text_field.setText("");
                     oparand1=s;
                     count=0;
                   }
                
                else{ 
                        
                    oparand1=oparand1+s;   
                }  
            }  
            
            //setting  all values in textfield
            text_field.setText(oparand1+operator+oparand2);
                 
 
                 }
   //for tan90
   else if(s==""){
         sound();    
         JOptionPane.showMessageDialog(null, " undefined");  
   }
   
    //if oparand has point
   else {
        
     //solution for point in a operand    
     if(flag==0){
             
         flag=1; 
         
         //already have operator
          if(!operator.equals("")){
              
              oparand2=oparand2+s;  
            }
            
         //if we have operator before first operand .operand goes to operand 1
          else if(!operator2.equals("")){
              
              oparand1=operator2+s; 
              text_field.setText(oparand1);
              operator2="";
            }
            
         //if no operator vallue then goes to operand one
         else{
                
         //if we already got and output  then erases the feild
                if(count==1){
                    
                     text_field.setText("");
                     oparand1=s;
                     count=0;
                   }
                
                else{         
                    oparand1=oparand1+s;   
                }  
            }  
            
            //setting  all values in textfield
            text_field.setText(oparand1+operator+oparand2);
             
               } 
               //if flag is 1 means we already have a point in operand then
               //so programm will not take point for operand
      else
               {
                   s=""; 
                   sound();
                   JOptionPane.showMessageDialog(null, "Can not give another oparand with point");
               }    
            }
        }
        
       
        }
     
     
     
        //***********************design for button******************//
     public void button_design(JButton button){
      
         button.setFont(new Font(Font.SERIF, Font.BOLD,20));  
         button.setForeground(Color.white);
         button.setBackground(new Color(1,51,20)); 
         button.setBorder(BorderFactory.createCompoundBorder(
                    new CustomeBorder() ,new EmptyBorder(new Insets(10,10,10,10)
                    )));
  }
      
     private static class CustomeBorder  extends AbstractBorder{
     public void paintBorder(Component c, Graphics g, int x, int y,
                int width, int height) {
            // TODO Auto-generated method stubs
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(12));
            g2d.setColor( Color.BLACK);
            g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
        } 
    } 
     
     private static class CustomeBorder2 extends AbstractBorder{
     public void paintBorder(Component c, Graphics g, int x, int y,
                int width, int height) {
            // TODO Auto-generated method stubs
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(20));
            g2d.setColor( new Color(1,51,20));
            g2d.drawRoundRect(x, y, width - 1, height - 1, 30, 30);
        } 
    } 
}
    
