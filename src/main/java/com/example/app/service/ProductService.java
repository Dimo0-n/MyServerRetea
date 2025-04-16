package com.example.app.service;

import com.example.app.entity.Product;
import com.example.app.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product, Long categoryId) {

        Product product1 = new Product();
        product1.setCategory_id(categoryId);
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());

        productRepository.save(product1);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> findAllByCategoryId(Long categoryId){
        return productRepository.findAllByCategoryId(categoryId);
    }

}
