package com.gustavosouza.estoqueApi.controller;

import com.gustavosouza.estoqueApi.model.Income;
import com.gustavosouza.estoqueApi.model.Expense;
import com.gustavosouza.estoqueApi.repository.IncomeRepository;
import com.gustavosouza.estoqueApi.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FinancialSummaryController {

    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    public FinancialSummaryController(IncomeRepository incomeRepository, ExpenseRepository expenseRepository) {
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/financial-summary")
    public Map<String, Double> getSummary() {
        List<Income> incomes = incomeRepository.findAll();
        List<Expense> expenses = expenseRepository.findAll();

        double totalIncome = incomes.stream().mapToDouble(Income::getAmount).sum();
        double totalExpense = expenses.stream().mapToDouble(Expense::getAmount).sum();
        double balance = totalIncome - totalExpense;

        return Map.of(
                "totalIncome", totalIncome,
                "totalExpense", totalExpense,
                "balance", balance
        );
    }
}
