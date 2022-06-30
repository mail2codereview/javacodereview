package com.example.dailyexpenses.controller;

import com.example.dailyexpenses.modal.Expenses;
import com.example.dailyexpenses.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpensesController {

    @Autowired
    ExpensesService expensesService;

    @CrossOrigin(origins = "*")
    @GetMapping("/expenses")
    private ResponseEntity<List<Expenses>> getAllExpenses(){
        return expensesService.getAllExpenses();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/expensesByCategory/{category_name}")
    private ResponseEntity<List<Expenses>> getAllExpensesByCategory(@PathVariable("category_name") String category_name){
        return expensesService.getAllExpensesByCategory(category_name);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/expenses/{id}")
    private ResponseEntity<Expenses> getExpenses(@PathVariable("id") int id)
    {
        return expensesService.getExpensesById(id);
    }
    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/expenses/{id}")
    private void deleteExpenses(@PathVariable("id") int id)
    {
        expensesService.delete(id);
    }
    //creating post mapping that post the book detail in the database
    @PostMapping("/expenses")
    private ResponseEntity saveExpenses(@RequestBody Expenses expenses)
    {
        expensesService.saveOrUpdate(expenses);
        return new ResponseEntity<>(expenses, HttpStatus.CREATED);
    }
    //creating put mapping that updates the book detail
    @PutMapping("/expenses")
    private Expenses update(@RequestBody Expenses expenses)
    {
        expensesService.saveOrUpdate(expenses);
        return expenses;
    }

    @GetMapping("/getExpensesByMonth")
    @CrossOrigin(origins = "*")
    private ResponseEntity<List<Expenses>> getAllExpensesByMonth(){
       return expensesService.getAllExpensesByMonth();
    }

    @GetMapping("/getExpensesByYear")
    @CrossOrigin(origins = "*")
    private ResponseEntity<List<Expenses>> getAllExpensesByYear(){

        return expensesService.getAllExpensesByYear();

    }
}
