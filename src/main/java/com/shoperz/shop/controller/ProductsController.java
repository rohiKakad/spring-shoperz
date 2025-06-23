package com.shoperz.shop.controller;

import com.shoperz.shop.DTO.SaveProductsResponse;
import com.shoperz.shop.model.Products;
import com.shoperz.shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService ser;

    @PostMapping("/saveAll")
    public ResponseEntity<SaveProductsResponse> saveProducts(@RequestBody List<Products> products){
       try {
          SaveProductsResponse result = ser.saveProducts(products);
          return ResponseEntity.status(HttpStatus.CREATED).body(result);
       } catch (Exception e) {
           throw new ResponseStatusException(
                   HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save", e
           );
       }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Products>> getAllProducts(){
        try {
            List<Products> result = ser.getAllProducts();
            if(result.isEmpty()){
                return ResponseEntity.ok(Collections.emptyList());
            }else {
               return ResponseEntity.ok(result);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve the products",e
            );
        }
    }

}