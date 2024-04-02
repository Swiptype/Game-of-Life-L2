package data_structure;

public interface Cellule {
    
    /*
    La fonction getX() permet de recuperer sa coordonnee en x.
    @result la valeur de x
    */
    public int getX();

    /*
    La fonction getY() permet de recuperer sa coordonnee en y.
    @result la valeur de y
    */
    public int getY();

    /*
    La fonction getCondition() permet de recuperer la condition actuelle de la cellule.
    @result sa condition
    */
    public int getCondition();

    /*
    La fonction getPreCondition() permet de recuperer la condition precedente de la cellule.
    @result sa condition precedente
    */
    public int getPreCondition();

    /*
    La fonction getChange() permet de recuperer le nombre de changement effectue sur la cellule.
    @result le nombre de changement
    */
    public int getChange();

    /*
    La fonction setCondition() permet d'attribuer une nouvelle condition a la cellule
    @param condition est un entier
    @result void
    */
    public void setCondition(int condition);

    /*
    La fonction newCondition() permet d'attribuer une nouvelle condition via une loi auquelle il nous faut le nombre de cellules vivantes.
    @param loi est une class d'interface Law.
    @param grid est un tableau a 2 dimension de cellules
    @require Law.newState(int nbCellAlive)
    @result void
    */
    public void newCondition (Law loi, Grid grid);

}
