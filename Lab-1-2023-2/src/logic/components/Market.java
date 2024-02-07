package logic.components;

import java.util.ArrayList;

public class Market {
    private String name;
    private ArrayList<Food> foods;
    private ArrayList<Potion> potions;
    public Market(String name) {
        this.setName(name);
        this.setFoods(new ArrayList<Food>());
        this.setPotions(new ArrayList<Potion>());
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }
    public ArrayList<Food> getFoods() {
        return foods;
    }
    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }
}
