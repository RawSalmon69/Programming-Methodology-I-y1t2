package logic.game;

import java.util.ArrayList;

import logic.actor.Actor;
import logic.actor.Villager;
import logic.ghost.Ghost;
import logic.item.Item;
import utils.GameUtils;

public class GameController {

	private int hp;
	private int score;
	private static GameController instance;
	private ArrayList <Actor> actors;
	private ArrayList <Ghost> ghosts;
	private ArrayList <Item> items;


	public GameController() {

		this.actors = new ArrayList <Actor> ();
		this.ghosts = new ArrayList <Ghost> ();
		this.items = new ArrayList <Item> ();

		initGame();

	}

	public static GameController getInstance() {
		if(instance == null)
			instance = new GameController();
		return instance;
	}

	public void play(Actor selectedActor) {
		//TODO: Write your code here.
		for (Item i : items) {
			i.effect();
		}

		selectedActor.attack();

		ArrayList<Ghost> newGhosts = new ArrayList<>();
		ArrayList<Ghost> destroyedGhosts = new ArrayList<>();
		for (Ghost g : ghosts) {
			if (!g.isDestroyed()) {
				newGhosts.add(g);
			} else {
				destroyedGhosts.add(g);
			}
		}
		this.ghosts = newGhosts;
		for (Ghost g : destroyedGhosts) {
			setScore(getScore() + g.getLevel());
		}

		for (int i = 0; i < destroyedGhosts.size(); ++i) {
			ghosts.add(GameUtils.getRandomGhost(true));
		}

		//=============================
	}
	public void updateGameController() {
		GameIO.showGameState();
		GameIO.showCurrentGhost(ghosts);
		Actor selectedActor = GameIO.selectActor(this.actors);
		GameIO.showItemList(this.items);
		play(selectedActor);
	}

	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getScore() {
		return score;
	}
	public ArrayList<Ghost> getGhosts() {
		return ghosts;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void addNewActor(Actor actor) {
		this.actors.add(actor);
	}
	public void addNewItem(Item item) {
		this.items.add(item);
	}
	public void addNewGhost(Ghost ghost) {
		this.ghosts.add(ghost);
	}

	//TODO implements here
	public ArrayList<Actor> getActors() {
		return actors;
	}
	private void initGame() {
		setScore(0);
		setHp(10);
		actors.add(new Villager());
		for (int i = 0; i < 10; ++i) {
			ghosts.add(GameUtils.getRandomGhost(false));
		}
	}

	public boolean isGameOver() {
		return actors.isEmpty() || getHp() <= 0;
	}
	//===========================

}