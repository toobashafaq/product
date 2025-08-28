package com.application.product.product.controller;

import com.application.product.product.dto.CategoryDTO;
import com.application.product.product.entity.Category;
import com.application.product.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

//    get all categories

    @GetMapping
    public List<CategoryDTO> getAllCategoryies(){
        return categoryService.getAllCategories();
    }

//    create
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }
//    update

//    get By ID
    @PostMapping("/{id}")
    public CategoryDTO getById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

//    delete

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }
}
