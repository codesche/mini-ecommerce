package com.kosta.controller;

import com.kosta.domain.product.ProductRequest;
import com.kosta.domain.product.ProductResponse;
import com.kosta.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    /* {"name": "이름", "price": 4000, "password": "1234", "userId": 1} */
    @PostMapping("")
    public ResponseEntity<ProductResponse> writeProduct(
            ProductRequest product, @RequestParam(name = "image", required = false) MultipartFile file) {
        ProductResponse savedProduct = productService.insertProduct(product, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    // 전체 상품 조회





}
