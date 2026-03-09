package com.example.cart.service;


import org.springframework.stereotype.Service;

import com.example.cart.entities.CartItem;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service

public class DiscountPolicy {

    public BigDecimal apply(CartItem item) {
        BigDecimal raw = item.getProduct().getPrice()
                .multiply(BigDecimal.valueOf(item.getQuantity()));
        BigDecimal rate = BigDecimal.valueOf(item.getProduct().getCategory().getDiscountRate());
        BigDecimal discount = raw.multiply(rate);
        return raw.subtract(discount).setScale(2, RoundingMode.HALF_UP);
    }
}
