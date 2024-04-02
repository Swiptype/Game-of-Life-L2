package hash_life.structure;

public class Main {
    public static void main(String[] args) {
        HashLifeGameOfLife game = new HashLifeGameOfLife(new int[12000][12000]); //max : 144 000 000 cellules
        game.fillGrid(0.2);
        game.run(1,false);
    }
}
