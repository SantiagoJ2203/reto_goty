package com.example.goty.services;

import com.example.goty.models.ProductModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private List products = new ArrayList<>();

    public List<ProductModel> getProducts() {
        String uri = "http://localhost:3100/api/products";
        RestTemplate restTemplate = new RestTemplate();
        products = restTemplate.getForObject(uri, List.class);
        return products;
    }

    public List<ProductModel> getOtherProducts() {
        String uri = "http://localhost:3100/api/product/10000";
        RestTemplate restTemplate = new RestTemplate();
        products = restTemplate.getForObject(uri, List.class);
        return products;
    }

    public List<Object> getIdSimilarProducts(String id) {
        String uri = "http://localhost:3100/api/product/" + id + "/similars";
        RestTemplate restTemplate = new RestTemplate();
        Object[] products = restTemplate.getForObject(uri, Object[].class);
        return Arrays.asList(products);
    }

     public String[] getSimilarProductsInfo(List<Object> productsId) {
         String [] productSimilar = new String [productsId.size()];
         for (int x = 0; x < productsId.size(); x++) {
             String uri = "http://localhost:3100/api/product/" + productsId.get(x);
             RestTemplate restTemplate = new RestTemplate();
             productSimilar[x] = restTemplate.getForObject(uri, String.class);
         }
         return productSimilar;
     }
}