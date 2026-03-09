package com.example.cart.mapper;


import com.example.cart.dto.CartItemDTO;
import com.example.cart.entities.CartItem;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CartItemMapper {

    @Mapping(source = "product.id", target = "productId")
    CartItemDTO toDto(CartItem entity);
}
