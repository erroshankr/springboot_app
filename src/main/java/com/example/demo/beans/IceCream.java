package com.example.demo.beans;

import org.springframework.stereotype.Component;

@Component
public class IceCream {

    private int id;
    private String name;
    private String color;
    private String flavour;
    private int price;

    public IceCream() {
    }

    public IceCream(int id, String name, String color, String flavour, int price) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.flavour = flavour;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", flavour='" + flavour + '\'' +
                ", price=" + price +
                '}';
    }
}
