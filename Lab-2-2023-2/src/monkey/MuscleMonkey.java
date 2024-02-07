package monkey;

public class MuscleMonkey extends BaseMonkey{
    public MuscleMonkey(int maxHp, int atk, int def) {
        super(maxHp, atk, def);
    }
    private final int POWER_UP = 4;
    public void attack(BaseMonkey m){
        super.attack(m);
        super.attack(m);
    }
    public void buff(){
        super.setAtk(super.getAtk() + POWER_UP);
        super.setDef(super.getDef() + POWER_UP);
    }
    public String getType(){
        return "MuscleMonkey";
    }
}
