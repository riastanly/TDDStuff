package org.test;

public class Item {
    private String id;
    private String name;
    private float price;
    private int quantity;

    public Item(String id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
