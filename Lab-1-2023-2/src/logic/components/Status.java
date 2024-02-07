package logic.components;

import exception.BadStatusException;

public class Status {
    private int hp;
    private int durability;
    private int attack;
    private int magic;

    public Status(int hp, int durability, int attack, int magic) throws BadStatusException {
        this.setHp(hp);
        this.setDurability(durability);
        this.setAttack(attack);
        this.setMagic(magic);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return hp == status.hp && durability == status.durability && attack == status.attack && magic == status.magic;
    }

    public void addStatus(Status another) throws BadStatusException {
        this.hp += another.getHp();
        this.durability += another.getDurability();
        this.attack += another.getAttack();
        this.magic += another.getMagic();
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDurability() {
        return durability;
    }

    public int getMagic() {
        return magic;
    }

    public void setHp(int hp) throws BadStatusException{
        if(hp < 0) throw new BadStatusException();
        this.hp = hp;
    }

    public void setDurability(int durability) throws BadStatusException {
        if(durability < 0) throw new BadStatusException();
        this.durability = durability;
    }

    public void setAttack(int attack) throws BadStatusException{
        if(attack < 0) throw new BadStatusException();
        this.attack = attack;
    }

    public void setMagic(int magic) throws BadStatusException{
        if(magic < 0) throw new BadStatusException();
        this.magic = magic;
    }
}
