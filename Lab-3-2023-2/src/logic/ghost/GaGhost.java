package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class GaGhost extends LowGhost{
	// field
    private int energy;

    // constructor
    public GaGhost() {
        super();
        setEnergy(Config.GaGhostEnergy);
    }

    public GaGhost(int energy) {
        super();
        setEnergy(energy);
    }

    // method
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String toString() {
        return "GaGhost [HP: " + getHp() + " , Energy: " + getEnergy() + "]";
    }

    public void attack() {
        GameController controller = GameController.getInstance();
        controller.setHp(controller.getHp() - this.getEnergy());
    }
}
