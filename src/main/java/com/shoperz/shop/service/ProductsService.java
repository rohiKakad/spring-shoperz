package com.shoperz.shop.service;

import com.shoperz.shop.model.Products;
import com.shoperz.shop.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository repo;

    // post
    public List<Products> saveProducts(List<Products> productsList){
        return repo.saveAll(productsList);
    }

    // get all
    public List<Products> getAllProducts(){
        return repo.findAll();
    }
}
