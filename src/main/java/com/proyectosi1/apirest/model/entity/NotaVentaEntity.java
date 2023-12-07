package com.proyectosi1.apirest.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

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
   @Column(length = 10)
   private String estado;

   @ManyToOne
   @JoinColumn(name = "id_usuario")
   private UserEntity user;

   @ManyToOne
   @JoinColumn(name = "id_tipo_pago")
   private TipoPagoEntity tipoPago;

}
