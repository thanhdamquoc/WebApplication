package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private int count;
    private String color;
    private String description;
    private int categoryId;

    public Product() {
    }

    public Product(int id, String name, double price, int count, String color, String description, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.color = color;
        this.description = description;
        this.categoryId = categoryId;
    }

    public Product(String name, double price, int count, String color, String description, int categoryId) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.color = color;
        this.description = description;
        this.categoryId = categoryId;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
