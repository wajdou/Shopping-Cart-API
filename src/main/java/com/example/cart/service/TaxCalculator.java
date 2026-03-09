package com.example.cart.service;


import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class TaxCalculator {

    private static final BigDecimal TAX_RATE = new BigDecimal("0.085");

    public BigDecimal calculate(BigDecimal subtotal) {
        return subtotal.multiply(TAX_RATE).setScale(2, RoundingMode.HALF_UP);
    }
}
