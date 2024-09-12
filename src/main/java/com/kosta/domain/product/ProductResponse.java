package com.kosta.domain.product;

import com.kosta.entity.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

    private Long id;
    private String name;
    private String password;
    private int price;
    private ProductResponse seller;

    public static ProductResponse toDTO(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .password(product.getPassword())
                .build();
    }

}
