package interface_graphique.le_menu;

import javax.swing.JFrame;

import interface_graphique.Orchestrator;

import java.awt.Dimension;

public class MenuFrame extends JFrame{
    
    protected Orchestrator root;

    public MenuFrame(Orchestrator root) {
        super("GameOfLife");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new MenuPanel(root, this));

        this.setPreferredSize(new Dimension(700,600));
        this.pack();
        this.setLocationRelativeTo(null);
        //this.setVisible(true);
        this.setResizable(false);
        System.out.println(Thread.currentThread() + " en fin de MaFenetre()");
    }

    public MenuFrame() {
        this(null);
    }

    public static void main(String[] args) {
        MenuFrame menu = new MenuFrame();
        menu.setVisible(true);

    }

}
