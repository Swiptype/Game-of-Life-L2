package interface_graphique;

import interface_graphique.grille.GridFrame;
import interface_graphique.le_menu.MenuFrame;
import interface_graphique.le_menu.ReadMeFrame;
import interface_graphique.option.*;

public class Orchestrator {

    protected MenuFrame menu;
    protected Config config;
    protected GridFrame grid;
    protected OptionFrame option;
    protected ReadMeFrame readMe;

    public Orchestrator() {
        this.menu = new MenuFrame(this);
        this.menu.setVisible(true);
        this.config = new Config();
        this.grid = null;
        this.option = null;
        this.readMe = null;
    }

    public void openOptionFrame() {
        if (this.option == null) {
            this.option = new OptionFrame(this);
        }
        this.option.setVisible(true);
        this.menu.dispose();
    }
    
    public void setConfig(Config newConfig) {
        this.config = newConfig;
    }

    public void openGridFrame() {
        this.option.dispose();
        this.grid = new GridFrame(this.config);
    }

    public static void main(String[] args) {
        new Orchestrator();
    }

    
    
}
