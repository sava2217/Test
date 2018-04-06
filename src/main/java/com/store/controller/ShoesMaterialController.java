package com.store.controller;


import com.store.entity.ShoesMaterial;
import com.store.service.ShoesMaterialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoesMaterialController {

    private final ShoesMaterialService shoesMaterialService;

    @Autowired
    public ShoesMaterialController(ShoesMaterialService shoesMaterialService) {
        this.shoesMaterialService = shoesMaterialService;
    }

    @RequestMapping(value = "/admin/shoesMaterial",method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("shoesMaterialsList", shoesMaterialService.findAll());
        return "/admin/shoesMaterialList";
    }

    @RequestMapping(value = {"/admin/shoesMaterial/shoesMaterialEdit", "/admin/shoesMaterial/shoesMaterialEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("shoesMaterial", shoesMaterialService.findOne(id));
        } else {
            model.addAttribute("shoesMaterial", new ShoesMaterial());
        }
        return "/admin/shoesMaterialForm";
    }

    @RequestMapping(value = "/admin/shoesMaterial/shoesMaterialEdit", method = RequestMethod.POST)
    public String saveForm(Model model, ShoesMaterial shoesMaterial) {
        shoesMaterialService.save(shoesMaterial);
        model.addAttribute("shoesMaterialList", shoesMaterialService.findAll());
        return "redirect:/admin/shoesMaterial";
    }

    @RequestMapping(value = "/admin/shoesMaterial/shoesMaterialDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        shoesMaterialService.delete(id);
        model.addAttribute("shoesMaterialList", shoesMaterialService.findAll());
        return "redirect:/admin/shoesMaterial";
    }

}