package com.store.controller;

import com.store.service.AccessoriesService;
import com.store.service.BrandService;
import com.store.service.ColorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public  class  AccessoriesController{
    @Autowired
    BrandService brandService;
    @Autowired
    AccessoriesService accessoriesService;
    @Autowired
    ColorService colorService;

    @GetMapping("/templates/admin/accessories")
    public String greeting(Model model){
        model.addAttribute("acc", accessoriesService.findAll());
        return "accesories";
    }
}