package com.kkini.kkiniadminbackend.dto.product;


import com.kkini.kkiniadminbackend.entity.product.Product;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor @Builder
@NoArgsConstructor
public class ProductUpdateRequestDTO {

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



//    public void update(ProductResponseDTO responseDTO, ProductUpdateRequestDTO updateDTO){
//
//        responseDTO.setProductId(updateDTO.getProductId());
//
//        if(updateDTO.getCategoryName() != null) {
//            responseDTO.setCategoryName(updateDTO.getCategoryName());
//        }
//        if(updateDTO.getIsGreen() != null) {
//            responseDTO.setIsGreen(updateDTO.getIsGreen());
//        }
//        if(updateDTO.getProductName() != null) {
//            responseDTO.setProductName(updateDTO.getProductName());
//        }
//        if(updateDTO.getDetail() != null) {
//            responseDTO.setDetail(updateDTO.getDetail());
//        }
//        if(updateDTO.getMakerName() != null) {
//            responseDTO.setMakerName(updateDTO.getMakerName());
//        }
//        if(updateDTO.getAverageRating() != null) {
//            responseDTO.setAverageRating(updateDTO.getAverageRating());
//        }
//        if(updateDTO.getScore() != null) {
//            responseDTO.setScore(updateDTO.getScore());
//        }
//        if(updateDTO.getImage() != null) {
//            responseDTO.setImage(updateDTO.getImage());
//        }
//        if(updateDTO.getNutImage() != null) {
//            responseDTO.setNutImage(updateDTO.getNutImage());
//        }
//        if(updateDTO.getNutScore() != null) {
//            responseDTO.setNutScore(updateDTO.getNutScore());
//        }
//        if(updateDTO.getProductLink() != null) {
//            responseDTO.setProductLink(updateDTO.getProductLink());
//        }
//        if(updateDTO.getServingSize() != null) {
//            responseDTO.setServingSize(updateDTO.getServingSize());
//        }
//        if(updateDTO.getKcal() != null) {
//            responseDTO.setKcal(updateDTO.getKcal());
//        }
//        if(updateDTO.getSugar() != null) {
//            responseDTO.setSugar(updateDTO.getSugar());
//        }
//        if(updateDTO.getTransFat() != null) {
//            responseDTO.setTransFat(updateDTO.getTransFat());
//        }
//        if(updateDTO.getCarbohydrate() != null) {
//            responseDTO.setCarbohydrate(updateDTO.getCarbohydrate());
//        }
//        if(updateDTO.getProtein() != null) {
//            responseDTO.setProtein(updateDTO.getProtein());
//        }
//        if(updateDTO.getSodium() != null) {
//            responseDTO.setSodium(updateDTO.getSodium());
//        }
//        if(updateDTO.getCholesterol() != null) {
//            responseDTO.setCholesterol(updateDTO.getCholesterol());
//        }
//        if(updateDTO.getSaturatedFat() != null) {
//            responseDTO.setSaturatedFat(updateDTO.getSaturatedFat());
//        }
//        if(updateDTO.getFat() != null) {
//            responseDTO.setFat(updateDTO.getFat());
//        }
//
//    }

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

}
