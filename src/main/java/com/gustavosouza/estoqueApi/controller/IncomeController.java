package com.gustavosouza.estoqueApi.controller;

import com.gustavosouza.estoqueApi.model.Income;
import com.gustavosouza.estoqueApi.repository.IncomeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incomes")
public class IncomeController {

    private final IncomeRepository repository;

    public IncomeController(IncomeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Income> getAll() { return repository.findAll(); }

    @PostMapping
    public Income create(@RequestBody Income income) { return repository.save(income); }

    @PutMapping("/{id}")
    public Income update(@PathVariable Long id, @RequestBody Income income) {
        Income existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Income não encontrado com id: " + id));
        existing.setDescription(income.getDescription());
        existing.setAmount(income.getAmount());
        existing.setDate(income.getDate());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }
}
