package com.application.product.product.service;

import com.application.product.product.dto.CategoryDTO;
import com.application.product.product.entity.Category;
import com.application.product.product.mapper.CategoryMapper;
import com.application.product.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
//    create
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category=CategoryMapper.toCategoryEntity(categoryDTO);
        category=categoryRepository.save(category);
        return CategoryMapper.categoryDTO(category);
    }
//    getall
//    get
//    delete
}
