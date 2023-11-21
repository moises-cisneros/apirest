package com.proyectosi1.apirest.model.mapper;

import com.proyectosi1.apirest.model.repository.PermissionRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PermissionMapper {

    @Autowired
    private PermissionRepository permissionRepository;

}
