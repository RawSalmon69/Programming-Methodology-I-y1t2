package item.consumption;

import item.base.BaseConsumption;
import item.usage.Healable;
import item.usage.Upgradable;

import java.util.Arrays;

public class HealingPotion extends BaseConsumption implements Healable, Upgradable {
    private int level;
    private final int MAX_LEVEL;
    private final int[] RECOVER_PT;

    public HealingPotion() {
        super("HealingPotion");
        this.MAX_LEVEL = 3;
        this.level = 0;
        this.RECOVER_PT = new int[]{3,5,7,10};
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if(level > MAX_LEVEL) level = 0;
        if(level < 0) level = 0;
        this.level = level;
    }

    public int getMaxLevel() {
        return MAX_LEVEL;
    }

    public int getRecoverPoint() {
        return this.RECOVER_PT[level];
    }

    @Override
    public String toString() {
        return getName() + " (+" + getRecoverPoint() + " HP, Level: " + getLevel() + ")";
    }
}
