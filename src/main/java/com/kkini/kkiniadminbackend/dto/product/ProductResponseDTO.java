package com.kkini.kkiniadminbackend.dto.product;

import com.kkini.kkiniadminbackend.entity.product.Product;
import lombok.*;

import java.awt.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductResponseDTO {
    private Long productId;
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
    private Double carbohydrate;
    private Double protein;
    private Double sodium;
    private Double cholesterol;
    private Double saturatedFat;
    private Double fat;

    public Product toEntity() {
        return Product.builder()
                .productId(this.productId)
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

    public static ProductResponseDTO entityToDTO(Product product){
        return ProductResponseDTO.builder()
                .productId(product.getProductId())
                .categoryName(product.getCategoryName())
                .isGreen(product.getIsGreen())
                .productName(product.getProductName())
                .detail(product.getDetail())
                .makerName(product.getMakerName())
                .averageRating(product.getAverageRating())
                .score(product.getScore())
                .image(product.getImage())
                .nutImage(product.getNutImage())
                .nutScore(product.getNutScore())
                .productLink(product.getProductLink())

                .servingSize(product.getServingSize())
                .kcal(product.getKcal())
                .sugar(product.getSugar())
                .transFat(product.getTransFat())
                .carbohydrate(product.getCarbohydrate())
                .protein(product.getProtein())
                .sodium(product.getSodium())
                .cholesterol(product.getCholesterol())
                .saturatedFat(product.getSaturatedFat())
                .fat(product.getFat())
                .build();
    }


}
