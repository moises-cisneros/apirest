package com.proyectosi1.apirest.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
    
    private Integer Id;
    private String name;
    private String phone;
    private String email;
    private String username;

    private List<RoleDTO> roles;
    
}
