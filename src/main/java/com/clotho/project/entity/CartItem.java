package com.clotho.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CartItem {
    
    @Id
    private int userId;
    private int productId;
    private int quantity; // Adding quantity for the cart item

    // Getters and setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem [userId=" + userId + ", productId=" + productId + ", quantity=" + quantity + "]";
    }
}

