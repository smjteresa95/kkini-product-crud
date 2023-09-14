package com.kkini.kkiniadminbackend.repository;

import com.kkini.kkiniadminbackend.dto.product.ProductCreateRequestDTO;
import com.kkini.kkiniadminbackend.entity.product.Product;
import com.kkini.kkiniadminbackend.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseLoader {

    private final ProductRepository productRepository;

    public void initDatabase(){
        initProductDatabase();
    }

    private void initProductDatabase(){
        Product product1 = ProductCreateRequestDTO.builder()
                .categoryName("간식")
                .productName("토종효모로 만든로만밀통밀식빵")
                .image("https://sitem.ssgcdn.com/67/15/48/item/1000017481567_i1_1100.jpg")
                .nutImage("https://sitem.ssgcdn.com/67/15/48/qlty/1000017481567_q1.jpg")
                .servingSize(100.0)
                .kcal(271.0)
                .sugar(5.0)
                .transFat(0.0)
                .carbohydrate(46.0)
                .protein(12.0)
                .sodium(380.0)
                .cholesterol(2.0)
                .saturatedFat(1.5)
                .fat(6.0)
                .build().toEntity();

        Product product2 = ProductCreateRequestDTO.builder()
                .categoryName("간식")
                .productName("스위트 쵸코 마카롱식품 유형과자")
                .image("https://sitem.ssgcdn.com/99/99/19/item/1000023199999_i1_1100.jpg")
                .nutImage(null)
                .servingSize(30.0)
                .kcal(135.0)
                .sugar(10.0)
                .transFat(0.5)
                .carbohydrate(12.0)
                .protein(2.0)
                .sodium(20.0)
                .cholesterol(5.0)
                .saturatedFat(2.0)
                .fat(9.0)
                .build().toEntity();

        Product product3 = ProductCreateRequestDTO.builder()
                .categoryName("간식")
                .productName("바로 짜먹는 사과버터잼 ")
                .image(null)
                .nutImage("https://sitem.ssgcdn.com/35/26/22/qlty/1000034222635_q1.jpg")
                .servingSize(100.0)
                .kcal(295.0)
                .sugar(69.0)
                .transFat(null)
                .carbohydrate(69.0)
                .protein(0.0)
                .sodium(10.0)
                .cholesterol(5.0)
                .saturatedFat(1.5)
                .fat(2.2)
                .build().toEntity();

        Product product4 = ProductCreateRequestDTO.builder()
                .categoryName("간식")
                .productName(null)
                .image("https://sitem.ssgcdn.com/11/98/60/item/0000006609811_i1_1100.jpg")
                .nutImage("https://sitem.ssgcdn.com/11/98/60/qlty/0000006609811_q1.jpg")
                .servingSize(100.0)
                .kcal(null)
                .sugar(52.0)
                .transFat(0.0)
                .carbohydrate(64.0)
                .protein(1.0)
                .sodium(0.0)
                .cholesterol(0.0)
                .saturatedFat(0.5)
                .fat(0.2)
                .build().toEntity();

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);

    }



}
