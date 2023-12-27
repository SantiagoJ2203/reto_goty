package com.example.goty.controllers;

import com.example.goty.models.ProductModel;
import com.example.goty.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/goty")

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductModel>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "/similars/{id}")
    private String[] getResponse(@PathVariable("id") String id) {
        List<Object> productsId = productService.getIdSimilarProducts(id);
        return productService.getSimilarProductsInfo(productsId);
    }
}
