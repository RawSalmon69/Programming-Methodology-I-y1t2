package monkey;

import static logic.game.GameSystem.getInstance;

public class MommyMonkey extends BaseMonkey {
    public MommyMonkey(int hp, int atk, int def) {
        super(hp, atk, def);
    }

    public void attack(BaseMonkey m) {
        return;
    }

    public String getType() {
        return "MommyMonkey";
    }

    public void birth() {
        BaseMonkey child = new BaseMonkey();
        getInstance().getMonkeyContainer().add(child);
    }
}
