package com.example.cart.mapper;


import com.example.cart.dto.ProductDTO;
import com.example.cart.entities.Product;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDto(Product entity);
    Product toEntity(ProductDTO dto);
}
