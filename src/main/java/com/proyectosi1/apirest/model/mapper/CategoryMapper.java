package com.proyectosi1.apirest.model.mapper;

import com.proyectosi1.apirest.model.dto.CategoryDTO;
import com.proyectosi1.apirest.model.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "idCategoryPadre",
            expression = "java(mapIdCategoryPadre(categoryDTO.getIdCategoryPadre()))")
    CategoryEntity categoryDTOToCategory(CategoryDTO categoryDTO);

    @Mapping(target = "idCategoryPadre",
            expression = "java(mapIdCategoryPadre(categoryEntity.getIdCategoryPadre()))")
    CategoryDTO categoryToCategoryDTO(CategoryEntity categoryEntity);

    List<CategoryEntity> listCategory(List<CategoryDTO> categoryDTOList);

    List<CategoryDTO> listCategoryDTO(List<CategoryEntity> categoryEntityList);

    default CategoryEntity mapIdCategoryPadre(String idCategoriaPadre) {
        if (idCategoriaPadre == null || idCategoriaPadre.isEmpty()) {
            return null;
        } else {
            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity.setId(Integer.parseInt(idCategoriaPadre));
            return categoryEntity;
        }
    }

    default String mapIdCategoryPadre(CategoryEntity idCategoriaPadre) {
        return (idCategoriaPadre != null) ? idCategoriaPadre.getId().toString() : null;
    }
}
