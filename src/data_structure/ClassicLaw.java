package data_structure;

public class ClassicLaw implements Law {

    /*
    La fonction newState() permet de renvoyer une nouvelle condition en fonction du nombre de cellules vivantes et de la condition actuelle de la cellule
    @param nbCellAlive est un entier
    @param condition est un entier
    @require condition == 0 || condition == 1
    @result un entier representant la nouvelle condition(0 ou 1).
    */
    public int newState(int nbCellAlive, int condition) {
        if (condition == 1) {
            if (nbCellAlive <= 1) {
                condition--;
            }
            if (nbCellAlive >= 4) {
                condition--;
            }
        }
        if (condition == 0) {
            if (nbCellAlive == 3) {
                condition++;
            }
        }
        return condition;
    }

    /*
    La fonction aliveNeighbours() permet de recuperer le nombre de cellules autour
    @param grille est une class Grid
    @param cellule est une Cellule
    @require Grid.getXY(int x, int y)
    @result le nombre de cellules vivantes autour.
    */
    public int aliveNeighbours(Grid grid, Cellule cellule) {
        int alive = 0;
        int x = cellule.getX();
        int y = cellule.getY();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ( (0 <= (x + i) && (x + i) < grid.getRow()) && (0 <= (y + j) && (y + j) < grid.getColumn()) && ( i != 0 || j != 0) ) { //inverser get Row et Column
                    if (cellule.getChange() == grid.getXY(x+i, y+j).getChange()){
                        alive += grid.getXY(x+i, y+j).getCondition();
                    }
                    else {
                        alive += grid.getXY(x+i, y+j).getPreCondition();
                    }
                }
            }
        }
        return alive;
    }

}
