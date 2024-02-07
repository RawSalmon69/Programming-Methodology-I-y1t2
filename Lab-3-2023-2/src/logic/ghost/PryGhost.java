package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class PryGhost extends LowGhost{
	// field
	private int power;
	private int ppt;

	// constructor
	public PryGhost() {
		super();
		setPower(Config.PryGhostPower);
		setPpt(0);
	}

	public PryGhost(int power) {
		super();
		setPower(power);
		setPpt(0);
	}

	public PryGhost(int power, int ppt) {
		super();
		setPower(power);
		setPpt(ppt);
	}

	// method
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getPpt() {
		return ppt;
	}

	public void setPpt(int ppt) {
		this.ppt = ppt;
	}

	public String toString() {
		return "PryGhost [HP: " + getHp() + " , Power: " + getPower() + " , PPT: " + getPpt() + "]";
	}

	public void attack() {
		GameController controller = GameController.getInstance();
		controller.setHp(controller.getHp() - (this.getPower() - this.getPpt()));
	}
}
