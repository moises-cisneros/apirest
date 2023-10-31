package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.dto.CategoryDTO;
import com.proyectosi1.apirest.dto.EnvioCategoryDTO;
import com.proyectosi1.apirest.entity.CategoryEntity;

import com.proyectosi1.apirest.service.CategoryService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public CategoryEntity updateCategory(@PathVariable Integer id, @RequestBody CategoryEntity category) {
        category.setId(id);
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping("/{id}")
    public CategoryEntity getCategory(@PathVariable Integer id) {
        return categoryService.getCategoria(id);
    }

    @GetMapping
    public List<CategoryEntity> getAllCategory() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/send-category")
    public EnvioCategoryDTO sendCategory(){
        return categoryService.sendCategory();
    }

    @PostMapping("/save-category")
    public CategoryEntity saveCategory (@RequestBody CategoryDTO categoryDTO) {
        return categoryService.saveCategory(categoryDTO);
    }
}
