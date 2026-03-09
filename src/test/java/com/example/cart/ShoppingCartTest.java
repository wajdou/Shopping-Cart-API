/*
package com.example.cart;

import com.example.cart.domain.*;
import com.example.cart.entities.CartItem;
import com.example.cart.entities.Product;
import com.example.cart.service.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @Test
    void testTotals() {
        ShoppingCart cart = new ShoppingCart(new DiscountPolicy(), new TaxCalculator());

        cart.addItem(new CartItem(new Product("Laptop", 1000, Category.ELECTRONICS), 1));
        cart.addItem(new CartItem(new Product("Apple", 2, Category.FOOD), 10));
        cart.addItem(new CartItem(new Product("T-Shirt", 20, Category.CLOTHING), 2));

        double subtotal = cart.subtotal();
        double tax = cart.tax();
        double total = cart.total();

        assertTrue(subtotal > 0);
        assertEquals(subtotal * 0.085, tax, 0.001);
        assertEquals(subtotal + tax, total, 0.001);
    }
}
*/
