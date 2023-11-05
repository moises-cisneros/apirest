package com.proyectosi1.apirest.model.entity;

import java.sql.Date;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "nota_venta")
public class NotaVentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @Temporal(TemporalType.DATE)
   private Date fecha;
   private float monto;

   @ManyToOne
   @JoinColumn(name = "id_usuario")
   private UserEntity user;



}
