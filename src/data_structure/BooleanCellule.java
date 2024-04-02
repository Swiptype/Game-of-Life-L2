package data_structure;

public class BooleanCellule implements Cellule{

    protected int x;
    protected int y;

    protected int condition;
    protected int preCondition;

    protected int change;

    public BooleanCellule(int x, int y, int condition) {
        this.x = x;
        this.y = y;
        this.condition = condition;
        this.preCondition = condition;
        this.change = 0;
    }

    /*
    La fonction getX() permet de recuperer sa coordonnee en x.
    @result la valeur de x
    */
    public int getX() {
        return this.x;
    }

    /*
    La fonction getY() permet de recuperer sa coordonnee en y.
    @result la valeur de y
    */
    public int getY() {
        return this.y;
    }

    /*
    La fonction getCondition() permet de recuperer la condition actuelle de la cellule.
    @result sa condition
    */
    public int getCondition() {
        return this.condition;
    }

    /*
    La fonction getPreCondition() permet de recuperer la condition precedente de la cellule.
    @result sa condition precedente
    */
    public int getPreCondition() {
        return this.preCondition;
    }

    /*
    La fonction getChange() permet de recuperer le nombre de changement effectue sur la cellule.
    @result le nombre de changement
    */
    public int getChange() {
        return this.change;
    }

    /*
    La fonction setCondition() permet d'attribuer une nouvelle condition a la cellule
    @param condition est un entier
    @require condition == 1 || condition == 0
    @result void
    */
    public void setCondition(int condition) {
        this.condition = condition;
    }
    
    /*
    La fonction newCondition() permet d'attribuer une nouvelle condition via une loi auquelle il nous faut le nombre de cellules vivantes.
    @param loi est une class d'interface Law.
    @param grid est un tableau a 2 dimension de cellules
    @require Grid.newState(int nbCellAlive)
    @result void
    */
    public void newCondition (Law law, Grid grid) {
        this.preCondition = this.condition;
        this.condition = law.newState(law.aliveNeighbours(grid, this), this.condition);
        this.change++;
    }

    /*
    La fonction toString() permet d'attribuer une nouvelle condition via une loi auquelle il nous faut le nombre de cellules vivantes.
    @result les informations de la cellule
    */
    @Override
    public String toString() {
        return "BooleanCellule [x=" + x + ", y=" + y + ", condition=" + condition + ", change=" + change + "]";
    }

        
    
}
