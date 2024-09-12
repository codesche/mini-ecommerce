package com.kosta.service;

import com.kosta.domain.product.ProductRequest;
import com.kosta.domain.product.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    ProductResponse insertProduct(ProductRequest product, MultipartFile file);

}
