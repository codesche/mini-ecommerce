package com.kosta.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ImageFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false, name = "original_name")
    private String originalName;

    @Column(nullable = false, name = "saved_name")
    private String savedName;

    @Column(nullable = false, name = "file_size")
    private Long fileSize;

    @Builder
    public ImageFile(String originalName, String savedName, Long fileSize) {
        this.originalName = originalName;
        this.savedName = savedName;
        this.fileSize = fileSize;
    }
}
