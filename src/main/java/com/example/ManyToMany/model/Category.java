package com.example.ManyToMany.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

@Entity (name = "categories")
public class Category{
    private int id;
    private String name;
    private Set<Product> productSet;

    public Category() {

    }

    public Category(String name){
        this.name = name;
    }

    public Category(String name, Set<Product> productSet) {
        this.name = name;
        this.productSet = productSet;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NaturalId
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "categorySet")
    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productSet=" + productSet +
                '}';
    }
}
