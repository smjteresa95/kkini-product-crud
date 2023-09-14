package com.kkini.kkiniadminbackend.controller.product;

import com.kkini.kkiniadminbackend.dto.product.ProductCreateRequestDTO;
import com.kkini.kkiniadminbackend.dto.product.ProductResponseDTO;
import com.kkini.kkiniadminbackend.dto.product.ProductUpdateRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductApiControllerInterface {

    ResponseEntity<List<ProductResponseDTO>> getAllProducts();
    ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long productId);
    ResponseEntity<Long> createProduct(@RequestBody ProductCreateRequestDTO productCreateRequestDTO);
    ResponseEntity<Long> updateProduct(@PathVariable Long productId, @RequestBody ProductUpdateRequestDTO productUpdateRequestDTO);
    void deleteProductById(@PathVariable Long productId);
}
