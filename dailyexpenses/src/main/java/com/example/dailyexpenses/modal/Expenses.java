package com.example.dailyexpenses.modal;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String categeroy_type;
    private String amount;

    public Expenses() {

    }
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "category_id")
    private Categeroy category;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Expenses(long id, String categeroy_type, String amount, LocalDateTime createdAt) {
        this.id = id;
        this.categeroy_type = categeroy_type;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }



    public Categeroy getCategory() {
        return category;
    }

    public void setCategory(Categeroy category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategeroy_type() {
        return categeroy_type;
    }

    public void setCategeroy_type(String categeroy_type) {
        this.categeroy_type = categeroy_type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
