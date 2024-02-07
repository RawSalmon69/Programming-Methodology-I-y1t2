package logic.item;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import utils.Config;

public class Leklai extends Item{
	// constructor
    public Leklai() {

    }

    // method
    public int getLevel() {
        return Config.LeklaiLevel;
    }

    public void effect() {
        GameController controller = GameController.getInstance();
        for (Ghost g : controller.getGhosts()) {
            if (this.getLevel() >= g.getLevel()) {
                if (g instanceof LowGhost) {
                    g.setHp(g.getHp() - 5);
                } else if (g instanceof HighGhost) {
                    g.setHp(g.getHp() - 4);
                }
            }
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }

}
