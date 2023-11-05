package com.proyectosi1.apirest.model.mapper;

import com.proyectosi1.apirest.model.dto.ProductoDTO;
import com.proyectosi1.apirest.model.entity.ProductoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {MarcaMapper.class, CategoryMapper.class, ColorMapper.class, DescuentoMapper.class})
public interface ProductoMapper {

    ProductoEntity productoDTOToProducto(ProductoDTO productoDTO);

    ProductoDTO productoToProductoDTO(ProductoEntity productoEntity);

    List<ProductoEntity> listProducto(List<ProductoDTO> productoDTOList);

    List<ProductoDTO> listProductoDTO(List<ProductoEntity> productoEntityList);

}
