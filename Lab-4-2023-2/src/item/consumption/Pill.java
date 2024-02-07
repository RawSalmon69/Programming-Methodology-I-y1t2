package item.consumption;

import item.base.BaseConsumption;
import item.usage.Healable;

public class Pill extends BaseConsumption implements Healable{
    private final int RECOVER_PT;
    public Pill() {
        super("Pill");
        this.RECOVER_PT = 2;
    }
    public String toString() {
        return getName() + " (+" + getRecoverPoint() + " HP)";
    }

    public int getRecoverPoint() {
        return this.RECOVER_PT;
    }
}
