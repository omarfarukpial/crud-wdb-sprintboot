package com.pial.expensemanagement.service;


import com.pial.expensemanagement.model.Expense;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ExpenseService {
    List <Expense> expenseList = new ArrayList<>();

    @PostConstruct
    public void init() {
        expenseList.add(new Expense(101, "Food", "Chicken chap",120.00,"28-08-2023"));
        expenseList.add(new Expense(102, "Transportation", "Bus fare",30.00,"29-08-2023"));
        expenseList.add(new Expense(103, "Entertainment", "Oppenheimer movie",1000.00,"29-08-2023"));
        expenseList.add(new Expense(104, "Utilities", "Electricity bill",500.00,"29-08-2023"));
    }


    public Expense findById(Integer id) {
        for (Expense ex : expenseList) {
            if (Objects.equals(ex.getId(), id))
                return ex;
        }
        return null;
    }

    public List<Expense> getAllExpense() {
        return expenseList;
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    public void deleteExpense(int id) {
        Expense expenseToRemove = null;
        for (Expense expense : expenseList) {
            if (expense.getId() == id) {
                expenseToRemove = expense;
                break;
            }
        }

        if (expenseToRemove != null) {
            expenseList.remove(expenseToRemove);
        }
    }

}
