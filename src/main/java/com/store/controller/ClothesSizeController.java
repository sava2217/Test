
package com.store.controller;


import com.store.entity.ClothesSize;
import com.store.service.ClothesSizeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClothesSizeController {

    private final ClothesSizeService clothesSizeService;

    @Autowired
    public ClothesSizeController(ClothesSizeService clothesSizeService) {
        this.clothesSizeService = clothesSizeService;
    }

    @RequestMapping(value = "/admin/clothesSize",method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("clothesSizeList", clothesSizeService.findAll());
        return "/admin/clothesSizeList";
    }

    @RequestMapping(value = {"/admin/clothesSize/clothesSizeEdit", "/admin/clothesSize/clothesSizeEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("clothesSize", clothesSizeService.findOne(id));
        } else {
            model.addAttribute("clothesSize", new ClothesSize());
        }
        return "/admin/cclothesSizeForm";
    }

    @RequestMapping(value = "/admin/clothesSize/clothesSizeEdit", method = RequestMethod.POST)
    public String saveForm(Model model, ClothesSize clothesSize) {
        clothesSizeService.save(clothesSize);
        model.addAttribute("clothesSizeList", clothesSizeService.findAll());
        return "redirect:/admin/clothesSize";
    }

    @RequestMapping(value = "/admin/clothesSize/clothesSizeDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        clothesSizeService.delete(id);
        model.addAttribute("clothesSizeList", clothesSizeService.findAll());
        return "redirect:/admin/clothesSize";
    }

}