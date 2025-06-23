package com.shoperz.shop.DTO;

import com.shoperz.shop.model.Products;

import java.util.List;

public class SaveProductsResponse {

    private final List<Products> saved;
    private final List<Products> skipped;
    private String message;

    public SaveProductsResponse(List<Products> saved, List<Products> skipped, String message){
        this.saved = saved;
        this.skipped = skipped;
        this.message = message;
    }

    public List<Products> getSaved(){
        return saved;
    }

    public List<Products> getSkipped(){
        return skipped;
    }

    public String getMessage(){
        return message;
    }
}
