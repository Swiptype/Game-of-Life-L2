package data_structure;

public interface Grid {
    
    /*
    La fonction getXY() permet de recuperer une cellule dans une certaine coordonnee
    @param x est un entier
    @param y est un entier
    @require 0 <= x && x < getRow()
    @require 0 <= y && y < getColumn()
    @result une cellule
    */
    public Cellule getXY(int x, int y);

    /*
    La fonction getRow() permet de recuperer le nombre de lignes
    @result le nombre de lignes
    */
    public int getRow();

    /*
    La fonction getColumn() permet de recuperer le nombre de colonnes
    @result le nombre de colonnes
    */
    public int getColumn();

    /*
    La fonction print() permet d'afficher la grille en console
    @result void
    */
    public void print();

    /*
    La fonction toFill() permet d'inserer des cellules en fonction d'un taux(degreeAlive)
    @param degreeAlive est un flotant
    @require 0 <= degreeAlive && degreeAlive <= 1
    @result void
    */
    public void toFill(double degreeAlive);

    /*
    La fonction applyLaw() permet d'appliquer une loi.
    @param loi est une classe qui permet d'appliquer une condition
    @require Law != null
    @result void
    */
    public void applyLaw(Law loi);

    /*
    La fonction repeatLaw() permet de repeter l'application d'une loi sur un nombre fois nCap et on peut choisir d'afficher la grille.
    @param loi est une classe qui permet d'appliquer une condition
    @param nCap est un entier
    @param printable est une booleen
    @require nCap >= 0
    @result void
    */
    public void repeatLaw(Law loi, int nCap, boolean printable);

    /*
    La fonction getNbAlive() permet de recuperer le nombre de cellules dites vivantes
    @result un nombre de cellules 'vivantes' 
    */
    public int getNbAlive();

}
