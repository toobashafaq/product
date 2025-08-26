package com.application.product.product.mapper;

import com.application.product.product.dto.CategoryDTO;
import com.application.product.product.entity.Category;

public class CategoryMapper {


    public static CategoryDTO categoryDTO(Category category){
        if(category==null){
            return null;
        }
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setProducts(category.getProducts().stream().map(ProductMapper::toProductDTO).toList());
        return categoryDTO;
    }
    public static Category toCategoryEntity(CategoryDTO categoryDTO){
        Category category=new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        return category;
    }

}
