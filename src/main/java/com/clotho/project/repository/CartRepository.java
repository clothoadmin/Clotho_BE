package com.clotho.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.clotho.project.entity.CartItem;

public interface CartRepository extends JpaRepository<CartItem, Integer> {

    CartItem findByUserIdAndProductId(int userId, int productId);

    CartItem findByUserId(int userId);
    CartItem findByItemId(int itemId);
}