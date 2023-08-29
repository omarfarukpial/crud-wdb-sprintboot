package com.pial.expensemanagement.model;

public class Expense {
    private int id;
    private String category;
    private String description;
    private double amount;
    private String datetime;


    public Expense(int id, String category, String description, double amount, String datetime) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.datetime = datetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
