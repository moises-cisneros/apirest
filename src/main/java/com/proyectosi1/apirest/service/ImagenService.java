package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.dto.*;
import com.proyectosi1.apirest.model.entity.*;
import com.proyectosi1.apirest.model.repository.ImagenRepository;
import com.proyectosi1.apirest.model.repository.InventarioRepository;
import com.proyectosi1.apirest.model.repository.ProductoRepository;
import com.proyectosi1.apirest.model.repository.TallaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImagenService {

    private final ImagenRepository imagenRepository;
    private final InventarioRepository inventarioRepository;
    private final ProductoRepository productoRepository;
    private final TallaRepository tallaRepository;

    public ImagenEntity createImagen(ImagenEntity imagen) {
        return imagenRepository.save(imagen);
    }

    public ImagenEntity updateImagen(ImagenEntity imagen) {
        return imagenRepository.save(imagen);
    }

    public void deleteImagen(Integer id) {
        imagenRepository.deleteById(id);
    }

    public ImagenEntity getImagen(Integer id) {
        return imagenRepository.findById(id).orElse(null);
    }

    public List<ImagenEntity> getAllImages() {
        return imagenRepository.findAll();
    }

    public ImagenDTO editImageUrl(Integer idInventario) {
        ImagenDTO imagenDTO = new ImagenDTO();
        List<ImagenEntity> imagenes = imagenRepository.findByInventarioId(idInventario);

        if (!imagenes.isEmpty()) {
            ImagenEntity imagen = imagenes.get(0); // Puedes obtener la primera imagen de la lista
            imagenDTO.setId(imagen.getId());
            imagenDTO.setUrl(imagen.getUrl());
            imagenDTO.setIdInventario(imagen.getInventario().getId());
        }

        return imagenDTO;
    }


    public List<CatalogoDTO> getCatalogo() {
        List<CatalogoDTO> catalogoDTOList = new ArrayList<>();
        List<InventarioEntity> inventarioEntityList = inventarioRepository.findAll();

        for (InventarioEntity inventario : inventarioEntityList) {
            CatalogoDTO catalogoDTO = new CatalogoDTO();

            // Obteniendo la imagen para el inventario actual
            ImagenDTO imagenDTO = editImageUrl(inventario.getId());

            // Verificando si la imagen es válida antes de agregar el producto al catálogo
            if (imagenDTO != null && imagenDTO.getId() != null && imagenDTO.getUrl() != null) {
                catalogoDTO.setId(imagenDTO.getId());
                catalogoDTO.setUrl(imagenDTO.getUrl());

                // Obteniendo el nombre del producto del inventario actual
                String nombreProducto = inventario.getProducto().getNombre();
                catalogoDTO.setNombreProducto(nombreProducto);

                catalogoDTO.setPrecio(inventario.getPrecio());
                catalogoDTO.setStock(inventario.getCantidad());

                catalogoDTOList.add(catalogoDTO);
            }
        }

        return catalogoDTOList;
    }

    public Set<String> getProductNames() {
        return productoRepository.findAll().stream()
                .map(ProductoEntity::getNombre)
                .collect(Collectors.toSet());
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

    public List<TallaEntity> prueba1(Integer idProducto) {
        return (List<TallaEntity>) inventarioRepository.findByProductIdAllTallas(idProducto);
    }
    public List<ColorEntity> prueba2(String name) {
        return (List<ColorEntity>) productoRepository.findByNameProductAllColors(name);
    }

}
