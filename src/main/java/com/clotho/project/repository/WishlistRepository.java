package com.clotho.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clotho.project.entity.WishlistItem;

public interface WishlistRepository extends JpaRepository<WishlistItem, Integer> {
	


    WishlistItem findByUserIdAndProductId(int userId, int productId);

    //void deleteByUserIdAndProductId(int userId, int productId);

	WishlistItem findByUserId(int userId);
} 


