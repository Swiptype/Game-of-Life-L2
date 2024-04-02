package hash_life.interface_graph;

import hash_life.structure.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawHashLife extends JPanel {

    protected HashLifeGameOfLife hashlife;
    protected int width, height;

    /*
     * La fonction DrawHashLife est un constructeur qui permettra de créer le dessin qui sera ajouté à la fenêtre pour faire un affichage graphique du HashLife
     * @param : hashlife est un Objet HashLife
     * @param : width est un entier qui represente la largeur
     * @param : height est un entier qui represente la hauteur
     * @require : width et height supérieurs à 0
     */
    public DrawHashLife(HashLifeGameOfLife hashlife, int width, int height) {
        this.hashlife = hashlife;
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width,height));
        this.setOpaque(false);
    }

    /*
     * C'est dans la fonction paintComponent qu'on fait les dessins qu'on ajoutera à la fenêtre
     * @param : g est la fenêtre dans laquelle on dessine
     * @require : withBordure = false pour que le dessin soit visible
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color gColor = g.getColor();

        this.printInter(g,false);
        g.setColor(gColor);
        
    }

    /*
     * La fonction printInter permet l'affichage de l'ensemble des cases
     * @param : g est la fenere dans laquelle on desine
     * @param : withBordure est un booléen pour savoir si on affiche ou non la fenêtre (false : on affiche)
     */
    public void printInter(Graphics g, boolean withBordure) {
        int factRowWindow = this.width/this.hashlife.getRow();
        int factColumnWindow = this.height/this.hashlife.getColumn();
        for (int i = 0; i < this.hashlife.getRow(); i++) {
            for (int j = 0; j < this.hashlife.getColumn(); j++) {
                if (this.hashlife.getXY(i,j) == 1) {
                    g.setColor(Color.blue);
                    g.fillRect(i*factRowWindow, j*factColumnWindow, factRowWindow, factColumnWindow);
                }
                if (withBordure) {
                    g.setColor(Color.black);
                    g.drawRect(i*factRowWindow, j*factColumnWindow, factRowWindow, factColumnWindow);
                }
            }
        }
    }
    
    public void printInter(Graphics g) {
        this.printInter(g, true);
    }

}
