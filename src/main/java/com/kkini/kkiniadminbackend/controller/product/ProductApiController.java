package com.kkini.kkiniadminbackend.controller.product;

import com.kkini.kkiniadminbackend.dto.product.ProductCreateRequestDTO;
import com.kkini.kkiniadminbackend.dto.product.ProductResponseDTO;
import com.kkini.kkiniadminbackend.dto.product.ProductUpdateRequestDTO;
import com.kkini.kkiniadminbackend.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductApiController implements ProductApiControllerInterface{

    @Autowired
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Override
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @Override
    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody ProductCreateRequestDTO productCreateRequestDTO) {
        return ResponseEntity.ok(productService.createProduct(productCreateRequestDTO));
    }

    @Override
    @PutMapping("/{productId}")
    public ResponseEntity<Long> updateProduct(@PathVariable Long productId, @RequestBody ProductUpdateRequestDTO productUpdateRequestDTO) {
        return ResponseEntity.ok(productService.updateProduct(productId, productUpdateRequestDTO));
    }

    @Override
    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable Long productId) {
        productService.deleteProductById(productId);
    }

}
