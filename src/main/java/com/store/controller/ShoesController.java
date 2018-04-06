package com.store.controller;

import com.store.entity.Shoes;
import com.store.service.ShoesService;
import com.store.service.ColorService;
import com.store.service.ShoesMaterialService;
import com.store.service.ShoesSizeService;
import com.store.service.SeasonService;
import com.store.service.BrandService;
import com.store.service.GenderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoesController {

    private final ShoesService shoesService;

    private final ColorService colorService;

    private final ShoesMaterialService shoesMaterialService;

    private final ShoesSizeService shoesSizeService;

    private final SeasonService seasonService;

    private final BrandService brandService;

    private final GenderService genderService;


    @Autowired
    public ShoesController(ShoesService shoesService, ColorService colorService,ShoesMaterialService shoesMaterialService,ShoesSizeService shoesSizeService,SeasonService seasonService,BrandService brandService,GenderService genderService) {
        this.shoesService = shoesService;
        this.colorService = colorService;
        this.shoesMaterialService = shoesMaterialService;
        this.shoesSizeService = shoesSizeService;
        this.seasonService = seasonService;
        this.brandService = brandService;
        this.genderService = genderService;

    }

    @RequestMapping(value = "/admin/shoes", method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("clothesList", shoesService.findAll());
        model.addAttribute("color", colorService.findAll());
        return "/admin/shoesList";
    }

    @RequestMapping(value = {"/admin/shoes/shoesEdit", "/admin/shoes/shoesEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        model.addAttribute("color", colorService.findAll());
        if (null != id) {
            model.addAttribute("shoes", shoesService.findOne(id));
        } else {
            model.addAttribute("shoes", new Shoes());
        }
        return "/admin/shoesForm";
    }

    @RequestMapping(value = "/admin/shoes/shoesEdit", method = RequestMethod.POST)
    public String saveForm(Model model, Shoes shoes) {
        shoesService.save(shoes);
        model.addAttribute("shoesList", shoesService.findAll());
        return "redirect:/admin/shoes";
    }

    @RequestMapping(value = "/admin/shoes/shoesDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        shoesService.delete(id);
        model.addAttribute("shoesList", shoesService.findAll());
        return "redirect:/admin/shoes";
    }


}