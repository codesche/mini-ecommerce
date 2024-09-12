package com.kosta.service;

import com.kosta.entity.ImageFile;
import com.kosta.repository.ImageFileRepository;
import com.kosta.util.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageFileServiceImpl implements ImageFileService {

    private final ImageFileRepository imageFileRepository;
    private final FileUtils fileUtils;

    @Override
    public ImageFile saveImage(MultipartFile file) {

        if (file != null) {
            // 파일 업로드 동작 구현
            ImageFile imageFile = fileUtils.fileUpload(file);
            if (imageFile != null) {
                ImageFile savedImageFile = imageFileRepository.save(imageFile);
                return savedImageFile;
            }
        }
        return null;
    }


}
