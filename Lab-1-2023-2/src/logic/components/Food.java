package logic.components;

import java.util.Objects;

public class Food {
    private String name;
    private int price;
    private int energy;

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getEnergy() {
        return energy;
    }

    public Food(String name, int price, int energy) {
        this.setName(name);
        this.setPrice(price);
        this.setEnergy(energy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return price == food.price && energy == food.energy && Objects.equals(name, food.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        if(price < 1) price = 1;
        this.price = price;
    }

    public void setEnergy(int energy) {
        if(energy < 1) energy = 1;
        this.energy = energy;
    }
}
