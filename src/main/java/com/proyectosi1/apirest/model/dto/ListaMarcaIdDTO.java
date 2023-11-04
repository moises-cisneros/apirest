package com.proyectosi1.apirest.model.dto;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListaMarcaIdDTO {
    List<MarcaIdNombreDTO> marcas;
}
