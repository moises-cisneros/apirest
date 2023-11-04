package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.dto.CategoryDTO;
import com.proyectosi1.apirest.model.entity.CategoryEntity;
import com.proyectosi1.apirest.model.mapper.CategoryMapper;
import com.proyectosi1.apirest.model.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private final CategoryMapper categoryMapper;

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryMapper.categoryDTOToCategory(categoryDTO);
        categoryRepository.save(categoryEntity);
        return categoryMapper.categoryToCategoryDTO(categoryEntity);
    }

    // Actualiza un registro de categoria en la base de datos
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryRepository.save((categoryMapper.categoryDTOToCategory(categoryDTO)));
        return categoryMapper.categoryToCategoryDTO(categoryEntity);
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    public CategoryDTO getCategory(Integer id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElse(null);
        return categoryMapper.categoryToCategoryDTO(categoryEntity);
    }

    public List<CategoryDTO> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        return categoryMapper.listCategoryDTO(categoryEntities);
    }

}
