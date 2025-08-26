package com.application.product.product.mapper;

import com.application.product.product.dto.ProductDTO;
import com.application.product.product.entity.Category;
import com.application.product.product.entity.Product;

public class ProductMapper {

    //toProductDTO -entity to DTO

    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
                product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getCategory().getId()
        );
    }
    //toProductEntity-DTO to entity
    public static Product toProductEntity(ProductDTO productDTO, Category category){
        Product product=new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return product;
    }
}

