package com.kkini.kkiniadminbackend.service;

import com.kkini.kkiniadminbackend.dto.product.ProductCreateRequestDTO;
import com.kkini.kkiniadminbackend.dto.product.ProductResponseDTO;
import com.kkini.kkiniadminbackend.dto.product.ProductUpdateRequestDTO;
import com.kkini.kkiniadminbackend.entity.product.Product;
import com.kkini.kkiniadminbackend.exception.product.ProductNotFoundException;
import com.kkini.kkiniadminbackend.service.product.ProductService;
import com.kkini.kkiniadminbackend.repository.DatabaseLoader;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private DatabaseLoader databaseLoader;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProductService productService;


    @BeforeEach
    public void setup() throws Exception {
        databaseLoader.initDatabase();
    }

    @AfterEach
    public void resetDatabase(){
        jdbcTemplate.execute("TRUNCATE TABLE product RESTART IDENTITY;");
    }

    @Test
    public void getAllProductTest(){
        List<ProductResponseDTO> productList = productService.getAllProducts();
        assertThat(productList.get(0).getProductName()).isEqualTo("토종효모로 만든로만밀통밀식빵");
        assertThat(productList.size()).isEqualTo(4);
    }

    @Test
    public void getProductByIdTest(){
        //existing ID
        Long Id = 2L;

        String expectedProductName = "스위트 쵸코 마카롱식품 유형과자";
        Double expectedServingSize = 30.0;

        ProductResponseDTO productDto = productService.getProductById(Id);
        assertThat(productDto.getProductName()).isEqualTo(expectedProductName);
        assertThat(productDto.getServingSize()).isEqualTo(expectedServingSize);
    }

    @Test
    public void getProductByIdExceptionTest(){
        //non-existing ID
        Long Id = 10L;

        assertThatThrownBy(()->productService.getProductById(Id))
                .isInstanceOf(ProductNotFoundException.class);
    }

    @Test
    public void createProductTest(){

        long expectedId = 5L;

        ProductCreateRequestDTO productDto = ProductCreateRequestDTO.builder()
                .categoryName("간식")
                .productName("킷캣")
                .image(null)
                .nutImage(null)
                .servingSize(36.5)
                .kcal(185.0)
                .sugar(17.0)
                .transFat(0.06)
                .carbohydrate(22.0)
                .protein(2.5)
                .sodium(22.0)
                .cholesterol(4.0)
                .saturatedFat(6.0)
                .fat(9.5)
                .build();

        assertThat(productService.createProduct(productDto)).isEqualTo(expectedId);
    }

    @Test
    @DisplayName("Edit product name")
    public void updateProductTest(){
        long productId = 2;
        String productNameToUpdate = "스위트 쵸코 마카롱";
        Double kcal = 135.0;

        ProductUpdateRequestDTO requestDTO = ProductUpdateRequestDTO.builder()
                .productName(productNameToUpdate)
                .build();

        assertThat(productService.updateProduct(productId, requestDTO))
                .isEqualTo(productId);

        assertThat(productService.getProductById(productId).getProductName())
                .isEqualTo(productNameToUpdate);
        //수정한 값 외의 다른 값은 변하지 않았는 지 확인
        assertThat(productService.getProductById(productId).getKcal()).isEqualTo(kcal);
    }

    @Test
    public void deleteProductByIdTest(){
        long productId = 1;

        productService.deleteProductById(productId);

        assertThat(productService.getAllProducts().size()).isEqualTo(3);
        assertThatThrownBy(() -> productService.getProductById(productId))
                .isInstanceOf(ProductNotFoundException.class);
    }


}
