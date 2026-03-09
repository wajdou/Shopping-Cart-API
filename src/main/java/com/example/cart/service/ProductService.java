package com.example.cart.service;


import com.example.cart.dto.ProductDTO;
import com.example.cart.entities.Product;
import com.example.cart.mapper.ProductMapper;
import com.example.cart.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {

    private final ProductRepository repo;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repo, ProductMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<ProductDTO> findAll() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    public ProductDTO create(ProductDTO dto) {
        Product entity = mapper.toEntity(dto);
        return mapper.toDto(repo.save(entity));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
