package hash_life.structure;

public interface HashLife {
    
    /*
     * La fonction getNextGeneration permet d'obtenir la generation suivante
     * @result : nextGrid est le nouveau tableau à la génération suivante
     */
    public int[][] getNextGeneration();

    /*
    * La fonction countNeighbors compte el nombre de cellules vivantes autour de chaque cellule
    * @param : row est un entier representant les lignes
    * @param : col est un entier representant les colonnes
    * @result : renvoie l'entier count, le nombre de voisins de la cellule vivants
    */
    public int countNeighbors( int row, int col);

    public Node buildUniverse();

    public Node buildUniverse(Node[][] nodes);

    /*
     * La fonction printGrid permet un affichage en console des grilles du jeu
     * @result : les grilles du jeu
     */
    public void printGrid();

    /*
     * Renvoie la ligne de currentGrid
     * @result : une ligne de currentGrid
     */
    public int getRow();

    /*
     * Renvoie la colonne de currentGrid
     * @result : une colonne de currentGrid
     */
    public int getColumn();

    /*
     * Renvoie les coordonnées de currentGrid
     * @param : x, un entier
     * @param : y, un entier
     * @result : une coordonnée de currentGrid
     */
    public int getXY(int x, int y);

    /*
     * La fonction fillgrid permet de remplir la grille avec un certain pourcentage de cellule vivante
     * @param : TAUX est un double qui represente le pourcentage de cellule vivantes entre 0 et 1
     * @require : TAUX entre 0 et 1
     */
    public void fillGrid(double TAUX);
}
