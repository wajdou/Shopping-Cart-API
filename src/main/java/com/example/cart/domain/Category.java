package com.example.cart.domain;

import lombok.Getter;

@Getter
public enum Category {
    ELECTRONICS(0.10),
    FOOD(0.05),
    CLOTHING(0.15);

    private final double discountRate;

    Category(double discountRate) {
        this.discountRate = discountRate;
    }
}
