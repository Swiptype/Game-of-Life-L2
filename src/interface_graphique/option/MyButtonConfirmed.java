package interface_graphique.option;

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

import interface_graphique.Orchestrator;


public class MyButtonConfirmed extends JButton implements ActionListener {

    protected Orchestrator root;

    protected OptionPanel panel;

    protected Config config;

    public MyButtonConfirmed(Orchestrator root, OptionPanel panel) {
        super("Confirmer");
        this.root = root;
        this.panel = panel;
        this.setBounds(200,200,300,100);
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setBackground(Color.black);
        this.setForeground(Color.WHITE);
        this.config = new Config();
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        double pourcent = Double.valueOf((int) panel.getSP2().getValue())/100;
        this.config = new Config(
            (int) panel.getSP().getValue(), 
            (int) panel.getSP1().getValue(), 
            panel.getListe1().getSelectedItem().toString(), 
            pourcent, 
            Integer.parseInt(panel.getListe2().getSelectedItem().toString()), 
            Integer.parseInt(panel.getListe3().getSelectedItem().toString()), 
            Integer.parseInt(panel.getListe4().getSelectedItem().toString())
        );
        System.out.println(this.config.pourcentageCelluleVivante);
        this.root.setConfig(this.config);
        this.root.openGridFrame();
    } 
        
    }

    