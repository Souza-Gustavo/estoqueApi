package com.gustavosouza.estoqueApi.repository;

import com.gustavosouza.estoqueApi.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> { }
