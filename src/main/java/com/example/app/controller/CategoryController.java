package com.example.app.controller;

import com.example.app.entity.Category;
import com.example.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<Category> listCategories() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/add")
    public void showAddForm(Model model) {
        model.addAttribute("category", new Category());
    }

    @PostMapping("/newCategory")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @GetMapping("/{id}")
    public Optional<Category> viewCategory(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable Long id,
            @RequestBody Category category) {

        Optional<Category> optionalCategory = categoryService.findCategoryById(id);
        if (!optionalCategory.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Category existingCategory = optionalCategory.get();
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());

        Category updatedCategory = categoryService.save(existingCategory);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        Optional<Category> optionalCategory = categoryService.findCategoryById(id);
        if (!optionalCategory.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }

}
