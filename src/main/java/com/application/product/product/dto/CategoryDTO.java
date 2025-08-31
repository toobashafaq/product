package com.application.product.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Schema(
        name = "Category ",
        description = "It holds info for category"
)
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
