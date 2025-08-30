package com.application.product.product.service;

import com.application.product.product.dto.CategoryDTO;
import com.application.product.product.entity.Category;
import com.application.product.product.mapper.CategoryMapper;
import com.application.product.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
//    create
    public CategoryDTO createCategory(CategoryDTO categoryDTO){

//        check duplicate category
        Optional<Category> optionalCategory= categoryRepository.findByCategoryNameIgnoreCase(categoryDTO.getCategoryName());
        if(optionalCategory.isPresent()){
            throw new RuntimeException("Category already exists");
        }
        Category category=CategoryMapper.toCategoryEntity(categoryDTO);
        category=categoryRepository.save(category);
        return CategoryMapper.categoryDTO(category);
    }
//    getall
    public List<CategoryDTO> getAllCategories(){
       return categoryRepository.findAll().stream().map(CategoryMapper::categoryDTO).toList();
    }
//    get

    public CategoryDTO getCategoryById(Long id){
       Category category= categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
        return CategoryMapper.categoryDTO(category);
    }
//    delete

    public String deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Successfully deleted";
    }
}
