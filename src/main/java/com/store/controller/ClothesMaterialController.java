package com.store.controller;


import com.store.entity.ClothesMaterial;
import com.store.service.ClothesMaterialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClothesMaterialController {

    private final ClothesMaterialService clothesMaterialService;

    @Autowired
    public ClothesMaterialController(ClothesMaterialService clothesMaterialService) {
        this.clothesMaterialService = clothesMaterialService;
    }

    @RequestMapping(value = "/admin/clothesMaterial",method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("clothesMaterialList", clothesMaterialService.findAll());
        return "/admin/clothesMaterialList";
    }

    @RequestMapping(value = {"/admin/clothesMaterial/clothesMaterialEdit", "/admin/clothesMaterial/clothesMaterialEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("clothesMaterial", clothesMaterialService.findOne(id));
        } else {
            model.addAttribute("clothesMaterial", new ClothesMaterial());
        }
        return "/admin/clothesMaterialForm";
    }

    @RequestMapping(value = "/admin/clothesMaterial/clothesMaterialEdit", method = RequestMethod.POST)
    public String saveForm(Model model, ClothesMaterial clothesMaterial) {
        clothesMaterialService.save(clothesMaterial);
        model.addAttribute("colorList",clothesMaterialService.findAll());
        return "redirect:/admin/clothesMaterial";
    }

    @RequestMapping(value = "/admin/clothesMaterial/clothesMaterialDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        clothesMaterialService.delete(id);
        model.addAttribute("clothesMaterialList", clothesMaterialService.findAll());
        return "redirect:/admin/clothesMaterial";
    }

}