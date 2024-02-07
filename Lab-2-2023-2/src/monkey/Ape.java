package monkey;

import static logic.game.GameSystem.getInstance;

public class Ape extends BaseMonkey {
    public Ape(int MaxHp, int atk, int def) {
        super(MaxHp, atk, def);
    }

    public void attack(BaseMonkey m) {
        super.attack(m);
    }

    public void attackAOE() {
        for (BaseMonkey e : getInstance().getMonkeyContainer()) {
            super.attack(e);
        }
    }

    public String getType() {
        return "Ape";
    }
}
