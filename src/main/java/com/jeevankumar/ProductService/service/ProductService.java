package com.jeevankumar.ProductService.service;

import com.jeevankumar.ProductService.entity.Product;
import com.jeevankumar.ProductService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product getProductById(long productId) {
        return this.productRepository.findById(productId).orElseThrow(
                () -> new RuntimeException("There is no resource for particular id  :" + productId));
    }

    public Product updateProduct(long productId, Product product) {
        Product product1 = productRepository.findById(productId).orElseThrow(
                () -> new RuntimeException("There is no resource for particular id  :" + productId));
        product1.setId(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        return productRepository.save(product1);
    }

    public String deleteProductById(long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new RuntimeException("There is no resource for particular id  :" + productId));
        productRepository.deleteById(productId);
        return "Product is deleted successfully :" + productId;
    }
}
