package com.kkini.kkiniadminbackend.entity.product;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "is_green", columnDefinition = "boolean default false")
    private Boolean isGreen;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "detail")
    private String detail;

    @Column(name = "average_rating")
    private Float averageRating;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "maker_name")
    private String makerName;

    @Column(name = "serving_size")
    private Double servingSize;

    @Column(name = "kcal")
    private Double kcal;

    @Column(name = "carbohydrate")
    private Double carbohydrate; // 탄수화물

    @Column(name = "protein")
    private Double protein; // 단백질

    @Column(name = "fat")
    private Double fat; // 지방

    @Column(name = "sodium")
    private Double sodium; // 나트륨

    @Column(name = "cholesterol")
    private Double cholesterol; // 콜레스테롤

    @Column(name = "saturated_fat")
    private Double saturatedFat; // 포화지방

    @Column(name = "trans_fat")
    private Double transFat;

    @Column(name = "sugar")
    private Double sugar;

    @Column(name = "score")
    private Double score;

    @Column(name = "image")
    private String image;

    @Column(name = "nut_image")
    private String nutImage;

    @Column(name = "nut_score")
    private Double nutScore;

    @Column(name = "product_link")
    private String productLink;


}
