package com.shoperz.shop.service;

import com.shoperz.shop.DTO.ApiResponse;
import com.shoperz.shop.model.Category;
import com.shoperz.shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public List<Category> getAllCategory(){
        return repo.findAll();
    }

    public Category addCategory(List<String> names) {
        Category existing = repo.findAll().stream().findFirst().orElse(null);

        if(existing == null){
            Category newCate = new Category(new ArrayList<>(names));
            return repo.save(newCate);
        }else {
            List<String> updated = existing.getCategories();
            updated.addAll(names);

            // set unique
            Set<String> unique = new LinkedHashSet<>(updated);
            existing.setCategories(new ArrayList<>(unique));

            return repo.save(existing);
        }
    }
}
