package item.armor;

import item.base.BaseArmor;

public class Boots extends BaseArmor {
    private final int DEF;

    public int getDef() {
        return DEF;
    }

    public Boots() {
        super("Boots", 5);
        this.DEF=1;
    }
}
