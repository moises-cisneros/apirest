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
    private long id;

    @Column(nullable = false)
    private String name;
    private String phone;
    private String email;
    private String username;
    private String password;

    /*
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;*/    

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RoleEntity role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Devuelve una colección de autoridades (roles) asociados a este usuario
        return List.of(new SimpleGrantedAuthority(role.getName()));
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
