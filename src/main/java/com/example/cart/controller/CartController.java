package com.example.cart.controller;


import com.example.cart.dto.CartItemDTO;
import com.example.cart.dto.CartSummaryDTO;
import com.example.cart.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@Tag(name = "Cart")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping("/items")
    @Operation(summary = "Add item to cart")
    public CartItemDTO addItem(@Valid @RequestBody CartItemDTO dto) {
        return service.addItem(dto);
    }

    @DeleteMapping("/items/{id}")
    @Operation(summary = "Delete item from cart")
    public void deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
    }

    @GetMapping("/summary")
    @Operation(summary = "Get cart summary")
    public CartSummaryDTO summary() {
        return service.getSummary();
    }

    @PutMapping("/items/{id}")
    public CartItemDTO updateItem(
            @PathVariable Long id,
            @Valid @RequestBody CartItemDTO dto
    ) {
        return service.updateItem(id, dto);
    }

}

