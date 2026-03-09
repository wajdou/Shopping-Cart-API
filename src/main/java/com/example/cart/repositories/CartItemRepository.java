package com.example.cart.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cart.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {}
