package com.kosta.domain;

import com.kosta.entity.Product;
import com.kosta.entity.User;
import lombok.Data;

@Data
public class ProductRequest {
    private Long id;
    private String name;
    private int price;
    private String password;
    private Long userId;

    public Product toEntity(User seller) {
        return Product.builder()
                    .name(name)
                    .price(price)
                    .password(password)
                    .seller(seller)
                    .build();
    }

}
