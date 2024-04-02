package data_structure;

public class ConditionalLaw implements Law{

    protected int conditionCellAlive;
    protected int conditionCellDeadSubDemo;
    protected int conditionCellDeadSupDemo;

    public ConditionalLaw(int conditionCellAlive, int conditionCellDeadSubDemo, int conditionCellDeadSupDemo) {
        this.conditionCellAlive = conditionCellAlive;
        this.conditionCellDeadSubDemo = conditionCellDeadSubDemo;
        this.conditionCellDeadSupDemo = conditionCellDeadSupDemo;
    }

    /*
    La fonction newState() permet de renvoyer une nouvelle condition en fonction du nombre de cellules vivantes et de la condition actuelle de la cellule
    @param nbCellAlive est un entier
    @param condition est un entier (1 si la cellule est vivante et 0 si elle est morte)
    @require condition == 0 || condition == 1
    @result un entier representant la nouvelle condition(0 ou 1).
    */
    public int newState(int nbCellAlive, int condition) {
        if (condition == 1) {
            if (nbCellAlive <= this.conditionCellDeadSubDemo) {
                condition--;
            }
            if (nbCellAlive >= this.conditionCellDeadSupDemo) {
                condition--;
            }
        }
        if (condition == 0) {
            if (nbCellAlive == this.conditionCellAlive) {
                condition++;
            }
        }
        return condition;
    }

    /*
    La fonction aliveNeighbours() permet de recuperer le nombre de cellules autour
    @param grille est une class Grid
    @param cellule est une cellule
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
