package data_traitment;

import data_structure.*;

public class Demo {
    
    public static void main(String[] args) {
        
        Law loi = new ClassicLaw();
        Grid grille = new QuadGridTab(23500, 10000, 3); // max -> 22500*10000
        
        grille.toFill(0.1);
        System.out.println(grille.getXY(6, 8));
        grille.repeatLaw(loi,20,false);

    }
}
