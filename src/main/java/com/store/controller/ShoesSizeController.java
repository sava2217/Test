package com.store.controller;


import com.store.entity.ShoesSize;
import com.store.service.ShoesSizeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoesSizeController {

    private final ShoesSizeService shoesSizeService;

    @Autowired
    public ShoesSizeController(ShoesSizeService shoesSizeService) {
        this.shoesSizeService = shoesSizeService;
    }

    @RequestMapping(value = "/admin/shoesSize", method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("shoesSizeList", shoesSizeService.findAll());
        return "/admin/shoesSizeList";
    }

    @RequestMapping(value = {"/admin/shoesSize/shoesSizeEdit", "/admin/shoesSize/shoesSizeEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("shoesSize", shoesSizeService.findOne(id));
        } else {
            model.addAttribute("shoesSize", new ShoesSize());
        }
        return "/admin/shoesSizeForm";
    }

    @RequestMapping(value = "/admin/shoesSize/shoesSizeEdit", method = RequestMethod.POST)
    public String saveForm(Model model, ShoesSize shoesSize) {
        shoesSizeService.save(shoesSize);
        model.addAttribute("shoesSizeList",shoesSizeService.findAll());
        return "redirect:/admin/shoesSize";
    }

    @RequestMapping(value = "/admin/shoesSize/shoesSizeDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        shoesSizeService.delete(id);
        model.addAttribute("shoesSizeList", shoesSizeService.findAll());
        return "redirect:/admin/shoesSize";
    }

}