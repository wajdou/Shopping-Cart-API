package com.example.cart;


import com.example.cart.domain.Category;
import com.example.cart.dto.ProductDTO;
import com.example.cart.dto.CartItemDTO;
import com.example.cart.service.CartService;
import com.example.cart.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CartServiceTest {

    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;

    @Test
    void testCartSummary() {
        ProductDTO p1 = productService.create(
                new ProductDTO(null, "T-Shirt", new BigDecimal("20.00"), Category.CLOTHING));
        cartService.addItem(new CartItemDTO(null, p1.id(), 2));

        var summary = cartService.getSummary();

        assertThat(summary.subtotal()).isGreaterThan(BigDecimal.ZERO);
        assertThat(summary.total()).isGreaterThan(summary.subtotal());
    }
}
