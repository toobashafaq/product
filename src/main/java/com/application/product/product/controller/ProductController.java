package com.application.product.product.controller;

import com.application.product.product.dto.ProductDTO;
import com.application.product.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired

    private ProductService productService;

//    get all
    @PostMapping
    public List<ProductDTO> getAllProduct(){
        return productService.getAllProduct();
    }


//    get by id
    @PostMapping("{/id}")
    public ProductDTO getById(@PathVariable Long id){
        return productService.getProductById(id);
    }

//    delete
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatusCode.valueOf(201));
    }

    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO){

    }

}
