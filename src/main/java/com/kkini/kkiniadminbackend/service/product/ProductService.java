package com.kkini.kkiniadminbackend.service.product;

import com.kkini.kkiniadminbackend.dto.product.ProductCreateRequestDTO;
import com.kkini.kkiniadminbackend.dto.product.ProductUpdateRequestDTO;
import com.kkini.kkiniadminbackend.dto.product.ProductResponseDTO;
import com.kkini.kkiniadminbackend.entity.product.Product;
import com.kkini.kkiniadminbackend.exception.product.ProductNotFoundException;
import com.kkini.kkiniadminbackend.repository.product.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServiceInterface{

    private final ProductRepository productRepository;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductResponseDTO> dtoList = new ArrayList<>();

        for (Product product : productList) {
            ProductResponseDTO dto = new ProductResponseDTO().entityToDTO(product);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public ProductResponseDTO getProductById(Long productId) {
        Optional<Product> returnProduct = productRepository.findById(productId);
        ProductResponseDTO dto = new ProductResponseDTO();

        if (returnProduct.isPresent()) return dto.entityToDTO(returnProduct.get());
        else throw new ProductNotFoundException("Product " + productId + " not found");
    }

    @Override
    public long createProduct(ProductCreateRequestDTO requestDTO) {
        //저장한 상품의 product Id return
        return productRepository.save(requestDTO.toEntity()).getProductId();
    }

    @Override
    @Transactional
    public long updateProduct(Long productId, ProductUpdateRequestDTO updateDTO) {

        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product " + productId + " not found");
        }

        Product productToUpdate = optionalProduct.get();
        ProductResponseDTO responseDTO = ProductResponseDTO.entityToDTO(productToUpdate);

        if(updateDTO.getCategoryName() != null) {
            responseDTO.setCategoryName(updateDTO.getCategoryName());
        }
        if(updateDTO.getIsGreen() != null) {
            responseDTO.setIsGreen(updateDTO.getIsGreen());
        }
        if(updateDTO.getProductName() != null) {
            responseDTO.setProductName(updateDTO.getProductName());
        }
        if(updateDTO.getDetail() != null) {
            responseDTO.setDetail(updateDTO.getDetail());
        }
        if(updateDTO.getMakerName() != null) {
            responseDTO.setMakerName(updateDTO.getMakerName());
        }
        if(updateDTO.getAverageRating() != null) {
            responseDTO.setAverageRating(updateDTO.getAverageRating());
        }
        if(updateDTO.getScore() != null) {
            responseDTO.setScore(updateDTO.getScore());
        }
        if(updateDTO.getImage() != null) {
            responseDTO.setImage(updateDTO.getImage());
        }
        if(updateDTO.getNutImage() != null) {
            responseDTO.setNutImage(updateDTO.getNutImage());
        }
        if(updateDTO.getNutScore() != null) {
            responseDTO.setNutScore(updateDTO.getNutScore());
        }
        if(updateDTO.getProductLink() != null) {
            responseDTO.setProductLink(updateDTO.getProductLink());
        }
        if(updateDTO.getServingSize() != null) {
            responseDTO.setServingSize(updateDTO.getServingSize());
        }
        if(updateDTO.getKcal() != null) {
            responseDTO.setKcal(updateDTO.getKcal());
        }
        if(updateDTO.getSugar() != null) {
            responseDTO.setSugar(updateDTO.getSugar());
        }
        if(updateDTO.getTransFat() != null) {
            responseDTO.setTransFat(updateDTO.getTransFat());
        }
        if(updateDTO.getCarbohydrate() != null) {
            responseDTO.setCarbohydrate(updateDTO.getCarbohydrate());
        }
        if(updateDTO.getProtein() != null) {
            responseDTO.setProtein(updateDTO.getProtein());
        }
        if(updateDTO.getSodium() != null) {
            responseDTO.setSodium(updateDTO.getSodium());
        }
        if(updateDTO.getCholesterol() != null) {
            responseDTO.setCholesterol(updateDTO.getCholesterol());
        }
        if(updateDTO.getSaturatedFat() != null) {
            responseDTO.setSaturatedFat(updateDTO.getSaturatedFat());
        }
        if(updateDTO.getFat() != null) {
            responseDTO.setFat(updateDTO.getFat());
        }

        productRepository.save(responseDTO.toEntity());

        return productId;
    }

    @Override
    public void deleteProductById(Long productId) {
        Optional<Product> productToDelete = productRepository.findById(productId);
        if(productToDelete.isEmpty()){
            throw new ProductNotFoundException("Product " + productId + " not found");
        }
        Product product =  productToDelete.get();
        productRepository.delete(product);
    }



}
