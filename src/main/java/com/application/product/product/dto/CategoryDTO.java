package com.application.product.product.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {
    private long id;
    private String categoryName;
    private List<ProductDTO> products;


}
