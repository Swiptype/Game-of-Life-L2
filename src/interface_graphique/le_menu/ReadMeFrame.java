package interface_graphique.le_menu;

import java.io.*;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ReadMeFrame extends JFrame{
    
    public ReadMeFrame() throws IOException{

        File file = new File("interface_graphique/le_menu/test.txt");    
     
        FileReader fr = new FileReader(file);  
           
        BufferedReader br = new BufferedReader(fr);  
        StringBuffer sb = new StringBuffer();    
        String line;
        while((line = br.readLine()) != null)
        {
            // ajoute la ligne au buffer
            sb.append(line);      
            sb.append("\n");     
        }

        br.close();
   
        JTextArea text = new JTextArea(sb.toString());
        text.setEditable(false);
        this.setTitle("README");
        this.setPreferredSize(new Dimension(800,400));
        this.add(text);
        text.setLayout(null);

        this.setLocationRelativeTo(null);
        this.pack();
        
        this.setVisible(true);
    }
}
