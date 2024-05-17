package com.clotho.project.Service;

import java.util.List;

import com.clotho.project.entity.CartItem;


public interface CartService {

    List<CartItem> getAllCartItems();

    CartItem getCartItemByUserId(int userId);

    CartItem addCartItem(CartItem cartItem);

    void deleteByUserIdAndProductId(int userId, int productId);
}