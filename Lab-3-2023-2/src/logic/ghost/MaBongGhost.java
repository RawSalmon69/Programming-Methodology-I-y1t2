package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class MaBongGhost extends LowGhost{
	// field
    private int power;
    private int speed;

    // constructor
    public MaBongGhost() {
        super();
        setPower(Config.MaBongGhostPower);
        setSpeed(Config.MaBongGhostSpeed);
    }

    public MaBongGhost(int power) {
        super();
        setPower(power);
        setSpeed(Config.MaBongGhostSpeed);
    }

    public MaBongGhost(int power, int speed) {
        super();
        setPower(power);
        setSpeed(speed);
    }

    // method

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String toString() {
        return "MabongGhost [HP: " + getHp() + " , Power: " + getPower() + " , Speed: " + getSpeed() + "]";
    }

    public void attack() {
        GameController controller = GameController.getInstance();
        controller.setHp(controller.getHp() - (this.getPower() * this.getSpeed()));
    }
}
