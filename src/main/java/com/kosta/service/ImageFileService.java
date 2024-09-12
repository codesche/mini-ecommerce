package com.kosta.service;

import com.kosta.entity.ImageFile;
import org.springframework.web.multipart.MultipartFile;

public interface ImageFileService {

    ImageFile saveImage(MultipartFile file);

}
