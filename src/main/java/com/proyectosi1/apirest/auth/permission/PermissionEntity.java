package com.proyectosi1.apirest.auth.permission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyectosi1.apirest.auth.role.RoleEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PERMISO")
public class PermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String nombre;

    //@JsonIgnore
    @ManyToMany(mappedBy = "permisos")
    private List<RoleEntity> roles;
}
