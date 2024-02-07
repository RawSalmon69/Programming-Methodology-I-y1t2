package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import utils.Config;

public class Monk extends Actor {
    // constructor
    public Monk() {

    }

    // method
    public int getLevel() {
        return Config.MonkLevel;
    }

    public void attack() {
        GameController controller = GameController.getInstance();
        Ghost target = controller.getGhosts().get(0);
        if (target instanceof HighGhost) {
            target.setHp(target.getHp() - this.getLevel());
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
