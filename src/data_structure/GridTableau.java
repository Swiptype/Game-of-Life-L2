package data_structure;

public class GridTableau implements Grid{

    protected int row;
    protected int column;

    protected Cellule[][] grid;

    protected int nbAlive;

    public Grid gridSource;

    public GridTableau(int row, int column, Grid gridSource) {
        this.row = row;
        this.column = column;
        this.grid = new Cellule[row][column];
        this.nbAlive = 0;
        this.gridSource = gridSource;
    }

    public GridTableau(int row, int column) {
        this(row, column, null);
    }

    /*
    La fonction getXY() permet de recuperer une cellule dans une certaine coordonnee
    @param x est un entier
    @param y est un entier
    @require 0 <= x && x < getRow()
    @require 0 <= y && y < getColumn()
    @result une cellule
    */
    public Cellule getXY(int x, int y) {
        if (x < this.row && y < this.column) {
            return this.grid[x][y];
        }
        if (this.gridSource != null) {
            return this.gridSource.getXY(x, y);
        }
        return null;
    }

    /*
    La fonction getRow() permet de recuperer le nombre de lignes
    @result le nombre de lignes
    */
    public int getRow() {
        return row;
    }

    /*
    La fonction getColumn() permet de recuperer le nombre de colonnes
    @result le nombre de colonnes
    */
    public int getColumn() {
        return column;
    }

