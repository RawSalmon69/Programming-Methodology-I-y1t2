package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.LowGhost;
import logic.item.Banana;
import logic.item.Item;
import utils.Config;

public class Monkey extends Actor {
    // constructor
    public Monkey() {

    }

    // method
    public int getLevel() {
        return Config.MonkeyLevel;
    }

    public void attack() {
        GameController controller = GameController.getInstance();
        Ghost target = controller.getGhosts().get(0);
        if (target instanceof LowGhost) {
            boolean hasBanana = false;
            for (Item i : controller.getItems()) {
                if (i instanceof Banana) {
                    hasBanana = true;
                    break;
                }
            }
            if (hasBanana) {
                target.setHp(0);
            } else {
                target.setHp(target.getHp() - getLevel());
            }
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
