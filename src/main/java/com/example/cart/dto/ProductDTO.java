package com.example.cart.dto;


import com.example.cart.domain.Category;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductDTO(
        Long id,
        @NotBlank String name,
        @Positive BigDecimal price,
        @NotNull Category category
) {}
