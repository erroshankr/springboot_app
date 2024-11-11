package com.example.demo.beans;

import jakarta.persistence.*;

@Entity
@Table(name = "ice_creams")
public class IceCream {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "icecream_name", nullable = false)
    private String name;
    private String color;
    private String flavour;
    private int price;

    public IceCream() {
    }

    public IceCream(Long id, String name, String color, String flavour, int price) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.flavour = flavour;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


// Database --> 3rd party (outside of java) --> IP address, port, username & password