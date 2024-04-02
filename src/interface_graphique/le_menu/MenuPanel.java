package interface_graphique.le_menu;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Color;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interface_graphique.Orchestrator;

public class MenuPanel extends JPanel{
    
    protected Orchestrator root;
    
    Font font;
    protected JFrame frame1;

    public MenuPanel(Orchestrator root, JFrame frame1) {
        
        try{
            font = Font.createFont(Font.TRUETYPE_FONT, new File("interface_graphique/le_menu/ELNATH.ttf")).deriveFont(50f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("interface_graphique/le_menu/ELNATH.ttf")));
            
        }
        catch(IOException | FontFormatException e){
            
        }  
        
        
        JLabel titre =new JLabel("THE GAME OF LIFE");
        titre.setFont(font);
        titre.setForeground(new Color(0,0,0));
        titre.setBounds(100,-100,700,400);
        
        frame1.add(titre);
        frame1.add(new NewGameButton(root,this));
  
        frame1.add(new ReadMeButton(this));
    }
}
