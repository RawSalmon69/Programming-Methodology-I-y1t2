package monkey;

public class UgabugagaMonkey extends BaseMonkey{
    private final int DEBUFF = 1;
    private final int HEAL = 10;

    public UgabugagaMonkey(int maxHp, int atk, int def) {
        super(maxHp, atk, def);
    }
    public void attack(BaseMonkey m){
        super.attack(m);
        m.setAtk(m.getAtk() - DEBUFF);
        m.setDef(m.getDef() - DEBUFF);
    }
    public void heal(BaseMonkey m){
        m.setHp(m.getHp() + HEAL);
    }
    public String getType(){
    return "UgabugagaMonkey";
    }
}
