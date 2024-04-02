package hash_life.structure;

public class Node {
    private Node nw;
    private Node ne;
    private Node sw;
    private Node se;
    private int level;
    private int state;
    
    /*
     * Constructeur de la classe Node
     * @param : state est un entier
     */
    public Node(int state) {
        this.state = state;
        this.level = 0;
    }

    /*
     * @result : renvoie le level
     */
    public int getLevel() {
        return this.level;
    }

    /*
     * Deuxieme constructeur de la classe Node
     * @param : tableaux à 2 dimensions pour la division en 4
     */
    public Node(Node[][] north, Node[][] south,
            Node[][] west, Node[][] east) {
    }

    /*
     * La fonction computeState de renvoyer l'etat d'un tableau à 2 dimensions
     * @return state si le level = 0
     * @return nwState si tous les états des tableaux sont égaux
     * @return -1 si tous les états sont différents
     */
    private int computeState() {
        if (level == 0) {
            return state;
        }
        int nwState = nw.state;
        int neState = ne.state;
        int swState = sw.state;
        int seState = se.state;
        if (nwState == neState && nwState == swState && nwState == seState) {
            return nwState;
        } else {
            return -1;
        }
    }

    /*
     * @result : renvoie l'etat
     */
    public int getState(){
        return this.state;
    }
}