package hash_life.structure;

public class HashLifeGameOfLife implements HashLife{

    int tailleGrid;
    int[][] initialGrid = new int[tailleGrid][tailleGrid];
    
    private int[][] currentGrid;
    private Node universe;
    
    /*
     * Constructeur de la classe HashLifeGameOfLife
     * @param : initialGrid est un tableau à 2 dimmensions d'entiers
     */
    public HashLifeGameOfLife(int[][] initialGrid) {
        this.currentGrid = initialGrid;
        this.universe = buildUniverse();
    }
    
    /*
     * La fonction run permet d'executer le lancement du jeu
     * @param : numGenerations est un entier correspondant au nombre de fois ou on execute le jeu
     * @param : printable est un booléen. Si faux, rien ne s'affiche
     * @require : numGenerations >= 1
     */
    public void run(int numGenerations,boolean printable) {
        for (int i = 0; i < numGenerations; i++) {
            currentGrid = getNextGeneration();
            universe = buildUniverse();
            if(printable){
                printGrid();
                //printUniverse();
            }
        }
    }

    public void run(int numGenerations) {
        this.run(numGenerations, true);
    }
    
    /*
     * La fonction getNextGeneration permet d'obtenir la generation suivante
     * @result : nextGrid est le nouveau tableau à la génération suivante
     */
    public int[][] getNextGeneration() {
        int[][] nextGrid = new int[currentGrid.length][currentGrid[0].length];
        for (int i = 0; i < currentGrid.length; i++) {
            for (int j = 0; j < currentGrid[0].length; j++) {
                int numNeighbors = countNeighbors(i, j);
                if (currentGrid[i][j] == 1) {
                    if (numNeighbors < 2 || numNeighbors > 3) {
                        nextGrid[i][j] = 0;
                    } else {
                        nextGrid[i][j] = 1;
                    }
                } else {
                    if (numNeighbors == 3) {
                        nextGrid[i][j] = 1;
                    } else {
                        nextGrid[i][j] = 0;
                    }
                }
            }
        }
        return nextGrid;
    }
    
    /*
     * La fonction countNeighbors compte el nombre de cellules vivantes autour de chaque cellule
     * @param : row est un entier representant les lignes
     * @param : col est un entier representant les colonnes
     * @result : renvoie l'entier count, le nombre de voisins de la cellule vivants
     */
    public int countNeighbors(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == row && j == col) {
                    continue;
                }
                int r = (i + currentGrid.length) % currentGrid.length;
                int c = (j + currentGrid[0].length) % currentGrid[0].length;
                if (currentGrid[r][c] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    
    /*
     * La fonction buildUniverse
     */
    public Node buildUniverse() {
        Node[][] nodes = new Node[currentGrid.length][currentGrid[0].length];
        for (int i = 0; i < currentGrid.length; i++) {
            for (int j = 0; j < currentGrid[0].length; j++) {
                nodes[i][j] = new Node(currentGrid[i][j]);
            }
        }
        return buildUniverse(nodes);
    }
    
    public Node buildUniverse(Node[][] nodes) {
        if (nodes.length == 1 && nodes[0].length == 1) {
            return nodes[0][0];
        }
        Node[][] nw = new Node[nodes.length / 2][nodes[0].length / 2];
        Node[][] ne = new Node[nodes.length / 2][nodes[0].length / 2];
        Node[][] sw = new Node[nodes.length / 2][nodes[0].length / 2];
        Node[][] se = new Node[nodes.length / 2][nodes[0].length / 2];
        for (int i = 0; i < nodes.length / 2; i++) {
            for (int j = 0; j < nodes[0].length / 2; j++) {
                nw[i][j] = nodes[2 * i][2 * j];
                ne[i][j] = nodes[2 * i][2 * j + 1];
                sw[i][j] = nodes[2 * i + 1][2 * j];
                se[i][j] = nodes[2 * i + 1][2 * j + 1];
            }
        }
        Node[][] north = new Node[nw.length + ne.length][nw[0].length + ne[0].length];
        Node[][] south = new Node[sw.length + se.length][sw[0].length + se[0].length];
        Node[][] west = new Node[nw.length + sw.length][nw[0].length + sw[0].length];
        Node[][] east = new Node[ne.length + se.length][ne[0].length + se[0].length];
        return new Node(north, south, west, east);
    }
    
    /*
     * La fonction printGrid permet un affichage en console des grilles du jeu
     * @result : les grilles du jeu
     */
    public void printGrid() {
        for (int[] row : currentGrid) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "X " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /* C'est la même chose que printGrid
    public void printUniverse(){
        for (int i = 0; i < this.getRow();i++){
            for (int j = 0; j < this.getColumn();j++){
                if (this.getXY(i, j) == 1){
                    System.out.print("X ");
                }
                else{
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    */

    /*
     * La fonction fillgrid permet de remplir la grille avec un certain pourcentage de cellule vivante
     * @param : TAUX est un double qui represente le pourcentage de cellule vivantes entre 0 et 1
     * @require : TAUX entre 0 et 1
     */
    public void fillGrid(double TAUX){
        for (int i = 0; i < currentGrid.length; i++) {
            for (int j = 0; j < currentGrid[0].length; j++) {
                if (Math.random() < TAUX){
                    currentGrid[i][j] = 1;
                }
                else{
                    currentGrid[i][j] = 0;
                }
            }
        }
    }

    /*
     * Renvoie la ligne de currentGrid
     * @result : une ligne de currentGrid
     */
    public int getRow() {
        return currentGrid.length;
    }

    /*
     * Renvoie la colonne de currentGrid
     * @result : une colonne de currentGrid
     */
    public int getColumn() {
        return currentGrid[0].length;
    }

    /*
     * Renvoie les coordonnées de currentGrid
     * @param : x, un entier
     * @param : y, un entier
     * @result : une coordonnée de currentGrid
     */
    public int getXY(int i, int j) {
        return currentGrid[i][j];
    }

}
