package com.store.controller;

import com.store.entity.ClothesMaterial;
import com.store.service.ClothesMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ClothesMaterial")
public class ClothesMaterialController {
    private final ClothesMaterialService clothesMaterialService;

    @Autowired
    public ClothesMaterialController(ClothesMaterialService clothesMaterialService) {
        this.clothesMaterialService = clothesMaterialService;

    }

    @GetMapping()
    public Iterable<ClothesMaterial> show() {
        return clothesMaterialService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ClothesMaterial> findBrand(@PathVariable Long id){
        return clothesMaterialService.findOne(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClothesMaterial(@PathVariable Long id){
        clothesMaterialService.delete(id);
    }

}