package com.proyectosi1.apirest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserViuwDTO {
    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String username;

    private String rol;
}