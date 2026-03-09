package com.example.cart.dto;


import jakarta.validation.constraints.NotNull;

public record CartItemDTO(
        Long id,
        @NotNull Long productId,
        int quantity
) {}
