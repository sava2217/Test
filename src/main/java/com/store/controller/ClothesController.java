package com.store.controller;

import com.store.entity.Clothes;
import com.store.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ClothesController {

    private final ClothesService clothesService;

    private final ColorService colorService;

    private final BrandService brandService;

    private final ClothesSizeService clothesSizeService;
    private final ClothesMaterialService clothesMaterialService;
    private final GenderService genderService;
    private final SeasonService seasonService;

    @Autowired
    public ClothesController(ClothesService clothesService, ColorService colorService, BrandService brandService, ClothesSizeService clothesSizeService, ClothesMaterialService clothesMaterialService, GenderService genderService, SeasonService seasonService) {
        this.clothesService = clothesService;
        this.colorService = colorService;
        this.brandService = brandService;
        this.clothesSizeService = clothesSizeService;
        this.clothesMaterialService = clothesMaterialService;
        this.genderService = genderService;
        this.seasonService = seasonService;
    }




    @RequestMapping(value = "/admin/clothes", method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("clothesList", clothesService.findAll());
        model.addAttribute("color", colorService.findAll());
        model.addAttribute("brand", brandService.findAll());
        model.addAttribute("clothesSize", clothesSizeService.findAll());
        model.addAttribute("clothesMaterial", clothesMaterialService.findAll());
        model.addAttribute("gender", genderService.findAll());
        model.addAttribute("season", seasonService.findAll());
        return "/admin/clothesList";
    }

    @RequestMapping(value = {"/admin/clothes/clothesEdit", "/admin/clothes/clothesEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        model.addAttribute("color", colorService.findAll());
        if (null != id) {
            model.addAttribute("clothes", clothesService.findOne(id));
        } else {
            model.addAttribute("clothes", new Clothes());
        }
        return "/admin/clothesForm";
    }

    @RequestMapping(value = "/admin/clothes/clothesEdit", method = RequestMethod.POST)
    public String saveForm(Model model, @Valid Clothes clothes, BindingResult bindingResult) {
        clothesService.save(clothes);
        model.addAttribute("clothesList", clothesService.findAll());
        return "redirect:/admin/clothes";
    }

    @RequestMapping(value = "/admin/clothes/clothesDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        clothesService.delete(id);
        model.addAttribute("clothesList", clothesService.findAll());
        return "redirect:/admin/clothes";
    }


}