package com.store.controller;

import com.store.entity.Brand;
import com.store.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/brand")
public class BrandController {
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;

    }

    @GetMapping()
    public Iterable<Brand> show() {
        return brandService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Brand> findBrand(@PathVariable Long id){
        return brandService.findOne(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBrand(@PathVariable Long id){
        brandService.delete(id);
    }

}
