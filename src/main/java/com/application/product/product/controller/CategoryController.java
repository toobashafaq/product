package com.application.product.product.controller;

import com.application.product.product.dto.CategoryDTO;
import com.application.product.product.entity.Category;
import com.application.product.product.exception.CategoryAlreadyExistsException;
import com.application.product.product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(
        name = "Category REST API"
        ,description = "CRUD APIs"
)
@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

//    get all categories

    @Operation(
            summary = "Fetch all Categories",
            description = "This controller will fetch all the categories"
    )
    @GetMapping
    public List<CategoryDTO> getAllCategoryies(){
        return categoryService.getAllCategories();
    }

//    create

    @Operation(
            summary = "Create Categories",
            description = "This controller will create aCategory"
    )
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
//        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
//        try{
//          CategoryDTO savedCategory=categoryService.createCategory(categoryDTO);
//          return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
//        }catch (CategoryAlreadyExistsException e){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//        }
        CategoryDTO savedCategory=categoryService.createCategory(categoryDTO);
          return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }
//    update

//    get By ID
@Operation(
        summary = "Update  Category",
        description = "This controller will update category"
)
    @PostMapping("/{id}")
    public CategoryDTO getById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

//    delete

    @Operation(
            summary = "delete  Category",
            description = "This controller will delete category"
    )
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }
}
