package com.product.crud.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//you can specify a cutom name for your entity table by using:
//@Table(name = "your table name")
@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private String desc;
    private int price;

    public Product() {
    }

    public Product(int id, String name, String desc, int price) {
        this.id = id;
        this.name = name;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
