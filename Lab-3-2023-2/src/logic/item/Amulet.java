package logic.item;

import logic.game.GameController;
import utils.Config;

public class Amulet extends Item{
	// constructor
    public Amulet() {

    }

    // method
    public int getLevel() {
        return Config.AmuletLevel;
    }

    public void effect() {
        GameController controller = GameController.getInstance();
        if (controller.getHp() <= 5) {
            controller.setHp(5);
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }

}
