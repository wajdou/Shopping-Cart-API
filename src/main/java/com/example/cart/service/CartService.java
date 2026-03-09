package com.example.cart.service;

import com.example.cart.dto.CartItemDTO;
import com.example.cart.dto.CartSummaryDTO;
import com.example.cart.entities.CartItem;
import com.example.cart.entities.Product;
import com.example.cart.mapper.CartItemMapper;
import com.example.cart.repositories.CartItemRepository;
import com.example.cart.repositories.ProductRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service

public class CartService {

    private final CartItemRepository cartRepo;
    private final ProductRepository productRepo;
    private final DiscountPolicy discountPolicy;
    private final TaxCalculator taxCalculator;
    private final CartItemMapper cartItemMapper;

    public CartService(CartItemRepository cartRepo,
                       ProductRepository productRepo,
                       DiscountPolicy discountPolicy,
                       TaxCalculator taxCalculator,
                       CartItemMapper cartItemMapper) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
        this.discountPolicy = discountPolicy;
        this.taxCalculator = taxCalculator;
        this.cartItemMapper = cartItemMapper;
    }

    public CartItemDTO addItem(CartItemDTO dto) {
        Product product = productRepo.findById(dto.productId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        CartItem item = new CartItem();
        item.setProduct(product);
        item.setQuantity(dto.quantity());

        CartItem saved = cartRepo.save(item);
        return cartItemMapper.toDto(saved);
    }

    public void deleteItem(Long id) {
        cartRepo.deleteById(id);
    }

    public CartSummaryDTO getSummary() {
        List<CartItem> items = cartRepo.findAll();

        BigDecimal subtotal = items.stream()
                .map(discountPolicy::apply)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal tax = taxCalculator.calculate(subtotal);
        BigDecimal total = subtotal.add(tax);

        List<CartItemDTO> itemDtos = items.stream()
                .map(cartItemMapper::toDto)
                .toList();

        return new CartSummaryDTO(subtotal, tax, total, itemDtos);
    }

    public CartItemDTO updateItem(Long id, CartItemDTO dto) {
        CartItem item = cartRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cart item not found"));

        Product product = productRepo.findById(dto.productId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        item.setProduct(product);
        item.setQuantity(dto.quantity());

        CartItem saved = cartRepo.save(item);
        return cartItemMapper.toDto(saved);
    }

}
