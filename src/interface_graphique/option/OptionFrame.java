package interface_graphique.option;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

import interface_graphique.Orchestrator;

import javax.swing.ImageIcon;

public class OptionFrame extends JFrame {

    public OptionFrame(Orchestrator root) {
      super("Option");
      JLabel background=new JLabel(new ImageIcon("image.png"));
      this.setPreferredSize(new Dimension(700,400));
      this.add(background);
      background.setLayout(null);
      this.setContentPane(new OptionPanel(root));
      this.setLocationRelativeTo(null);
      this.pack();
     
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public OptionFrame() {
      this(null);
    }

    public static void main(String[] args) {
      new OptionFrame();
    }
      
  }
  