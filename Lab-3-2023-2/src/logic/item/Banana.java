package logic.item;

import logic.game.GameController;
import logic.ghost.Ghost;
import utils.Config;

public class Banana extends Item{
	// constructor
	public Banana() {

	}

	// method
	public int getLevel() {
		return Config.BananaLevel;
	}

	public void effect() {
		for(Ghost ghost : GameController.getInstance().getGhosts()) {
			System.out.print(ghost + " ");
		}
		System.out.print("\n");
	}
	
	public String toString() {
		return getClass().getSimpleName();
	}
}
