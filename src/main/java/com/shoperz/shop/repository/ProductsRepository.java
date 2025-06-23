package com.shoperz.shop.repository;

import com.shoperz.shop.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends MongoRepository<Products, Integer> {

    
}
