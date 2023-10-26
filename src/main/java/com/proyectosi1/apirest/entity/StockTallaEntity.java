package com.proyectosi1.apirest.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Stock_Talla")
public class StockTallaEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String talla;

    @OneToMany(mappedBy = "talla")
    private List<InventarioEntity> inventario;
}
