package com.example.dailyexpenses.controller;


import com.example.dailyexpenses.modal.Categeroy;
import com.example.dailyexpenses.service.CategeroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategeroyController {

    @Autowired
    CategeroyService categeroyService;
    @GetMapping("/category")
    private ResponseEntity<List<Categeroy>> getAllExpenses(){
        return categeroyService.getAllCategory();
    }
}
