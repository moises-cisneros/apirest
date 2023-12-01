package com.proyectosi1.apirest.model.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotaEgresoDTO {
    private String descripcion;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private List<EgresoProductoDTO> detalleIngreso;
}
