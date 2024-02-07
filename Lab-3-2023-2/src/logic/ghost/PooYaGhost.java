package logic.ghost;

import logic.game.GameController;
import utils.Config;

import java.util.ArrayList;

public class PooYaGhost extends HighGhost {
    // field
    private int power;

    // constructor
    public PooYaGhost(int power) {
        super();
        setPower(power);
    }

    // method
    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getLevel() {
        return Config.PooYaGhostLevel;
    }

    public String toString() {
        return "PooYaGhost [HP: " + getHp() + " , Power: " + getPower() + "]";
    }

    public void attack() {
        GameController controller = GameController.getInstance();
        controller.setHp(controller.getHp() - this.getPower());
        controller.setScore(controller.getScore() - this.getPower());
    }

    public void damage() {
        GameController controller = GameController.getInstance();
        ArrayList<Ghost> ghostList = controller.getGhosts();
        System.out.println(ghostList);
        for (Ghost g : ghostList) {
            g.setHp((g.getHp() + this.getPower()));
        }
    }
}
