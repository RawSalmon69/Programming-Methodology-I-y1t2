package logic.components;

import exception.BadStatusException;

public class Monster {
    private String name;
    private Status status;
    private Food food;
    private Potion potion;

    public Monster(String name, Status status) {
        this.setName(name);
        this.setStatus(status);
        if(this.getStatus().getHp() < 1) {
            try{
                this.getStatus().setHp(1);
            } catch(BadStatusException e){
                return;
            }
        }
        this.setFood(null);
        this.setPotion(null);
    }
    public void attack(Player player){
        int attack = this.getStatus().getAttack();
        int defense = player.getStatus().getDurability();
        int damage = attack - defense;
        if(damage < 0) damage = 0;
        int newhp = player.getStatus().getHp() - damage;
        if(newhp < 0) newhp = 0;
        try {
            player.getStatus().setHp(newhp);
        }catch(BadStatusException e){
            return;
        }
    }
    public void magicAttack(Player player){
        int attack = this.getStatus().getMagic();
        int damage = attack;
        int newhp = player.getStatus().getHp() - damage;
        if(newhp < 0) newhp = 0;
        try {
            player.getStatus().setHp(newhp);
        }catch(BadStatusException e){
            return;
        }
    }
    public String getName() {
        return name;
    }
    public Status getStatus() {
        return status;
    }
    public Food getFood() {
        return food;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }
}
