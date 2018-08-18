package com.example.ManyToMany.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    private int id;
    private String name;
    private String description;
    private Set<Category> categorySet;

    public Product() {
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Product(String name, String description, Set<Category> categorySet) {
        this.name = name;
        this.description = description;
        this.categorySet = categorySet;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Produst [id=%d, name='%s']%n", id, name);
        if (categorySet != null) {
            for(Category category : categorySet) {
                result += String.format(
                        "Category[id=%d, name='%s']%n",
                        category.getId(), category.getName());
            }
        }

        return result;
    }
}
