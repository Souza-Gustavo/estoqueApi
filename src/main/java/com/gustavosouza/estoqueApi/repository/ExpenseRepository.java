package com.gustavosouza.estoqueApi.repository;

import com.gustavosouza.estoqueApi.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> { }
