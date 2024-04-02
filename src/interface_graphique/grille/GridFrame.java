package interface_graphique.grille;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data_structure.*;
import interface_graphique.option.Config;

public class GridFrame {
    
    protected Config config;

    public GridFrame(Config config) {
        JFrame frame = new JFrame("GameOfLife");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Arrete l execution apres avoir ferme la fenetre
        
        int facteurCellule = 1;
        Grid grid = new QuadGridTab(config.largeurGrille/facteurCellule, config.longueurGrille/facteurCellule, 1);
        grid.toFill(config.pourcentageCelluleVivante);

        MonDessin d = new MonDessin(grid, config);
        frame.add(d);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Law loi = new ConditionalLaw(config.conditionCelluleVivante, config.conditionMorteSousPopulation, config.conditionMorteSurPopulation);
        ActionListener repeated = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                grid.applyLaw(loi);
                d.repaint();
            }
        };

        int timeClock = 1;
        Timer clock = new Timer(timeClock, repeated);
        clock.start();

        System.out.println(Thread.currentThread() + " en fin de MaFenetre()");
    }


}
