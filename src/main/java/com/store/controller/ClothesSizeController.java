package com.store.controller;

import com.store.entity.ClothesSize;
import com.store.filter.SimpleFilter;
import com.store.service.ClothesSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static  org.springframework.data.domain.PageRequest.of;
@Controller
@RequestMapping("/admin/clothesSize")
public class ClothesSizeController {

    private final ClothesSizeService clothesSizeService;

    @Autowired
    public ClothesSizeController(ClothesSizeService clothesSizeService) {
        this.clothesSizeService = clothesSizeService;
    }

    @ModelAttribute("filter")
    public SimpleFilter getFilter() {
        return new SimpleFilter();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model, @PageableDefault Pageable pageable, @RequestParam(defaultValue = "0") int page, @ModelAttribute("filter") SimpleFilter filter) {
        model.addAttribute("clothesSizeList", clothesSizeService.findAll(filter, of(page,4)));
        model.addAttribute("currentPage",page);
        return "/admin/clothesSizeList";
    }

    @RequestMapping(value = {"/clothesSizeEdit", "/clothesSizeEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("clothesSize", clothesSizeService.findById(id));
        } else {
            model.addAttribute("clothesSize", new ClothesSize());
        }
        return "/admin/clothesSizeForm";
    }

    @RequestMapping(value = "/clothesSizeEdit", method = RequestMethod.POST)
    public String saveForm(Model model, ClothesSize clothesSize) {
        clothesSizeService.save(clothesSize);
        model.addAttribute("clothesSizeList", clothesSizeService.findAll());
        return "redirect:/admin/clothesSize";
    }

    @RequestMapping(value = "/clothesSizeDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        clothesSizeService.delete(id);
        model.addAttribute("clothesSizeList", clothesSizeService.findAll());
        return "redirect:/admin/clothesSize";
    }

}