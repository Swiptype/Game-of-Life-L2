package interface_graphique.option;

public class Config {

    public final int largeurGrille;
    public final int longueurGrille;
    public final String couleurs;
    public final double pourcentageCelluleVivante;
    public final int conditionCelluleVivante;
    public final int conditionMorteSousPopulation;
    public final int conditionMorteSurPopulation;

    public Config(int largeurGrille, int longueurGrille, String couleurs, double pourcentageCelluleVivante, int conditionCelluleVivante, int conditionMorteSousPopulation, int conditionMorteSurPopulation){
        this.largeurGrille = largeurGrille;
        this.longueurGrille = longueurGrille;
        this.couleurs = couleurs;
        this.pourcentageCelluleVivante = pourcentageCelluleVivante;
        this.conditionCelluleVivante = conditionCelluleVivante;
        this.conditionMorteSousPopulation = conditionMorteSousPopulation;
        this.conditionMorteSurPopulation = conditionMorteSurPopulation;
    }

    public Config() {
        this.largeurGrille = 1000;
        this.longueurGrille = 1000;
        this.couleurs = "rouge";
        this.pourcentageCelluleVivante = 0.2;
        this.conditionCelluleVivante = 3;
        this.conditionMorteSousPopulation = 1;
        this.conditionMorteSurPopulation = 4;
    }
      
      
}
