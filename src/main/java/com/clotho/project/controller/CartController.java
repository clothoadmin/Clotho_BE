package com.clotho.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clotho.project.Service.CartService;
import com.clotho.project.entity.CartItem;


@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/items")
    public List<CartItem> getAllCartItems() {
        return cartService.getAllCartItems();
    }

    @GetMapping("/items/{userId}")
    public CartItem getCartItemByUserId(@PathVariable int userId) {
        return cartService.getCartItemByUserId(userId);
    }

    @PostMapping("/items")
    public CartItem addCartItem(@RequestBody CartItem cartItem) {
        return cartService.addCartItem(cartItem);
    }

    @DeleteMapping("/items/{userId}/{productId}")
    public void deleteCartItem(@PathVariable int userId, @PathVariable int productId) {
        cartService.deleteByUserIdAndProductId(userId, productId);
    }
}

