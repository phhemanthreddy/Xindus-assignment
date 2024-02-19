package com.Xindus_assignment.eCommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WishlistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;

    // Default constructor
    public WishlistItem() {
        // Default constructor for JPA
    }

    // Parameterized constructor
    public WishlistItem(String itemName) {
        this.itemName = itemName;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for itemName
    public String getItemName() {
        return itemName;
    }

    // Setter for itemName
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // toString method for better logging and debugging
    @Override
    public String toString() {
        return "WishlistItem{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                '}';
    }

    // Other methods or additional fields can be added as needed
}
