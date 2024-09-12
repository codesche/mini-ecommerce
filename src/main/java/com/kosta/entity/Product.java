package com.kosta.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String password;

    @JoinColumn(name = "image_id", nullable = true)
    @ManyToOne
    private ImageFile image;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private User seller;

}
