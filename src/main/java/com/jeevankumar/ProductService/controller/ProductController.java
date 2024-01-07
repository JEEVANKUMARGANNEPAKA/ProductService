package com.jeevankumar.ProductService.controller;

import com.jeevankumar.ProductService.entity.Product;
import com.jeevankumar.ProductService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product product1 = this.productService.createProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = this.productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("getProduct/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") long productId) {
        Product product = this.productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") long productId,
                                                 @RequestBody Product product) {
        Product product1 = this.productService.updateProduct(productId, product);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    @DeleteMapping("deleteProduct/{id}")
    private String deleteProductById(@PathVariable(value = "id") long productId) {
       return this.productService.deleteProductById(productId);

    }
}
