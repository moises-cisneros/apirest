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
public class NotaIngresoDTO {
    String descripcion;
    @Temporal(TemporalType.DATE)
    Date fecha;
    List<IngresoProductoDTO> detalleIngreso;
}
