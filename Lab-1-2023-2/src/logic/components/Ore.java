package logic.components;

import java.util.Objects;

public class Ore {
    private String name;
    private int cost;
    public Ore(String name, int cost) {
        this.setName(name);
        this.setCost(cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ore ore = (Ore) o;
        return cost == ore.cost && Objects.equals(name, ore.name);
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        if(cost<1) cost = 1;
        this.cost = cost;
    }
}
