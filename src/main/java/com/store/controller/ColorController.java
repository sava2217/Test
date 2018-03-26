package com.store.controller;

import com.store.entity.Color;
import com.store.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/color")
public class ColorController {
    private final ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }


    @GetMapping()
    public Iterable<Color> show() {
        return colorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Color> findColor(@PathVariable Long id){
        return colorService.findOne(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteColor(@PathVariable Long id){
        colorService.delete(id);
    }
}
