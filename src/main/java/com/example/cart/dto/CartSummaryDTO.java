package com.example.cart.dto;

import java.math.BigDecimal;
import java.util.List;

public record CartSummaryDTO(
        BigDecimal subtotal,
        BigDecimal tax,
        BigDecimal total,
        List<CartItemDTO> items
) {}
