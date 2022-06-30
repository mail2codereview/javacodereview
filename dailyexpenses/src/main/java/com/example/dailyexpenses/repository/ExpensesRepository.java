package com.example.dailyexpenses.repository;

import com.example.dailyexpenses.modal.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
    @Query(value = "select id, categeroy_type, amount,category_id, created_at from expenses where categeroy_type = :category_name", nativeQuery = true)
    List<Expenses> findByCategoryType(@Param("category_name") String category_name);

    @Query(value = "select id, categeroy_type, amount,category_id, created_at from expenses where MONTH(created_at) = :month ORDER BY amount DESC", nativeQuery = true)
    List<Expenses> findAllExpensesByMonth(@Param("month") String month);

    @Query(value = "select id, categeroy_type, amount,category_id, created_at from expenses where Year(created_at) = :year ORDER BY amount DESC", nativeQuery = true)
    List<Expenses> findAllExpensesByYear(@Param("year") String month);
}
