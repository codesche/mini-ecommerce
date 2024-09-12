package com.kosta.service;

import com.kosta.domain.ProductRequest;
import com.kosta.domain.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    ProductResponse insertProduct(ProductRequest product, MultipartFile file);

}
