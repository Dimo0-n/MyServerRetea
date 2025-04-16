package com.example.app.controller;

import com.example.app.entity.Product;
import com.example.app.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryController categoryController;

    @GetMapping("/newProduct/{id}")
    public Product newProduct(@PathVariable Long id) {
        Product product = new Product();
        product.setCategory_id(id);
        return product;
    }

    @GetMapping("/getProducts/{id}")
    public List<Product> getAllProducts(@PathVariable Long id) {
        return productService.findAllByCategoryId(id);
    }

    @PostMapping("/add/{id}")
    public Product addProduct(@Valid @RequestBody Product product, @PathVariable Long id) {
        productService.save(product, id);
        return product;
    }

    @DeleteMapping("delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "{\"message\": \"Product deleted successfully\"}";
    }
}
