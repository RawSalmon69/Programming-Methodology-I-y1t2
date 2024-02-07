package logic.components;

import exception.BadStatusException;

import java.util.ArrayList;

public class Player {
    private String name;
    private Status status;
    private int energy;
    private int money;
    private ArrayList<Food> foods;
    private ArrayList<Potion> potions;
    private ArrayList<Ore> ores;

    public Player(String name, Status status) {
        this.setName(name);
        this.setStatus(status);
        if(this.getStatus().getHp() < 1) {
            try{
                this.getStatus().setHp(1);
            } catch(BadStatusException e){
                return;
            }
        }
        this.setEnergy(10);
        this.setMoney(100);
        this.setFoods(new ArrayList<Food>());
        this.setPotions(new ArrayList<Potion>());
        this.setOres(new ArrayList<Ore>());
    }
    public Player(String name, Status status, int energy, int money) {
        this.setName(name);
        this.setStatus(status);
        if(this.getStatus().getHp() < 1) {
            try{
                this.getStatus().setHp(1);
            } catch(BadStatusException e){
                return;
            }
        }
        this.setEnergy(energy);
        this.setMoney(money);
        this.setFoods(new ArrayList<Food>());
        this.setPotions(new ArrayList<Potion>());
        this.setOres(new ArrayList<Ore>());
    }
    public boolean buyOre(Ore ore){
        if (money > ore.getCost()){
            money -= ore.getCost();
            ores.add(ore);
            return true;
        }
        return false;
    }
    public void drinkPotion(int index){
        if(index < 0 || index >= potions.size()) return;
        try{
            status.addStatus(potions.get(index).getIncreasingStatus());
        } catch(BadStatusException e){
            return;
        }
        potions.remove(index);
    }
    public void eatFood(int index){
        if(index < 0 || index >= foods.size()) return;
        energy += foods.get(index).getEnergy();
        foods.remove(index);
    }
    public void sellPotion(int index){
        if(index < 0 || index >= potions.size()) return;
        money += potions.get(index).getPrice();
        potions.remove(index);
    }
    public void sellFood(int index){
        if(index < 0 || index >= foods.size()) return;
        money += foods.get(index).getPrice();
        foods.remove(index);
    }
    public void attack(Monster monster){
        int attack = this.getStatus().getAttack();
        int defense = monster.getStatus().getDurability();
        int damage = attack - defense;
        if(damage < 0) damage = 0;
        int newhp = monster.getStatus().getHp() - damage;
        if(newhp < 0) newhp = 0;
        try {
            monster.getStatus().setHp(newhp);
        }catch(BadStatusException e){
            return;
        }
    }
    public void magicAttack(Monster monster){
        int attack = this.getStatus().getMagic();
        int damage = attack;
        int newhp = monster.getStatus().getHp() - damage;
        if(newhp < 0) newhp = 0;
        try {
            monster.getStatus().setHp(newhp);
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
    public int getEnergy() {
        return energy;
    }
    public int getMoney() {
        return money;
    }
    public ArrayList<Food> getFoods() {
        return foods;
    }
    public ArrayList<Potion> getPotions() {
        return potions;
    }
    public ArrayList<Ore> getOres() {
        return ores;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    public void setEnergy(int energy){
        if(energy < 1) energy = 0;
        this.energy = energy;
    }
    public void setMoney(int money){
        if(money < 1) money = 0;
        this.money = money;
    }
    public void setFoods(ArrayList<Food> foods){
        this.foods = foods;
    }
    public void setPotions(ArrayList<Potion> potions){
        this.potions = potions;
    }
    public void setOres(ArrayList<Ore> ores){
        this.ores = ores;
    }
}
