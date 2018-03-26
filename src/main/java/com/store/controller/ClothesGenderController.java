 package com.store.controller;

import com.store.entity.ClothesGender;
import com.store.service.ClothesGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ClothesGender")
public class ClothesGenderController {
    private final ClothesGenderService clothesGenderService;

    @Autowired
    public ClothesGenderController(ClothesGenderService clothesGenderService) {
        this.clothesGenderService = clothesGenderService;

    }

    @GetMapping()
    public Iterable<ClothesGender> show() {
        return clothesGenderService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ClothesGender> findClothesGender(@PathVariable Long id){
        return clothesGenderService.findOne(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClothesGender(@PathVariable Long id){
        clothesGenderService.delete(id);
    }

}

