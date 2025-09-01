package com.application.product.product.controller;

import com.application.product.product.dto.ProductDTO;
import com.application.product.product.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Product REST API"
        ,description = "CRUD APIs"
)
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

//    get all
    @GetMapping
    public List<ProductDTO> getAllProduct(){
        return productService.getAllProduct();
    }


//    get by id
    @PostMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id){
        return productService.getProductById(id);
    }

//    delete
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO,@PathVariable Long id){
        return productService.updateProduct(id,productDTO);
    }


    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

}
