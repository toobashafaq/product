package com.application.product.product.service;

import com.application.product.product.dto.ProductDTO;
import com.application.product.product.entity.Category;
import com.application.product.product.entity.Product;
import com.application.product.product.mapper.ProductMapper;
import com.application.product.product.repository.CategoryRepository;
import com.application.product.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ProductDTO> getAllProduct(){
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    public ProductDTO getProductById(Long id){
        Product product=productRepository.findById(id).orElseThrow(()->new RuntimeException("Id not found ")) ;
        return ProductMapper.toProductDTO(product);
    }

    public ProductDTO updateProduct(Long id,ProductDTO productDTO){
        Product product=productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        //check category available or not
        Category category=categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("Category not available"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

//    delete product
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product Deleted successfully";
    }

}
