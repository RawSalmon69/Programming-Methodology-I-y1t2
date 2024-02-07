package item.consumption;

import item.base.BaseConsumption;
import item.usage.AttBuffable;
import item.usage.Upgradable;

public class StrengthPotion extends BaseConsumption implements AttBuffable, Upgradable {
    private int level;
    private final int MAX_LEVEL;
    private final int[] ATT_BUFF;
    private final int BUFF_TURN;

    public StrengthPotion() {
        super("StrengthPotion");
        this.MAX_LEVEL = 3;
        this.ATT_BUFF = new int[]{3,5,7,10};
        this.BUFF_TURN = 3;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if(level > MAX_LEVEL || level < 0) level = 0;
        this.level = level;
    }
    public int getMaxLevel() {
        return MAX_LEVEL;
    }

    public int getBuffTurn() {
        return BUFF_TURN;
    }
    public int getAttBuff(){
        return ATT_BUFF[this.level];
    }
    public String toString(){
        return getName() + " (+" + getAttBuff() + " Att for next " + getBuffTurn() + " turns, Level: " + getLevel() + ")";
    }
}
