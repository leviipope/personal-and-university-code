package feladat2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Crystals {
    // fasterxml.jackson
    // jackson.core
    // jackson.databind

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("hardness")
    private double hardness;

    @JsonProperty("price")
    private int price;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getHardness() {
        return hardness;
    }
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Crystal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hardness=" + hardness +
                ", price=" + price +
                '}';
    }

    public Crystals(){}

}
