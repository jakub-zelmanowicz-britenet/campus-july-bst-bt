package pl.britenet.campus.object;

import pl.britenet.campus.Constants;

public class Product {
    private final int id;
    private String name;
    private String description;
    private double price;

    public Product(){
        this.id = Constants.INVALID_ID;
    }

    public Product(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
