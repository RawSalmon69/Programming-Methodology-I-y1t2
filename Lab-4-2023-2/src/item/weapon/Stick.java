package item.weapon;

import item.base.BaseWeapon;

public class Stick extends BaseWeapon {
    private final int ATT;

    public int getAtt() {
        return ATT;
    }
    public Stick(){
        super("Stick", 3, 0);
        this.ATT = 1;
    }
}
