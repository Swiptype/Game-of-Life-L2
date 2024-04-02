package data_structure;

public class QuadGridTab implements Grid{
    
    protected int row, column;
    protected Grid northWest, northEast, southWest, southEast;

    protected int dimension;

    protected Grid gridSource;

    public QuadGridTab(int row, int column, int dimension, Grid gridSource) {
        this.row = row;
        this.column = column;

        this.gridSource = (gridSource==null?this:gridSource);
        
        if (dimension <= 1) {
            this.northWest = new GridTableau(row/2, column/2, gridSource);
            this.northEast = new GridTableau(row/2, column/2, gridSource);
            this.southWest = new GridTableau(row/2, column/2, gridSource);
            this.southEast = new GridTableau(row/2, column/2, gridSource);

            /*this.northWest = new GridTabPara(row/2, column/2);
            this.northEast = new GridTabPara(row/2, column/2);
            this.southWest = new GridTabPara(row/2, column/2);
            this.southEast = new GridTabPara(row/2, column/2);*/
        }
        if (1 < dimension) {
            this.northWest = new QuadGridTab(row/2, column/2, dimension-1, gridSource);
            this.northEast = new QuadGridTab(row/2, column/2, dimension-1, gridSource);
            this.southWest = new QuadGridTab(row/2, column/2, dimension-1, gridSource);
            this.southEast = new QuadGridTab(row/2, column/2, dimension-1, gridSource);
        }
        
    }

    public QuadGridTab(int row, int column, int dimension) {
        this(row, column, dimension, null);
    }

    /*
    La fonction getXY() permet de recuperer une cellule dans une certaine coordonnee
    @param x est un entier
    @param y est un entier
    @require 0 <= x && x < getRow()
    @require 0 <= y && y < getColumn()
    @result une cellule
    */
    public Cellule getXY(int i, int j) {
        if (i < this.getRow() && j < this.getColumn()) {
            if (i < this.row/2) {
                if (j < this.column/2) {
                    return this.northWest.getXY(i, j);
                }
                if (this.column/2 <= j && j < this.column) {
                    return this.northEast.getXY(i, j - this.column/2);
                }
            }
            if (this.row/2 <= i && i < this.row) {
                if (j < this.column/2) {
                    return this.southWest.getXY(i - this.row/2, j);
                }
                if (this.column/2 <= j && j < this.column) {
                    return this.southEast.getXY(i - this.row/2, j - this.column/2);
                }
            }
        }
        if (i < this.gridSource.getRow() && j < this.gridSource.getColumn()) {
            return this.gridSource.getXY(i, j);
        }

        return null;
    }

    /*
    La fonction getRow() permet de recuperer le nombre de lignes
    @result le nombre de lignes
    */
    public int getRow() {
        return this.row;
    }

    /*
    La fonction getColumn() permet de recuperer le nombre de colonnes
    @result le nombre de colonnes
    */
    public int getColumn() {
        return this.column;
    }

    /*
    La fonction print() permet d'afficher la grille en console
    @result void
    */
    public void print() {
        for (int x = 0; x < this.row; x++) {
            for (int y = 0; y < this.column; y++) {
                if (this.getXY(x, y).getCondition() == 1) {
                    System.out.print("o ");
                }
                else {
                    System.out.print("- ");
                }
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
    public void toFill(double degreeAlive) {
        this.northWest.toFill(degreeAlive);
        this.northEast.toFill(degreeAlive);
        this.southWest.toFill(degreeAlive);
        this.southEast.toFill(degreeAlive);
    }

    /*
    La fonction applyLaw() permet d'appliquer une loi.
    @param loi est une classe qui permet d'appliquer une condition
    @require Law != null
    @result void
    */
    public void applyLaw(Law loi) {

        ThreadGroup apply = new ThreadGroup("applyLaw - QuadGridTab");
        
        Thread t1 = new Thread(apply,
            new Runnable() {
                @Override
                public void run() {
                    northWest.applyLaw(loi);
                }
            }
        );

        Thread t2 = new Thread(apply,
            new Runnable() {
                @Override
                public void run() {
                    northEast.applyLaw(loi);
                }
            }
        );

        Thread t3 = new Thread(apply,
            new Runnable() {
                @Override
                public void run() {
                    southWest.applyLaw(loi);
                }
            }
        );

        Thread t4 = new Thread(apply,
            new Runnable() {
                @Override
                public void run() {
                    southEast.applyLaw(loi);
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
            System.out.println("Grille n°" + (i+1) + "\nEn vie :" + this.getNbAlive());
            this.applyLaw(loi);
            if (printable) {
                this.print();
            }
        }
    }

    public void repeatLaw(Law loi, int nCap) {
        this.repeatLaw(loi, nCap, false);
    }

    /*
    La fonction getNbAlive() permet de recuperer le nombre de cellules dites vivantes
    @result un nombre de cellules 'vivantes' 
    */
    public int getNbAlive() {
        return  this.northWest.getNbAlive() +
                this.northEast.getNbAlive() +
                this.southWest.getNbAlive() +
                this.southEast.getNbAlive();
    }

}
