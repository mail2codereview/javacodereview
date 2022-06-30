package com.example.dailyexpenses.service;

import com.example.dailyexpenses.modal.Categeroy;
import com.example.dailyexpenses.modal.Expenses;
import com.example.dailyexpenses.repository.CategeroyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class CategeroyService {
    @Autowired
    CategeroyRepository categeroyRepository;
    public ResponseEntity<List<Categeroy>> getAllCategory() {

        try {
            List<Categeroy> categeroy = new ArrayList<Categeroy>();
            categeroyRepository.findAll().forEach(categeroy::add);
            System.out.println(categeroy);
            if (categeroy.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categeroy, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
