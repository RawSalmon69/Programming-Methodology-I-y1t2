package table;

import item.base.BaseItem;
import item.usage.CookState;
import item.usage.Cookable;

public class Oven extends BaseTable{

    public Oven() {
        super("Oven");
    }

    @Override
    public String interact(BaseItem item) {
        // FILL CODE
        if(item instanceof Cookable) {
            Cookable cookable = (Cookable) item;
            if(cookable.getCookState() == CookState.RAW){
                cookable.setCookState(CookState.COOKED);
                return "Cooking succeed";
            }
            if(cookable.getCookState() == CookState.COOKED){
                cookable.setCookState(CookState.BURNT);
                return "Your food has been burnt";
            }
            if(cookable.getCookState() == CookState.BURNT){
                return "Your food is already burnt, cannot be cooked anymore";
            }
        }
        return "This item cannot be cooked";
    }
}
