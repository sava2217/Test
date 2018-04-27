package com.store.controller;

import com.store.entity.Clothes;
import com.store.filter.ClothesFilter;
import com.store.service.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/admin/clothes")
public class ClothesController {

    private final ClothesService clothesService;

    private final ColorService colorService;
    private final BrandService brandService;
    private final GenderService genderService;
    private final SeasonService seasonService;
    private final ClothesMaterialService clothesMaterialService;
    private final ClothesSizeService clothesSizeService;

    public ClothesController(ClothesService clothesService, ColorService colorService, BrandService brandService, GenderService genderService, SeasonService seasonService, ClothesMaterialService clothesMaterialService, ClothesSizeService clothesSizeService) {
        this.clothesService = clothesService;
        this.colorService = colorService;
        this.brandService = brandService;
        this.genderService = genderService;
        this.seasonService = seasonService;
        this.clothesMaterialService = clothesMaterialService;
        this.clothesSizeService = clothesSizeService;
    }

    public ClothesService getClothesService() {
        return clothesService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ClothesFilter filter) {
        model.addAttribute("clothesList", clothesService.findAll(pageable, filter));
        model.addAttribute("colorList", colorService.findAll());
        model.addAttribute("brandList", brandService.findAll());
        model.addAttribute("genderList", genderService.findAll());
        model.addAttribute("seasonList", seasonService.findAll());
        model.addAttribute("clothesMaterialList", clothesMaterialService.findAll());
        model.addAttribute("clothesSizeList", clothesSizeService.findAll());
        return "/admin/clothesList";
    }

    @RequestMapping(value = {"/clothesEdit", "/clothesEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {

        model.addAttribute("colorList", colorService.findAll());
        model.addAttribute("brandList", brandService.findAll());
        model.addAttribute("genderList", genderService.findAll());
        model.addAttribute("seasonList", seasonService.findAll());
        model.addAttribute("clothesMaterialList", clothesMaterialService.findAll());
        model.addAttribute("clothesSizeList", clothesSizeService.findAll());
        if (null != id) {
            model.addAttribute("clothes", clothesService.findOne(id));
        } else {
            model.addAttribute("clothes", new Clothes());
        }
        return "/admin/clothesForm";
    }

    @RequestMapping(value = "/clothesEdit", method = RequestMethod.POST)
    public String saveForm(Model model, Clothes clothes, @RequestParam("file") MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            /*"E:/java/spring-angular2-tasks-master/src/main/frontend/src/assets/images/products/"*/
            Path path = Paths.get("C:\\projekt\\WebProject-master\\pngFiles\\" + file.getOriginalFilename());
            System.out.println(path);
            Files.write(path, bytes);
            clothes.setPath(String.valueOf(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        clothesService.save(clothes);
        model.addAttribute("clothesList", clothesService.findAll());
        return "redirect:/admin/clothes";
    }

    @RequestMapping(value = "/clothesDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        clothesService.delete(id);
        model.addAttribute("clothesList", clothesService.findAll());
        return "redirect:/admin/clothes";
    }

}