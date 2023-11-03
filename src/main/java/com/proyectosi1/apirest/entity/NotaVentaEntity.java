package com.proyectosi1.apirest.entity;

import java.sql.Date;
import java.util.List;

import com.proyectosi1.apirest.auth.user.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class NotaVentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   private Date fecha;
   private float monto;

   @ManyToOne
   @JoinColumn(name = "id_usuario")
   private UserEntity user;

    @ManyToMany( fetch = FetchType.LAZY)
    @JoinTable(
        name = "detalle_venta",
        joinColumns = @JoinColumn(name = "id_nota"),
        inverseJoinColumns = @JoinColumn(name = "id_inventario")
    )
    List<InventarioEntity> inventario;

}
