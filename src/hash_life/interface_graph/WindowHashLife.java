package hash_life.interface_graph;

import hash_life.structure.*;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowHashLife {

    public int width;
    public int height;
    /*
     * La fonction WindowHashLife créer une fenêtre Java.swing dans laquelle on ajoute le dessin du HashLife
     * @param : width est un entier representant la largeur
     * @param : height est un entier qui represente la hauteur
     * @require : width et height supérieurs à 0
     * @require : hashlife.fillgrid(0 < double < 1 )
     * @require : hashlife.run(1er argument minimum égal à 1)
     */
    public WindowHashLife(int width,int height){
        JFrame frame = new JFrame("Game Of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HashLifeGameOfLife hashlife = new HashLifeGameOfLife(new int[width][height]);
        hashlife.fillGrid(0.2);

        DrawHashLife draw = new DrawHashLife(hashlife, width, height);
        frame.add(draw);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ActionListener repeat = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                hashlife.run(1,false);
                draw.repaint();
            }
        };

        int speed = 1;
        Timer clock = new Timer(speed, repeat);
        clock.start();

        System.out.println(Thread.currentThread() + " en fin de MaFenetre()");
    }

    public WindowHashLife(int width){
        this(width,width);
    }
}
