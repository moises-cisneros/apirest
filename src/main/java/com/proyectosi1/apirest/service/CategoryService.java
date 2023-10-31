package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.dto.CategoryIdNombreDTO;
import com.proyectosi1.apirest.dto.EnvioCategoryDTO;
import com.proyectosi1.apirest.dto.EnvioMarcaDTO;
import com.proyectosi1.apirest.dto.MarcaIdNombreDTO;
import com.proyectosi1.apirest.entity.CategoryEntity;
import com.proyectosi1.apirest.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    // Crea un nuevo registro de categoria en la base de datos
    private final CategoryRepository categoryRepository;

    public CategoryEntity createCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    // Actualiza un registro de categoria en la base de datos
    public CategoryEntity updateCategory(CategoryEntity category) {
        return categoryRepository.save((category));
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    public CategoryEntity getCategoria(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    public EnvioCategoryDTO sendCategory() {
        List<CategoryIdNombreDTO> listCategory = new ArrayList<>();
        EnvioCategoryDTO envioCategory = new EnvioCategoryDTO();

        for(int i=1;i <= categoryRepository.count() ; i++ ) {
            CategoryIdNombreDTO category=new CategoryIdNombreDTO();
            category.setId(categoryRepository.findById(i).get().getId());
            category.setNombre(categoryRepository.findById(i).get().getNombre());
            listCategory.add(category);
        }
        envioCategory.setCategory(listCategory);

        return envioCategory;
    }

}
