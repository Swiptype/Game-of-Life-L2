package interface_graphique.le_menu;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class ReadMeButton extends JButton {
    protected JPanel panel;

    public ReadMeButton(JPanel panel) {
        
        super("Read Me");
        this.setBounds(200,350,300,100);
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setBackground(Color.black);
        this.setForeground(Color.WHITE);
        this.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    new ReadMeFrame();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        
    }
    
}
