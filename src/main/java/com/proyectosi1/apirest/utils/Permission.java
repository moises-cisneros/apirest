package com.proyectosi1.apirest.utils;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum Permission {
    VER_MARCA,
    VER_COLOR,
    VER_CATEGORIA,
    VER_DESCUENTO,
    VER_BODEGA,
    VER_TALLA,
    VER_INVENTARIO,
    VER_NOTA_INGRESO,
    VER_PRODUCTO,
    VER_ROLES,
    VER_PERMISOS,
    VER_NOTA_VENTA,
    VER_TIPO_PAGO,
    VER_USUARIOS,
    VER_ADMINISTRAR_VENTA,
    VER_CATALOGO_PRODUCTO,
    VER_HOME;

    static {
        permissionListEnums = Arrays.stream(values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    private static final List<String> permissionListEnums;

    // Método para obtener la lista de nombres de permisos
    public static List<String> getAllPermissionNames() {
        return permissionListEnums;
    }

}
