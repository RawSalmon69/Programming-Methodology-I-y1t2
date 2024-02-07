package logic.ghost;

import logic.game.GameController;
import utils.Config;

import java.util.ArrayList;

public class PongGhost extends HighGhost{
	// field
    private int power;

    // constructor
    public PongGhost() {
        super();
        setPower(Config.PongGhostPower);
    }

    public PongGhost(int power) {
        super();
        setPower(power);
    }

    // method
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getLevel() {
        return Config.PongGhostLevel;
    }

    public String toString() {
        return "PongGhost [HP: " + getHp() + " , Power: " + getPower() + "]";
    }

    public void attack() {
        GameController controller = GameController.getInstance();
        controller.setHp(controller.getHp() - this.getPower());
    }

    public void damage() {
        GameController controller = GameController.getInstance();
        ArrayList<Ghost> ghostList = controller.getGhosts();
        for (Ghost g : ghostList) {
            if (g instanceof LowGhost) {
                g.setHp(g.getHp() + this.getPower());
            }
        }
    }
}
