 
package calculator;
 
//import static calculator.calculator.text_field;
import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Font; 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter; 
import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JScrollPane; 
import javax.swing.JTextField;

public class history  {
  JTextField inputBox;
  JPanel panel_history;
  String result;
  BufferedReader br;
  JScrollPane inputbox_scrollpane;
  JFrame frame_history=new JFrame();
  
  
  
  
   history( ){  
       
 //***************************************Frame work********************************//
         
       
       panel_history =new JPanel();
       panel_history.setBackground(Color.black);
       frame_history.add(panel_history);
        
        //componants
       inputBox=new JTextField();
       inputBox.setBackground(Color.white);
       inputBox.setFont(new Font(Font.SERIF, Font.BOLD,20));
       inputBox.setEditable( false); 
       
       inputbox_scrollpane=new  JScrollPane(inputBox);
       inputbox_scrollpane.setPreferredSize(new Dimension(430,370));
       
       panel_history.add(inputbox_scrollpane);
       
       frame_history .setBounds( 600,200, 500, 420);
       frame_history.setLocationRelativeTo(null);
       frame_history.setDefaultCloseOperation(frame_history.DISPOSE_ON_CLOSE);
       frame_history.setResizable(false); 
       
//******************************************end of frame works*********************//

       
        
       
   }
   
 
   //file writting
   public void write_file(String result){
       try {
           
            File file =new File("output1.txt");
            FileWriter fw=new FileWriter(file,true); 
 
            PrintWriter pw =new PrintWriter(fw);
            pw.println(result);
            pw.close();
       }
       
            catch (IOException ex) {
                 System.out.println("File riter"+ex);
            }
   }
   
   
   
   
   //file reading
   public void read_file(){
      
      try {   
                BufferedReader br=null;
                br= new BufferedReader(new FileReader("output1.txt")) ;
                inputBox.read(br,null);
                inputBox.requestFocus();  
                br.close(); 
                
                }  
      catch (FileNotFoundException ex) {
          
             System.out.println("history resfile"+ex);   
            } 
      
      catch (IOException ex) {
          
            System.out.println("history resfile"+ex);
            
      }
   }
}
