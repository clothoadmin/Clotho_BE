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

import com.clotho.project.entity.WishlistItem;
import com.clotho.project.repository.WishlistRepository;
import com.clotho.project.Service.WishlistService;

@RestController
@RequestMapping("/api/wishlist")
@CrossOrigin
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;
    
    @Autowired
    private WishlistRepository repository;

    @GetMapping("/items")
    public List<WishlistItem> getAllWishlistItems() {
        return wishlistService.getAllWishlistItems();
    }

    @GetMapping("/items/{userId}")
    public List<WishlistItem> getWishlistItemByUserId(@PathVariable int userId) {
        return wishlistService.getWishlistItemByUserId(userId);
    }

    @PostMapping("/addItem")
    public WishlistItem addWishlistItem(@RequestBody WishlistItem wishlistItem) {
        return wishlistService.addWishlistItem(wishlistItem);
    }
    
    @DeleteMapping("/items/{itemId}")
    public void deleteWishlistItem(@PathVariable int itemId) {
        repository.deleteById(itemId);
    }
}
