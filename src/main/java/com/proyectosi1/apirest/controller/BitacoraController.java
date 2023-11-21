package com.proyectosi1.apirest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectosi1.apirest.model.entity.BitacoraEntity;
import com.proyectosi1.apirest.service.BitacoraService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bitacora")
public class BitacoraController {
    private final BitacoraService bitacoraService;

    public BitacoraEntity saveBitacora(@RequestBody BitacoraEntity bitacoraEntity){
        return bitacoraService.saveBitacora(bitacoraEntity);
    }

    @GetMapping
    public List<BitacoraEntity> getAllBitacora(){
        return bitacoraService.findAllBitacora();
    }

}
