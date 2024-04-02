package interface_graphique.option;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import interface_graphique.Orchestrator;

import java.awt.*;


public class OptionPanel extends JPanel{

    protected JSpinner sp;
    protected JSpinner sp1;
    protected JSpinner sp2;

    protected JComboBox<String> liste1;
    protected JComboBox<String> liste2;
    protected JComboBox<String> liste3;
    protected JComboBox<String> liste4;

    public OptionPanel(Orchestrator root) {
    
     setLayout(new GridLayout(8, 2));
      
      
      //Largeur grille
      SpinnerModel model = new SpinnerNumberModel(
                  600, //valeur initiale
                  200, //valeur minimum
                  1000, //valeur maximum
                  10 //pas
      );
      this.sp = new JSpinner(model);
      sp.setBounds(100,100,55,30);  
      
      JLabel label1 = new JLabel("1");
      label1.setText("  Largeur grille");
      label1.setBounds(200,100,500,30);
      
      add(label1);
      add(sp);
      
    
    
      
      //Longueur grille  
      
      SpinnerModel model1 = new SpinnerNumberModel(
                  600, //valeur initiale
                  200, //valeur minimum
                  1000, //valeur maximum
                  10 //pas
      );
      this.sp1 = new JSpinner(model1);
      sp1.setBounds(100,200,55,30);  
      
      
      JLabel label2 = new JLabel("2");
      label2.setText("  Longueur grille");
      label2.setBounds(200,200,500,30);
      
      add(label2);
      add(sp1);
      
     
      
      
      //Pourcentage cellule vivante
      
      
      SpinnerModel model2 = new SpinnerNumberModel(
                  50, //valeur initiale
                  1, //valeur minimum
                  100, //valeur maximum
                  2 //pas
      );
      this.sp2 = new JSpinner(model2);
      sp2.setBounds(100,300,55,30);  
  
      
      JLabel label3 = new JLabel("3");
      label3.setText("  Pourcentage cellule vivante");
      label3.setBounds(200,300,500,30);
      
      add(label3);
      add(sp2);
      
    
      
      
      
      
      //Couleur case
      
      
      
      
      JLabel label4 =new JLabel("  Voir les couleurs");
      add(label4);
      label4.setBounds(150,0,250,50);

      String[] elements1 = new String[]{"Rouge", "Vert", "Bleu","Rose","Noir"};
      this.liste1 = new JComboBox<String>(elements1);
      liste1.setBounds(10, 10, 120, 23);
      add(liste1);
     
      
      liste1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              e.getSource();
          String s=(String) liste1.getSelectedItem();
          label4.setText("  Vous avez séléctionné : "+s);
      }
      });
      
      
      
      
      
      //Condition cellule vivante
      
      
      
      
      JLabel label5 =new JLabel("  Condition cellule vivante");
      add(label5);
      label5.setBounds(150,0,250,50);

      String[] elements2 = new String[]{"1", "2", "3","4","5","6","7","8"};
      this.liste2 = new JComboBox<String>(elements2);
      liste2.setBounds(10, 10, 120, 23);
      add(liste2);
      
      liste2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              e.getSource();
          String s=(String) liste2.getSelectedItem();
          label5.setText("  Vous avez séléctionné : "+s);
      }
      });
      
      
      //Condition cellule morte
      
      
      
      JLabel label6 =new JLabel("  Condition cellule morte de sous population");
      add(label6);
      label6.setBounds(150,0,250,50);

      String[] elements3 = new String[]{"1", "2", "3","4","5","6","7","8"};
      this.liste3 = new JComboBox<String>(elements3);
      liste3.setBounds(10, 10, 120, 23);
      add(liste3);
      
      
      liste3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              e.getSource();
          String s=(String) liste3.getSelectedItem();
          label6.setText("  Vous avez séléctionné : "+s);
      }
      });


      JLabel label7 =new JLabel("  Condition cellule morte de sur population");
      add(label7);
      label7.setBounds(150,0,250,50);

      String[] elements4 = new String[]{"1", "2", "3","4","5","6","7","8"};
      this.
      liste4 = new JComboBox<String>(elements4);
      liste4.setBounds(10, 10, 120, 23);
      add(liste4);
      
      
      liste4.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              e.getSource();
          String s=(String) liste4.getSelectedItem();
          label7.setText("  Vous avez séléctionné : "+s);
      }
      });



      // Bouton confirmer
      this.add(new JLabel(""));
      this.add(new MyButtonConfirmed(root, this));
    
      
     
    }
    public JSpinner getSP(){
        return this.sp;
    }

    public JSpinner getSP1(){
        return this.sp1;
    }
      

    public JSpinner getSP2(){
        return this.sp2;
    }

    public JComboBox<String> getListe1(){
        return this.liste1;
    }

    public JComboBox<String> getListe2(){
        return this.liste2;
    }

    public JComboBox<String> getListe3(){
        return this.liste3;
    }

    public JComboBox<String> getListe4(){
        return this.liste4;
    }
      
  }
  
 