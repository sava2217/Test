package com.store.controller;

import com.store.filter.ClothesFilter;
import com.store.filter.ShoesFilter;
import com.store.service.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class UserController {

    private final ClothesService clothesService;

    private final ShoesService shoesService;

    private final ColorService colorService;
    private final BrandService brandService;
    private final GenderService genderService;
    private final SeasonService seasonService;
    private final ClothesMaterialService clothesMaterialService;
    private final ClothesSizeService clothesSizeService;
    private final ShoesMaterialService shoesMaterialService;
    private final ShoesSizeService shoesSizeService;


    public UserController(ClothesService clothesService, ShoesService shoesService, ColorService colorService, BrandService brandService, GenderService genderService, SeasonService seasonService, ClothesMaterialService clothesMaterialService, ClothesSizeService clothesSizeService, ShoesMaterialService shoesMaterialService, ShoesSizeService shoesSizeService) {
        this.clothesService = clothesService;
        this.shoesService = shoesService;
        this.colorService = colorService;
        this.brandService = brandService;
        this.genderService = genderService;
        this.seasonService = seasonService;
        this.clothesMaterialService = clothesMaterialService;
        this.clothesSizeService = clothesSizeService;
        this.shoesMaterialService = shoesMaterialService;
        this.shoesSizeService = shoesSizeService;
    }


    @ModelAttribute("filter")
    public ClothesFilter getFilter() {
        return new ClothesFilter();
    }

    /*@ModelAttribute("filter")
    public ShoesFilter getSFilter() {
        return new ShoesFilter();
    }
*/
    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ClothesFilter filter) {
        model.addAttribute("clothesList", clothesService.findAll(pageable, filter));
        model.addAttribute("colorList", colorService.findAll());
        model.addAttribute("brandList", brandService.findAll());
        model.addAttribute("genderList", genderService.findAll());
        model.addAttribute("seasonList", seasonService.findAll());
        model.addAttribute("clothesMaterialList", clothesMaterialService.findAll());
        model.addAttribute("clothesSizeList", clothesSizeService.findAll());
        return "../resources/templates/home";
    }

   /* @RequestMapping(method = RequestMethod.GET)
    public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ShoesFilter filter) {
        model.addAttribute("clothesList", clothesService.findAll(pageable, filter));
        model.addAttribute("colorList", colorService.findAll());
        model.addAttribute("brandList", brandService.findAll());
        model.addAttribute("genderList", genderService.findAll());
        model.addAttribute("seasonList", seasonService.findAll());
        model.addAttribute("shoesMaterialList", shoesMaterialService.findAll());
        model.addAttribute("shoesSizeList", shoesSizeService.findAll());
        return "/home";
    }*/


}