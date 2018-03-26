
        package com.store.controller;

import com.store.entity.ClothesSize;
import com.store.service.ClothesSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/brand")
public class ClothesSizeController {
    private final ClothesSizeService clothesSizeService;

    @Autowired
    public ClothesSizeController(ClothesSizeService brandService) {
        this.clothesSizeService = brandService;

    }

    @GetMapping()
    public Iterable<ClothesSize> show() {
        return clothesSizeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ClothesSize> findClothesSize(@PathVariable Long id){
        return clothesSizeService.findOne(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClothesSize(@PathVariable Long id){
        clothesSizeService.delete(id);
    }

}
