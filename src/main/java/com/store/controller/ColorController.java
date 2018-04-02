package com.store.controller;


import com.store.entity.Color;
import com.store.service.ColorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ColorController {

    private final ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @RequestMapping(value = "/admin/color" ,method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("colorsList", colorService.findAll());
        return "/admin/colorList";
    }

    @RequestMapping(value = {"/admin/color/colorEdit", "/admin/color/colorEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("color", colorService.findOne(id));
        } else {
            model.addAttribute("color", new Color());
        }
        return "/admin/colorForm";
    }

    @RequestMapping(value = "/admin/color/colorEdit", method = RequestMethod.POST)
    public String saveForm(Model model, Color color) {
        colorService.save(color);
        model.addAttribute("colorList", colorService.findAll());
        return "redirect:/admin/color";
    }

    @RequestMapping(value = "/admin/color/colorDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        colorService.delete(id);
        model.addAttribute("colorList", colorService.findAll());
        return "redirect:/admin/color";
    }

}