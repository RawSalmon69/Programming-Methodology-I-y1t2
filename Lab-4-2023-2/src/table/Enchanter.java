package table;

import item.base.BaseItem;
import item.usage.Upgradable;

public class Enchanter extends BaseTable {

    public Enchanter() {
        super("Enchanter");
    }

    @Override
    public String interact(BaseItem item) {
        // FILL CODE
        if (item instanceof Upgradable) {
            Upgradable upgradable = (Upgradable) item;
            if (upgradable.getLevel() < upgradable.getMaxLevel()) {
                upgradable.setLevel(upgradable.getLevel() + 1);
                return "Upgrade successfully";
            }
            if(upgradable.getLevel() == upgradable.getMaxLevel()){
                return "Already max level";
            }
        }
        return "This item cannot be upgraded";
    }
}