    /*
    La fonction print() permet d'afficher la grille en console
    @result void
    */
    public void print() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) { 
                
                if (this.getXY(i, j).getCondition() == 1) {
                    System.out.print("o ");
                }
                else {
                    System.out.print("- ");
                }
                
                //System.out.print("(" + this.getXY(j, i).getX() +"," + this.getXY(j, i).getY() +")");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
    La fonction toFill() permet d'inserer des cellules en fonction d'un taux(degreeAlive)
    @param degreeAlive est un flotant
    @require 0 <= degreeAlive && degreeAlive <= 1
    @result void
    */
    public void toFill(double degreeAlive, int x, int y) {
        this.nbAlive = 0;
        
        ThreadGroup filler = new ThreadGroup("toFill");

        Thread t1 = new Thread(filler, 
            new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < row/2; i++) {
                        for (int j = 0; j < column/2; j++) {
                            //System.out.println(Integer.toString(i) + ";" + Integer.toString(j));
                            if (Math.random() < degreeAlive) {
                                grid[i][j] = new BooleanCellule(x + i, y + j, 1);
                                nbAlive++;
                            }
                            else {
                                grid[i][j] = new BooleanCellule(x + i, y + j, 0);
                            }
                        }
                    }
                }
            }
        );

        Thread t2 = new Thread(filler, 
            new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < row/2; i++) {
                        for (int j = column/2; j < column; j++) {
                            if (Math.random() < degreeAlive) {
                                grid[i][j] = new BooleanCellule(x + i, y + j, 1);
                                nbAlive++;
                            }
                            else {
                                grid[i][j] = new BooleanCellule(x + i, y + j, 0);
                            }
                        }
                    }
                }
            }
        );

        Thread t3 = new Thread(filler,
            new Runnable() {
                @Override
                public void run() {
                    for (int i = row/2; i < row; i++) {
                        for (int j = 0; j < column/2; j++) {
                            //System.out.println(Integer.toString(i) + ";" + Integer.toString(j));
                            if (Math.random() < degreeAlive) {
                                grid[i][j] = new BooleanCellule(x + i, y + j, 1);
                                nbAlive++;
                            }
                            else {
                                grid[i][j] = new BooleanCellule(x + i, y + j, 0);
                            }
                        }
                    }
                }
            }
        );

        Thread t4 = new Thread(filler,
            new Runnable() {
                @Override
                public void run() {
                    for (int i = row/2; i < row; i++) {
                        for (int j = column/2; j < column; j++) {
                            if (Math.random() < degreeAlive) {
                                grid[i][j] = new BooleanCellule(x + i, y + j, 1);
                                nbAlive++;
                            }
                            else {
                                grid[i][j] = new BooleanCellule(x + i, y + j, 0);
                            }
                        }
                    }
                }
            }
        );

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("PROBLEME");
        }

    }

    /*
    La fonction applyLaw() permet d'appliquer une loi.
    @param loi est une classe qui permet d'appliquer une condition
    @require Law != null
    @result void
    */
    public void toFill(double degreeAlive) {
        this.toFill(degreeAlive,0,0);
    }

    /*
    La fonction applyLaw() permet d'appliquer une loi.
    @param loi est une classe qui permet d'appliquer une condition
    @require Law != null
    @result void
    */
    public void applyLaw(Law loi) {
        //System.out.println("start");
        this.nbAlive = 0;

        Grid self = this;
        ThreadGroup apply = new ThreadGroup("applyLaw");

        Thread t1 = new Thread(apply,
            new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < row/2; i++) {
                        for (int j = 0; j < column/2; j++) {
                            //System.out.println(Integer.toString(i) + ";" + Integer.toString(j));
                            Cellule cellule = getXY(i, j);
                            cellule.newCondition(loi, self);
                            if (cellule.getCondition() == 1) {
                                nbAlive++;
                            }
                        }
                    }
                }
            }
        );

        Thread t2 = new Thread(apply,
            new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < row/2; i++) {
                        for (int j = column/2; j < column; j++) {
                            Cellule cellule = getXY(i, j);
                            cellule.newCondition(loi, self);
                            if (cellule.getCondition() == 1) {
                                nbAlive++;
                            }
                        }
                    }
                }
            }
        );

        Thread t3 = new Thread(apply,
            new Runnable() {
                @Override
                public void run() {
                    for (int i = row/2; i < row; i++) {
                        for (int j = 0; j < column/2; j++) {
                            //System.out.println(Integer.toString(i) + ";" + Integer.toString(j));
                            Cellule cellule = getXY(i, j);
                            cellule.newCondition(loi, self);
                            if (cellule.getCondition() == 1) {
                                nbAlive++;
                            }
                        }
                    }
                }
            }
        );

        Thread t4 = new Thread(apply,
            new Runnable() {
                @Override
                public void run() {
                    for (int i = row/2; i < row; i++) {
                        for (int j = column/2; j < column; j++) {
                            Cellule cellule = getXY(i, j);
                            cellule.newCondition(loi, self);
                            if (cellule.getCondition() == 1) {
                                nbAlive++;
                            }
                        }
                    }
                }
            }
        );

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("PROBLEME");
        }
    }

    /*
    La fonction repeatLaw() permet de repeter l'application d'une loi sur un nombre fois nCap et on peut choisir d'afficher la grille.
    @param loi est une classe qui permet d'appliquer une condition
    @param nCap est un entier
    @param printable est une booleen
    @require nCap >= 0
    @result void
    */
    public void repeatLaw(Law loi, int nCap, boolean printable) {
        if (printable) {
            this.print();
        }
        for (int i = 0; i < nCap; i++) {
            System.out.println("Grille n°" + (i+1) + "\nEn vie :" + this.nbAlive);
            this.applyLaw(loi);
            if (printable) {
                this.print();
            }
        }
    }

    /*
    La fonction repeatLaw() permet de repeter l'application d'une loi sur un nombre fois nCap et on peut choisir d'afficher la grille.
    @param loi est une classe qui permet d'appliquer une condition
    @param nCap est un entier
    @require nCap >= 0
    @result void
    */
    public void repeatLaw(Law loi,int nCap) {
        this.repeatLaw(loi, nCap,false);
    }

    /*
    La fonction getNbAlive() permet de recuperer le nombre de cellules dites vivantes
    @result un nombre de cellules 'vivantes' 
    */
    public int getNbAlive() {
        return this.nbAlive;
    }
    
    

}