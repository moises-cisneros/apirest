package com.proyectosi1.apirest.auth.role;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.proyectosi1.apirest.auth.permission.PermissionEntity;
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
@Table(name = "ROL")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String name;

    @JsonIgnoreProperties("roles")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Rol_Permiso", joinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_permiso", referencedColumnName = "id")
    )
    private List<PermissionEntity> permisos;

}
