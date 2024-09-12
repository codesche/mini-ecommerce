package com.kosta.service;

import com.kosta.domain.ProductRequest;
import com.kosta.domain.ProductResponse;
import com.kosta.entity.ImageFile;
import com.kosta.entity.Product;
import com.kosta.entity.User;
import com.kosta.repository.ProductRepository;
import com.kosta.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ImageFileService imageFileService;

    @Override
    public ProductResponse insertProduct(ProductRequest productDTO, MultipartFile file) {

        // 이미지 저장 위한 로직 구성
        ImageFile savedImage = imageFileService.saveImage(file);
        if (savedImage != null) {
            // productDTO 객체에 image 객체 넣기
            productDTO.setImageFile(savedImage);
        }

        User user = userRepository.findById(productDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다."));
        Product product = productDTO.toEntity(user);
        Product savedProduct = productRepository.save(product);

        return ProductResponse.toDTO(savedProduct);
    }

}
