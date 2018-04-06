package com.store.controller;


import com.store.entity.Brand;
import com.store.service.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @RequestMapping(value = "/admin/brand",method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("brandList", brandService.findAll());
        return "/admin/brandList";
    }

    @RequestMapping(value = {"/admin/brand/brandEdit", "/admin/brand/brandEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("brand", brandService.findOne(id));
        } else {
            model.addAttribute("brand", new Brand());
        }
        return "/admin/brandForm";
    }

    @RequestMapping(value = "/admin/brand/brandEdit", method = RequestMethod.POST)
    public String saveForm(Model model, Brand brand) {
        brandService.save(brand);
        model.addAttribute("brandList", brandService.findAll());
        return "redirect:/admin/brand";
    }

    @RequestMapping(value = "/admin/brand/brandDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        brandService.delete(id);
        model.addAttribute("brandList", brandService.findAll());
        return "redirect:/admin/brand";
    }

}