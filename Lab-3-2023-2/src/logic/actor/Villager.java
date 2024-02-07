package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.LowGhost;
import logic.item.Amulet;
import logic.item.Item;
import utils.Config;

import java.util.ArrayList;

public class Villager extends Actor {
    // constructor
    public Villager() {

    }

    public int getLevel() {
        return Config.VillagerLevel;
    }

    public void attack() {
        GameController controller = GameController.getInstance();
        Ghost target = controller.getGhosts().get(0);
        if (target instanceof LowGhost) {
            boolean hasAmulet = false;
            for (Item i : controller.getItems()) {
                if (i instanceof Amulet) {
                    hasAmulet = true;
                    break;
                }
            }
            if (hasAmulet) {
                target.setHp(target.getHp() - (this.getLevel() + 1));
            } else {
                target.setHp(target.getHp() - this.getLevel());
            }
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
