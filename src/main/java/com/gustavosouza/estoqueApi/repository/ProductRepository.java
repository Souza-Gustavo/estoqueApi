package com.gustavosouza.estoqueApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavosouza.estoqueApi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
