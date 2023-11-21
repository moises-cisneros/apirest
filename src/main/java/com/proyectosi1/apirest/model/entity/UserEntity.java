package com.proyectosi1.apirest.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "USUARIO", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
// No tener repetido el username
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;
    private String phone;
    private String email;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RoleEntity role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Verifica si role no es null antes de intentar acceder a sus propiedades
        if (role != null) {
            // Devuelve una colección de autoridades (roles) asociados a este usuario
            return List.of(new SimpleGrantedAuthority(role.getName()));
        } else {
            // Si role es null, puedes manejarlo de alguna manera adecuada
            return Collections.emptyList();
        }
    }


    @Override
    public boolean isAccountNonExpired() {
        // Indica si la cuenta del usuario no ha caducado.
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Indica si la cuenta del usuario no está bloqueada.
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Indica si las credenciales del usuario (contraseña) no han caducado.
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Indica si el usuario está habilitado y puede iniciar sesión.
        return true;
    }
}
