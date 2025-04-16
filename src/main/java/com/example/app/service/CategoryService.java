package com.example.app.service;

import com.example.app.entity.Category;
import com.example.app.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAllCategories();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(Long.valueOf(id));
    }

    public Optional<Category> findCategoryById(Long id){
        return categoryRepository.findById(id);
    }

    public Category save(Category category) {
        categoryRepository.save(category);
        return category;
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

}
