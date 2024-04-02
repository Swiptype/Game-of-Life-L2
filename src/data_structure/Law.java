package data_structure;

public interface Law {
    
    /*
    La fonction newState() permet de renvoyer une nouvelle condition en fonction du nombre de cellules vivantes et de la condition actuelle de la cellule
    @param nbCellAlive est un entier
    @param condition est un entier
    @require condition == 0 || condition == 1
    @result un entier representant la nouvelle condition(0 ou 1).
    */
    public int newState(int nbCellAlive, int condition);

    /*
    La fonction aliveNeighbours() permet de recuperer le nombre de cellules autour
    @param grille est une class Grid
    @param cellule est une cellule
    @require Grid.getXY(int x, int y)
    @result le nombre de cellules vivantes autour.
    */
    public int aliveNeighbours(Grid grid, Cellule cellule);
}
