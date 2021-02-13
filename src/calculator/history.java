package calculator;

//import static calculator.calculator.text_field;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class history {

    JTextPane inputBox;
    JPanel panel_history;
    String result, line_read;
    BufferedReader br;
    JScrollPane inputbox_scrollpane;
    ArrayList<String> list;
    long lines=0;
    int counter;
    JFrame frame_history = new JFrame();

    history() {

        //***************************************Frame work********************************//
        panel_history = new JPanel();
        panel_history.setBackground(Color.black);
        frame_history.add(panel_history);

        //componants
        inputBox = new JTextPane(); 
        inputBox.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        inputBox.setBackground(Color.BLACK);
        inputBox.setForeground(Color.white);
        inputBox.setEditable(false);
        

        inputbox_scrollpane = new JScrollPane(inputBox);
        inputbox_scrollpane.setPreferredSize(new Dimension(430, 370));

        panel_history.add(inputbox_scrollpane);

        frame_history.setBounds(600, 200, 500, 420);
        frame_history.setLocationRelativeTo(null);
        frame_history.setDefaultCloseOperation(frame_history.DISPOSE_ON_CLOSE);
        frame_history.setResizable(false);

//******************************************end of frame works*********************//
    }

    //*****************************calculating  line number**************************//
    public void linenumber() {

         
        try (BufferedReader reader = new BufferedReader(new FileReader("output1.txt"))) {
 
            while (reader.readLine() != null) {
                lines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       
    }

    //************************writing in a new file*********************//
    public void write_file(String result) {

        linenumber();
          
        try {

            File file = new File("output1.txt");
            FileWriter fw = new FileWriter(file, true);

            PrintWriter pw = new PrintWriter(fw);
            pw.println(result + "         Date-" + java.time.LocalDate.now());
            pw.close();

        } catch (IOException ex) {
            System.out.println("File writer" + ex);
        }
         
         if(lines>13){
          deletefile();
          lines=0;
         }
        
    }

//***********************file reading****************************//
    public void read_file() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("output1.txt"));

            list = new ArrayList<String>();

            while ((line_read = br.readLine()) != null) {
                list.add(line_read);
            }

            Collections.reverse(list);

            for (String write : list) {

                inputBox.setText(inputBox.getText().trim() + "\n" + write);

            }

            br.close();

        } catch (FileNotFoundException ex) {

            System.out.println("history resfile" + ex);
        } catch (IOException ex) {

            System.out.println("history resfile" + ex);

        }
    }

    //************************************file deleting if calculation extends and writting the file to another file exept the last calculation***// 
    public void deletefile() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("output1.txt"));

            list = new ArrayList<String>();

            while ((line_read = br.readLine()) != null) {
                list.add(line_read);
            }

            br.close();

            File file = new File("D:\\2\\2.1\\project\\calculator-master\\calculator-master\\output1.txt");
            file.delete();
            file.createNewFile();

            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);

            for (counter = 1; counter < list.size(); counter++) {

                pw.println(list.get(counter)); 

            }
            pw.close();

        } catch (FileNotFoundException ex) {

            System.out.println("delete file" + ex);
        } catch (IOException ex) {

            System.out.println("delete file" + ex);

        }
    }

}
