package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.LowGhost;
import utils.Config;

public class GhostDoctor extends Actor {
    // constructor
    public GhostDoctor() {

    }

    // method
    public int getLevel() {
        return Config.GhostDoctorLevel;
    }

    public void attack() {
        GameController controller = GameController.getInstance();
        Ghost target = controller.getGhosts().get(0);
        if (target instanceof LowGhost) {
            target.setHp(0);
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
