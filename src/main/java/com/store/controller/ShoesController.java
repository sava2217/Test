package com.store.controller;

import com.store.entity.Shoes;
import com.store.filter.ShoesFilter;
import com.store.service.ShoesService;
import com.store.service.ColorService;
import com.store.service.ShoesMaterialService;
import com.store.service.ShoesSizeService;
import com.store.service.SeasonService;
import com.store.service.BrandService;
import com.store.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/admin/furniture")
public class ShoesController {

    private final ShoesService shoesService;

    private final ColorService colorService;
    private final BrandService brandService;
    private final GenderService genderService;
    private final SeasonService seasonService;
    private final ShoesMaterialService shoesMaterialService;
    private final ShoesSizeService shoesSizeService;

    public ShoesController(ShoesService shoesService, ColorService colorService, BrandService brandService, GenderService genderService, SeasonService seasonService, ShoesMaterialService shoesMaterialService, ShoesSizeService shoesSizeService) {
        this.shoesService = shoesService;
        this.colorService = colorService;
        this.brandService = brandService;
        this.genderService = genderService;
        this.seasonService = seasonService;
        this.shoesMaterialService = shoesMaterialService;
        this.shoesSizeService = shoesSizeService;
    }

    public ShoesService getShoesService() {
        return shoesService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ShoesFilter filter) {
        model.addAttribute("shoesList",  shoesService.findAll(pageable, filter));
        model.addAttribute("colorList", colorService.findAll());
        model.addAttribute("brandList", brandService.findAll());
        model.addAttribute("genderList", genderService.findAll());
        model.addAttribute("seasonList", seasonService.findAll());
        model.addAttribute("shoesMaterialList", shoesMaterialService.findAll());
        model.addAttribute("shoesSizeList", shoesSizeService.findAll());
        return "/admin/clothes/clothesList";
    }

    @RequestMapping(value = {"/shoesEdit", "/shoesEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        model.addAttribute("colorList", colorService.findAll());
        model.addAttribute("brandList", brandService.findAll());
        model.addAttribute("genderList", genderService.findAll());
        model.addAttribute("seasonList", seasonService.findAll());
        model.addAttribute("shoesMaterialList", shoesMaterialService.findAll());
        model.addAttribute("shoesSizeList", shoesSizeService.findAll());
        if (null != id) {
            model.addAttribute("shoes", shoesService.findOne(id));
        } else {
            model.addAttribute("shoes", new Shoes());
        }
        return "/admin/shoes/shoesForm";
    }

    @RequestMapping(value = "/shoesEdit", method = RequestMethod.POST)
    public String saveForm(Model model, Shoes shoes, @RequestParam("file") MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("/media/qui/94D69025D6900A1E1/IdeaProjects/Clothes Shop/pngFiles/" + file.getOriginalFilename());
            System.out.println(path);
            Files.write(path, bytes);
            shoes.setPath(String.valueOf(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        shoesService.save(shoes);
        model.addAttribute("shoesList", shoesService.findAll());
        return "redirect:/admin/shoes";
    }

    @RequestMapping(value = "/shoesDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        shoesService.delete(id);
        model.addAttribute("shoesList", shoesService.findAll());
        return "redirect:/admin/shoes";
    }

}