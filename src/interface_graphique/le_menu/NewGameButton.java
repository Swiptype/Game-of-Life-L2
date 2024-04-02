package interface_graphique.le_menu;

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

import interface_graphique.Orchestrator;


public class NewGameButton extends JButton {

    protected Orchestrator root;
    protected JPanel panel;
    
    public NewGameButton(Orchestrator root, JPanel panel) {
        
        super("Nouvelle Partie");
        this.setBounds(200,200,300,100);
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setBackground(Color.black);
        this.setForeground(Color.WHITE);
        this.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                root.openOptionFrame();
            }
        });
        
    }
    
}
    
