package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.model.dto.ColorDTO;
import com.proyectosi1.apirest.service.ColorService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/color")
@RestController
public class ColorController {
    private final ColorService colorService;

    @PostMapping
    public ColorDTO createColor(@RequestBody ColorDTO color) {
        return colorService.createColor(color);
    }

    @PutMapping("/{id}")
    public ColorDTO updateColor(@PathVariable Integer id, @RequestBody ColorDTO color) {
        color.setId(id);
        return colorService.updateColor(color);
    }

    @DeleteMapping("/{id}")
    public void deleteColor(@PathVariable Integer id) {
        colorService.deleteColor(id);
    }

    @GetMapping("/{id}")
    public ColorDTO getColor(@PathVariable Integer id) {
        return colorService.getColor(id);
    }

    @GetMapping
    public List<ColorDTO> getAllColors() {
        return colorService.getAllColors();
    }

}
