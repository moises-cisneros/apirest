package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.dto.*;
import com.proyectosi1.apirest.model.entity.*;
import com.proyectosi1.apirest.model.mapper.CategoryMapper;
import com.proyectosi1.apirest.model.mapper.ColorMapper;
import com.proyectosi1.apirest.model.mapper.DescuentoMapper;
import com.proyectosi1.apirest.model.mapper.MarcaMapper;
import com.proyectosi1.apirest.model.repository.InventarioRepository;
import com.proyectosi1.apirest.model.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class CatalogoService {

    private final InventarioRepository inventarioRepository;
    private final ProductoRepository productoRepository;
    private final DescuentoMapper descuentoMapper;
    private final MarcaMapper marcaMapper;
    private final CategoryMapper categoryMapper;
    private final ColorMapper colorMapper;

    public void saveProductUrl(Integer id, String url) {
        ProductoEntity producto = productoRepository.findById(id).orElse(null);

        if (producto == null)
            return;

        producto.setUrl(url);
        productoRepository.save(producto);
    }

    public List<CatalogoDTO> getCatalogo() {
        List<CatalogoDTO> catalogoDTOList = new ArrayList<>();
        List<ProductoEntity> productoEntityList = new ArrayList<>();

        // Filtramos solo los productos disponibles
        for (ProductoEntity producto : productoRepository.findAll()) {
            if (producto.isDisponible()) {
                productoEntityList.add(producto);
            }
        }

        // Obtenemos los atributos para el CatalogoDTO
        for (ProductoEntity producto : productoEntityList) {
            // Uso de los mappers
            MarcaDTO marcaDTO = marcaMapper.marcaToMarcaDTO(producto.getMarca());
            DescuentoDTO descuentoDTO = descuentoMapper.descuentoToDescuentoDTO(producto.getDescuento());
            ColorDTO colorDTO = colorMapper.colorToColorDTO(producto.getColor());
            CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(producto.getCategoria());

            // Obtener una lista de los registros del inventario pertenecientes a un producto
            List<InventarioEntity> inventarioEntityList = (List<InventarioEntity>) inventarioRepository.findByProducto(producto.getId());

            // Obtenemos una lista de las tallas con su cantidad y precio
            List<DetalleTallaDTO> detalleTallaDTOList = getDetalleTallaDTOS(inventarioEntityList);

            // Construimos el CatalogoDTO
            CatalogoDTO catalogoDTO = new CatalogoDTO(
                    producto.getId(),
                    producto.getNombre(),
                    producto.getDescripcion(),
                    descuentoDTO,
                    colorDTO,
                    marcaDTO,
                    categoryDTO,
                    producto.getUrl(),
                    detalleTallaDTOList
            );

            catalogoDTOList.add(catalogoDTO);
        }

        return catalogoDTOList;
    }

    // Obtener una lista de productos que tiene una lista de colores que este tiene una lista de tallas
    public List<ProductImageDTO> getAllProductImages() {
        List<ProductImageDTO> productImageDTOList = new ArrayList<>();
        List<ProductoEntity> productoEntityList = productList();

        // Cargar la lista de productos
        for (ProductoEntity producto : productoEntityList) {
            List<ColoresDTO> coloresDTOList = new ArrayList<>();
            List<ProductoEntity> auxProductList = (List<ProductoEntity>) productoRepository.finByNombre(producto.getNombre());

            // Cargar la lista de colores al DTO
            for (ProductoEntity auxProduct : auxProductList) {
                List<TallaEntity> tallaEntityList = (List<TallaEntity>) inventarioRepository.findByProductIdAllTallas(auxProduct.getId());
                ColoresDTO coloresDTO = getColoresDTO(auxProduct, tallaEntityList);
                coloresDTOList.add(coloresDTO);
            }

            ProductImageDTO productImageDTO = new ProductImageDTO();

            productImageDTO.setId(producto.getId());
            productImageDTO.setNombre(producto.getNombre());
            productImageDTO.setColores(coloresDTOList);

            productImageDTOList.add(productImageDTO);
        }

        return productImageDTOList;
    }

    private static ColoresDTO getColoresDTO(ProductoEntity auxProduct, List<TallaEntity> tallaEntityList) {
        List<TallaDTO> tallaDTOList = new ArrayList<>();

        // Cargar la lista de tallas al DTO
        for (TallaEntity talla : tallaEntityList) {
            TallaDTO tallaDTO = new TallaDTO(
                    talla.getId(), talla.getTalla()
            );
            tallaDTOList.add(tallaDTO);
        }

        ColoresDTO coloresDTO = new ColoresDTO();
        coloresDTO.setId(auxProduct.getColor().getId());
        coloresDTO.setNombre(auxProduct.getColor().getNombre());
        coloresDTO.setIdProducto(auxProduct.getId());
        coloresDTO.setUrl(auxProduct.getUrl());
        coloresDTO.setDisponible(auxProduct.isDisponible());
        coloresDTO.setTallas(tallaDTOList);
        return coloresDTO;
    }

    public List<ProductoEntity> productList() {
        List<ProductoEntity> listaCompleta = productoRepository.findAll();

        // Utilizamos LinkedHashSet para mantener el orden de inserción y eliminar duplicados por nombre
        Set<ProductoEntity> productosUnicos = new LinkedHashSet<>();

        for (ProductoEntity producto : listaCompleta) {
            // Agregamos el producto al conjunto de productos únicos si su nombre no está presente
            if (!existeNombreEnSet(productosUnicos, producto.getNombre())) {
                productosUnicos.add(producto);
            }
        }

        return new ArrayList<>(productosUnicos);
    }

    // Método para verificar si el nombre del producto ya existe en el conjunto de productos únicos
    private boolean existeNombreEnSet(Set<ProductoEntity> productosUnicos, String nombreProducto) {
        for (ProductoEntity producto : productosUnicos) {
            if (producto.getNombre().equals(nombreProducto)) {
                return true;
            }
        }
        return false;
    }

    public void productAvailability(Integer id, boolean disponible) {
        ProductoEntity producto = productoRepository.findById(id).orElse(null);

        if (producto == null) {
            return;
        }

        producto.setDisponible(disponible);
        productoRepository.save(producto);
    }

    private static List<DetalleTallaDTO> getDetalleTallaDTOS(List<InventarioEntity> inventarioEntityList) {
        List<DetalleTallaDTO> detalleTallaDTOList = new ArrayList<>();

        for (InventarioEntity inventario : inventarioEntityList) {
            if (inventario.getCantidad() > 0) {
                DetalleTallaDTO detalleTallaDTO = new DetalleTallaDTO(
                        inventario.getTalla().getId(),
                        inventario.getTalla().getTalla(),
                        inventario.getPrecio(),
                        inventario.getCantidad(),
                        inventario.getId()
                );

                detalleTallaDTOList.add(detalleTallaDTO);
            }
        }
        return detalleTallaDTOList;
    }

}
