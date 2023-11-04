package com.proyectosi1.apirest.model.dto;

import com.proyectosi1.apirest.model.entity.CategoryEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    Integer id;
    String nombre;
    String idCategoryPadre;

}
