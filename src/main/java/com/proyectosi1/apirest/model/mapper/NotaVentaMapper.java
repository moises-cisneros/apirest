package com.proyectosi1.apirest.model.mapper;

import com.proyectosi1.apirest.model.dto.NotaVentaDTO;
import com.proyectosi1.apirest.model.entity.NotaVentaEntity;
import com.proyectosi1.apirest.model.repository.NotaVentaRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class NotaVentaMapper {

    @Autowired
    private NotaVentaRepository notaVentaRepository;


    public List<NotaVentaDTO> getAllSalesNote() {
        List<NotaVentaDTO> notaVentaDTOList = new ArrayList<>();
        List<NotaVentaEntity> ventaEntityList = notaVentaRepository.findAll();

        for (NotaVentaEntity notaVenta : ventaEntityList) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            NotaVentaDTO notaVentaDTO = new NotaVentaDTO(
                    notaVenta.getId(),
                    notaVenta.getEstado(),
                    notaVenta.getUser().getName(),
                    dateFormat.format(notaVenta.getFecha()),
                    notaVenta.getMonto()
            );

            notaVentaDTOList.add(notaVentaDTO);
        }

        return notaVentaDTOList;
    }

}
