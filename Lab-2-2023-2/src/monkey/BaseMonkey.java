package monkey;

public class BaseMonkey {
    private int maxHP;
    private int hp;
    private int atk;
    private int def;

    public int getMaxHp() {
        return maxHP;
    }
    public void setMaxHP(int maxHP) {
        if(maxHP < 0) maxHP=0;
        this.maxHP = maxHP;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        if(hp < 0) hp=0;
        if(hp > this.getMaxHp()) hp = this.getMaxHp();
        this.hp = hp;
    }
    public int getAtk() {
        return atk;
    }
    public void setAtk(int atk) {
        if(atk < 0) atk=0;
        this.atk = atk;
    }
    public int getDef(){
        return def;
    }
    public void setDef(int def) {
        if(def < 0) def=0;
        this.def = def;
    }
    public String getType() {
        return "BaseMonkey";
    }

    public BaseMonkey() {
        this.setMaxHP(30);
        this.setHp(this.getMaxHp());
        this.setAtk(20);
        this.setDef(5);
    }
    public BaseMonkey(int maxHP, int atk, int def) {
        this.setMaxHP(maxHP);
        this.setHp(maxHP);
        this.setAtk(atk);
        this.setDef(def);
    }
    public void attack(BaseMonkey m){
        m.setHp( m.getHp() - this.getAtk() + m.getDef());
    }
    public String toString(){
        return "<" + this.getType() + "> hp=<" + this.getHp() + "> atk=<" + this.getAtk() + "> def=<" + this.getDef() + ">";
    }
}
