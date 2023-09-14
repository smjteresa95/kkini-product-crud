package com.kkini.kkiniadminbackend.controller;


import com.kkini.kkiniadminbackend.dto.product.ProductCreateRequestDTO;
import com.kkini.kkiniadminbackend.dto.product.ProductResponseDTO;
import com.kkini.kkiniadminbackend.dto.product.ProductUpdateRequestDTO;
import com.kkini.kkiniadminbackend.entity.product.Product;
import com.kkini.kkiniadminbackend.exception.product.ProductNotFoundException;
import com.kkini.kkiniadminbackend.repository.DatabaseLoader;
import com.kkini.kkiniadminbackend.repository.product.ProductRepository;
import com.kkini.kkiniadminbackend.service.product.ProductService;
import org.apache.coyote.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNull;

//implements several JUnit Jupiter extension model callback methods
@ExtendWith(SpringExtension.class)
//포트 충돌을 막고, 병렬 테스트 가능하게 하기 위해 random port 사용
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ProductService productService;

    @Autowired
    private DatabaseLoader databaseLoader;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void setup(){
        databaseLoader.initDatabase();
    }

    @AfterEach
    public void tearDown(){
        jdbcTemplate.execute("TRUNCATE TABLE product RESTART IDENTITY;");
    }

    @Test
    public void createProductTest(){
        //given
        String categoryName = "간식";
        String productName = "킷캣";
        Double servingSize = 36.5;
        Double kcal = 185.0;
        Double saturatedFat = 6.0;

        ProductCreateRequestDTO requestDTO = ProductCreateRequestDTO.builder()
                .categoryName(categoryName)
                .productName(productName)
                .servingSize(servingSize)
                .kcal(kcal)
                .saturatedFat(saturatedFat)
                .build();

        String url = "http://localhost:" + port + "/products";

        //when
        ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(url, requestDTO, long.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Product> productList = productRepository.findAll();

        assertThat(productList.size()).isEqualTo(5);
        assertThat(productList.get(4).getProductName()).isEqualTo(productName);
    }

    @Test
    public void getProductByIdTest(){

        long productId = 3;

        String expectedName = "바로 짜먹는 사과버터잼 ";
        String expectedImage = null;

        String url = "http://localhost:" + port + "/products/" + productId;

        ResponseEntity<ProductResponseDTO> responseEntity = testRestTemplate.getForEntity(url, ProductResponseDTO.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(Objects.requireNonNull(responseEntity.getBody()).getProductName()).isEqualTo(expectedName);
        assertThat(responseEntity.getBody().getImage()).isEqualTo(expectedImage);
    }

    @Test
    public void updateProductTest(){
        long productId = 2L;
        String expectedName = "스위트 쵸코 마카롱";
        Double expectedFat = null;

        ProductUpdateRequestDTO requestDTO = ProductUpdateRequestDTO.builder()
                .productName(expectedName)
                .fat(expectedFat)
                .build();

        String url = "http://localhost:" + port + "/products/" + productId;

        HttpEntity<ProductUpdateRequestDTO> requestEntity = new HttpEntity<>(requestDTO);

        //.exchange()는 update 할 때 사용되며, ResponseEntity로 반환 받는다.
        ResponseEntity<Long> responseEntity = testRestTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(productId);

        //상품 수정 값 확인
        ProductResponseDTO responseDTO = productService.getProductById(productId);
        assertThat(responseDTO.getProductName()).isEqualTo(expectedName);
        assertNull(responseDTO.getFat());

    }

    @Test
    public void deleteProductByIdTest(){
        long productId = 1L;

        String url = "http://localhost:" + port + "/products/" + productId;

        TestRestTemplate restTemplate = new TestRestTemplate();
        restTemplate.delete(url);

        assertThatThrownBy(() -> productService.getProductById(productId))
                .isInstanceOf(ProductNotFoundException.class);
    }

}
