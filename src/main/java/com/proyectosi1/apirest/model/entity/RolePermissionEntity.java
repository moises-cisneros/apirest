package com.proyectosi1.apirest.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "rol_permiso")
@IdClass(RolePermissionId.class)
public class RolePermissionEntity implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RoleEntity rol;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_permiso")
    private PermissionEntity permiso;
}
