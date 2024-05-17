package com.clotho.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clotho.project.entity.CartItem;
import com.clotho.project.repository.CartRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<CartItem> getAllCartItems() {
        return cartRepository.findAll();
    }

    @Override
    public CartItem getCartItemByUserId(int userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public CartItem addCartItem(CartItem cartItem) {
        return cartRepository.save(cartItem);
    }

    @Override
    public void deleteByUserIdAndProductId(int userId, int productId) {
        CartItem cartItem = cartRepository.findByUserIdAndProductId(userId, productId);
        if (cartItem != null) {
            cartRepository.delete(cartItem);
        } else {
            throw new EntityNotFoundException("Cart item with user ID " + userId + " and product ID " + productId + " not found.");
        }
    }
}

