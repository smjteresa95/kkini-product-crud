package com.kkini.kkiniadminbackend.dto.product;

import com.kkini.kkiniadminbackend.entity.product.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductCreateRequestDTO {
    private String categoryName;
    private Boolean isGreen;
    private String productName;
    private String detail;
    private String makerName;
    private Float averageRating;
    private Double score;
    private String image;
    private String nutImage;
    private Double nutScore;
    private String productLink;

    private Double servingSize;
    private Double kcal;
    private Double sugar;
    private Double transFat;
    private Double carbohydrate; // 탄수화물
    private Double protein; // 단백질
    private Double sodium; // 나트륨
    private Double cholesterol;
    private Double saturatedFat; // 포화지방
    private Double fat; // 지방

    public Product toEntity() {
        return Product.builder()
                .categoryName(this.categoryName)
                .isGreen(this.isGreen)
                .productName(this.productName)
                .detail(this.detail)
                .makerName(this.makerName)
                .averageRating(this.averageRating)
                .score(this.score)
                .image(this.image)
                .nutImage(this.nutImage)
                .nutScore(this.nutScore)
                .productLink(this.productLink)

                .servingSize(this.servingSize)
                .kcal(this.kcal)
                .sugar(this.sugar)
                .transFat(this.transFat)
                .carbohydrate(this.carbohydrate)
                .protein(this.protein)
                .sodium(this.sodium)
                .cholesterol(this.cholesterol)
                .saturatedFat(this.saturatedFat)
                .fat(this.fat)
                .build();
    }
}
