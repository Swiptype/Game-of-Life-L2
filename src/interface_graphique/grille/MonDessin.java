package interface_graphique.grille;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import data_structure.*;
import interface_graphique.option.Config;

public class MonDessin extends JPanel {

    protected Grid grid;
    protected Config config;
    protected JLabel cptAlive;

    public MonDessin(Grid grid, Config config) {
        this.grid = grid;
        this.config = config;
        this.setPreferredSize(new Dimension(this.config.largeurGrille, this.config.longueurGrille));
        this.setBackground(Color.BLUE);
        this.setOpaque(false);
        this.cptAlive = new JLabel("Compteur de cellules vivantes");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color gColor = g.getColor();
        //g.fillRect(0,0,this.getWidth(), this.getHeight()/2);
        //g.fillRect(300,300,this.getWidth()/4, this.getHeight()/2);
        
        this.printInterGraph(g, false);
        String text = "Cellules vivantes : " + grid.getNbAlive();
        this.cptAlive.setText(text);
        this.cptAlive.setBounds(0,0,200,20);
        this.add(this.cptAlive);
        g.setColor(gColor);
        System.out.println(Thread.currentThread() + " en fin de paintComponent()");
    }

    /*
    La fonction printInterGraph(..) permet de dessiner toutes les cellules sur le graphiques
    @param g est de la classe Graphics
    @param withBordute est un booleen
    @result void
    */
    public void printInterGraph(Graphics g, boolean withBordure) {
        int factRowWindow = this.config.largeurGrille/this.grid.getRow();
        int factColumnWindow = this.config.longueurGrille/this.grid.getColumn();
        Color colorCell;
        switch (config.couleurs) {
            case "Rouge":
                colorCell = Color.RED;
                break;
            
            case "Vert":
                colorCell = Color.GREEN;
                break;

            case "Bleu":
                colorCell = Color.BLUE;
                break;

            case "Rose":
                colorCell = Color.PINK;
                break;
            
            case "Noir":
                colorCell = Color.BLACK;
                break;
        
            default:
                colorCell = Color.RED;
                break;
        }
        for (int i = 0; i < this.grid.getRow(); i++) {
            for (int j = 0; j < this.grid.getColumn(); j++) {
                if (this.grid.getXY(i,j).getCondition() == 1) {
                    g.setColor(colorCell);
                    g.fillRect(i*factRowWindow, j*factColumnWindow, factRowWindow, factColumnWindow);
                }
                if (withBordure) {
                    g.setColor(Color.black);
                    g.drawRect(i*factRowWindow, j*factColumnWindow, factRowWindow, factColumnWindow);
                }
            }
        }
    }
    
    public void printInterGraph(Graphics g) {
        this.printInterGraph(g, true);
    }

}

//Abstract FActory