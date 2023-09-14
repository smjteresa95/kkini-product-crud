package com.kkini.kkiniadminbackend.service.product;

import com.kkini.kkiniadminbackend.dto.product.ProductCreateRequestDTO;
import com.kkini.kkiniadminbackend.dto.product.ProductResponseDTO;
import com.kkini.kkiniadminbackend.dto.product.ProductUpdateRequestDTO;

import java.util.List;

public interface ProductServiceInterface {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(Long productId);
    long createProduct(ProductCreateRequestDTO requestDTO);
    long updateProduct(Long productId, ProductUpdateRequestDTO requestDTO);
    void deleteProductById(Long productId);
}
