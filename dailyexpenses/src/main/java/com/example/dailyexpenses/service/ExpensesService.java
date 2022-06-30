package com.example.dailyexpenses.service;

import com.example.dailyexpenses.modal.Expenses;
import com.example.dailyexpenses.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@Service
public class ExpensesService {
    @Autowired
    ExpensesRepository expensesRepository;

    //getting all expenses record by using the method findaAll() of CrudRepository
    public <expenses> ResponseEntity <List<Expenses>> getAllExpenses()
    {
        try {
            List<Expenses> expenses = new ArrayList<Expenses>();
            expensesRepository.findAll().forEach(expenses::add);
           // System.out.println(expenses);
            if (expenses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(expenses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Expenses> getExpensesById(int id)
    {
        try {
            Optional<Expenses> expenses = expensesRepository.findById((long) id);
            if (expenses.isPresent()) {
                return new ResponseEntity<>(expenses.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //saving a specific record by using the method save() of CrudRepository
    public Expenses saveOrUpdate(Expenses expenses)
    {
        expensesRepository.save(expenses);
        return expenses;
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        expensesRepository.deleteById((long) id);
    }
    //updating a record
    public void update(Expenses expenses, int expensesid)
    {
        expensesRepository.save(expenses);
    }

    public ResponseEntity<List<Expenses>> getAllExpensesByCategory(String category_name) {
        try {
            List<Expenses> expenses = expensesRepository.findByCategoryType(category_name);
             System.out.println(expenses);
            if (expenses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(expenses, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    public ResponseEntity<List<Expenses>> getAllExpensesByMonth() {
        try {
            int month = YearMonth.now().getMonthValue();
            List<Expenses> expenses = expensesRepository.findAllExpensesByMonth(String.valueOf(month));

            if (expenses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(expenses, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Expenses>> getAllExpensesByYear() {
        try {
            int year = Year.now().getValue();
            List<Expenses> expenses = expensesRepository.findAllExpensesByYear(String.valueOf(year));

            if (expenses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(expenses, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
