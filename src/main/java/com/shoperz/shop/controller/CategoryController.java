package com.shoperz.shop.controller;

import com.shoperz.shop.DTO.ApiResponse;
import com.shoperz.shop.model.Category;
import com.shoperz.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

    @Autowired
    private CategoryService ser;

    @GetMapping
    public List<Category> getAllCategories(){
        return ser.getAllCategory();
    }

    @PostMapping("/addCategory")
    public ResponseEntity<ApiResponse<String>> addCategory(@RequestBody List<String> names) {
        Category saved = ser.addCategory(names);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Inserted",
                        "saved"
                )
        );
    }
}
