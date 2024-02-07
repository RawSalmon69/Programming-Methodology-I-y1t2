package item.consumption;

import item.base.BaseConsumption;
import item.usage.CookState;
import item.usage.Cookable;
import item.usage.Healable;

import java.util.HashMap;

public class Pork extends BaseConsumption implements Cookable, Healable {
    private CookState cookState;
    private final HashMap<CookState, Integer> RECOVER_PT;

    public Pork() {
        super("Pork");
        setCookState(CookState.RAW);
        this.RECOVER_PT = new HashMap<>();
        initializeRecoveryPT();
    }

    private void initializeRecoveryPT() {
        this.RECOVER_PT.put(CookState.RAW, 1);
        this.RECOVER_PT.put(CookState.COOKED, 2);
        this.RECOVER_PT.put(CookState.BURNT, 0);
    }
    public CookState getCookState() {
        return this.cookState;
    }
    public void setCookState(CookState cookState) {
        this.cookState = cookState;
    }
    public int getRecoverPoint(){
        return this.RECOVER_PT.get(getCookState());
    }
    public String toString() {
        String cookState = getCookState().toString().substring(0, 1).toUpperCase() + getCookState().toString().substring(1).toLowerCase();
        return cookState + " " + getName() + " (+" + getRecoverPoint() + " HP)";
    }

}
