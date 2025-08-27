package com.application.product.product.service;

import com.application.product.product.dto.ProductDTO;
import com.application.product.product.entity.Category;
import com.application.product.product.entity.Product;
import com.application.product.product.mapper.ProductMapper;
import com.application.product.product.repository.CategoryRepository;
import com.application.product.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO){
        /**
         * id,name,descp,price,categoryId
         **/

        //check category is available or not
        Category category=categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

//        DTO TO ENTITY

        Product product=ProductMapper.toProductEntity(productDTO,category);
        product =productRepository.save(product);
        //return entity to dto
        return ProductMapper.toProductDTO(product);


    }
}
