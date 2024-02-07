package item.armor;

import item.base.BaseArmor;

public class Suit extends BaseArmor {
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if(level > MAX_LEVEL || level < 0) level = 0;
        this.level = level;
    }

    private final int MAX_LEVEL;
    private final int[] DEF;

    public Suit() {
        super("Suit", 10);
        setLevel(0);
        this.MAX_LEVEL = 3;
        this.DEF = new int[]{1,2,3,5};
    }

    public int getMaxLevel() {
        return MAX_LEVEL;
    }

    public int getDef() {
        return DEF[level];
    }

    public String toString() {
        return getName() + " (Def: " + getDef() + ", Level: " + getLevel() +")";
    }
}
