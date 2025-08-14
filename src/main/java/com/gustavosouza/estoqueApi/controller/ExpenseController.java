package com.gustavosouza.estoqueApi.controller;

import com.gustavosouza.estoqueApi.model.Expense;
import com.gustavosouza.estoqueApi.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseRepository repository;

    public ExpenseController(ExpenseRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Expense> getAll() { return repository.findAll(); }

    @PostMapping
    public Expense create(@RequestBody Expense expense) { return repository.save(expense); }

    @PutMapping("/{id}")
    public Expense update(@PathVariable Long id, @RequestBody Expense expense) {
        Expense existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense não encontrado com id: " + id));
        existing.setDescription(expense.getDescription());
        existing.setAmount(expense.getAmount());
        existing.setDate(expense.getDate());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }
}
