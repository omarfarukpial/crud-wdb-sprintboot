package com.pial.expensemanagement.controller;


import com.pial.expensemanagement.model.Expense;
import com.pial.expensemanagement.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/")
    public String redirectToHomepage() {
        return "redirect:/home";
    }
    @GetMapping("home")
    public String homepage(Model model) {
        model.addAttribute("expenseList", expenseService.getAllExpense());

        return "home";
    }

    @GetMapping("create")
    public String create() {
        return "create";
    }


    @PostMapping("save")
    public String saveExpense(@ModelAttribute Expense expense) {
        expenseService.addExpense(expense);
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Expense expense = expenseService.findById(id);
        if (expense != null) {
            model.addAttribute("expense", expense);
            return "update-form"; // Replace with the actual Thymeleaf template name
        }
        return null;
    }


    @PostMapping("/update/{id}")
    public String updateExpense(@PathVariable int id, @ModelAttribute Expense updatedExpense) {
        Expense expense = expenseService.findById(id);
        if (expense != null) {
            expense.setCategory(updatedExpense.getCategory());
            expense.setDescription(updatedExpense.getDescription());
            expense.setAmount(updatedExpense.getAmount());
            expense.setDatetime(updatedExpense.getDatetime());

            return "redirect:/home"; // Redirect to the expenses list page after updating
        }
        return null;
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable("id") int id) {
        expenseService.deleteExpense(id);
        return "redirect:/home";
    }





}
