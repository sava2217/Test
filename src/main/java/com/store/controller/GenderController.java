package com.store.controller;


import com.store.entity.Gender;
import com.store.service.GenderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GenderController {

    private final GenderService genderService;

    @Autowired
    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @RequestMapping(value = "/admin/gender",method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("genderList", genderService.findAll());
        return "/admin/genderList";
    }

    @RequestMapping(value = {"/admin/gender/genderEdit", "/admin/gender/genderEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("gender", genderService.findOne(id));
        } else {
            model.addAttribute("gender", new Gender());
        }
        return "/admin/genderForm";
    }

    @RequestMapping(value = "/admin/gender/genderEdit", method = RequestMethod.POST)
    public String saveForm(Model model, Gender gender) {
        genderService.save(gender);
        model.addAttribute("genderList", genderService.findAll());
        return "redirect:/admin/gender";
    }

    @RequestMapping(value = "/admin/gender/genderDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        genderService.delete(id);
        model.addAttribute("genderList", genderService.findAll());
        return "redirect:/admin/gender";
    }

}