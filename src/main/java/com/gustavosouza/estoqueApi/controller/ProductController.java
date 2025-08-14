package com.gustavosouza.estoqueApi.controller;

import org.springframework.web.bind.annotation.*;

import com.gustavosouza.estoqueApi.model.Product;
import com.gustavosouza.estoqueApi.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products") // Caminho base da API
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    // Listar todos os produtos
    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // Criar um produto
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    // Atualizar um produto
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product existing = repository.findById(id).orElseThrow();
        existing.setName(product.getName());
        existing.setQuantity(product.getQuantity());
        existing.setPrice(product.getPrice());
        return repository.save(existing);
    }

    // Deletar um produto
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
