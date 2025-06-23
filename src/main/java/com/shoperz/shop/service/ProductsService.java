package com.shoperz.shop.service;

import com.shoperz.shop.DTO.SaveProductsResponse;
import com.shoperz.shop.model.Products;
import com.shoperz.shop.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository repo;

    // post
    public SaveProductsResponse saveProducts(List<Products> productsList){
        List<Integer> Ids = productsList.stream()
                .map(Products::getId)
                .toList();

        Set<Integer> existingIds = repo.findAllById(Ids).stream()
                .map(Products::getId)
                .collect(Collectors.toSet());

        List<Products> toSave = productsList.stream()
                .filter(p -> !existingIds.contains(p.getId()))
                .toList();
        List<Products> saved = repo.saveAll(toSave);
        List<Products> skipped = productsList.stream()
                .filter(p -> existingIds.contains(p.getId()))
                .toList();

        String message = skipped.isEmpty() ? "ALL records are inserted successfully."
                                              : "Some records were skipped as they already exist.";

        return new SaveProductsResponse(saved, skipped, message);
    }

    // get all
    public List<Products> getAllProducts(){
        return repo.findAll();
    }
}
