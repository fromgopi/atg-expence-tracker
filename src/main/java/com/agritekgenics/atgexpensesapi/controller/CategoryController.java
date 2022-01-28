package com.agritekgenics.atgexpensesapi.controller;

import java.util.List;

import com.agritekgenics.atgexpensesapi.model.Category;
import com.agritekgenics.atgexpensesapi.repo.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {
    
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/")
    public ResponseEntity<List<Category>> get(){
        System.out.println("Coming into controller");
        List<Category> res =  categoryRepository.findAll();
        return ResponseEntity.ok(res);
    }
}
