package com.clotho.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class WishlistItem {
    
    @Id
    private int userId;
    private int productId;

    

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

	@Override
	public String toString() {
		return "WishlistItem [userId=" + userId + ", productId=" + productId + "]";
	}
}
