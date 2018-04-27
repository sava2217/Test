package com.store.controller;

import com.store.entity.ClothesMaterial;
import com.store.filter.SimpleFilter;
import com.store.service.ClothesMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static  org.springframework.data.domain.PageRequest.of;

@Controller
@RequestMapping("/admin/clothesMaterial")
public class ClothesMaterialController {

    private final ClothesMaterialService clothesMaterialService;

    @Autowired
    public ClothesMaterialController(ClothesMaterialService clothesMaterialService) {
        this.clothesMaterialService = clothesMaterialService;
    }

    @ModelAttribute("filter")
    public SimpleFilter getFilter() {
        return new SimpleFilter();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model, @PageableDefault Pageable pageable, @RequestParam(defaultValue = "0") int page, @ModelAttribute("filter") SimpleFilter filter) {
        model.addAttribute("clothesMaterialList", clothesMaterialService.findAll(filter, of(page,4)));
        model.addAttribute("currentPage",page);
        return "/admin/clothesMaterialList";
    }

    @RequestMapping(value = {"/clothesMaterialEdit", "/clothesMaterialEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("clothesMaterial", clothesMaterialService.findById(id));
        } else {
            model.addAttribute("clothesMaterial", new ClothesMaterial());
        }
        return "/admin/clothesMaterialForm";
    }

    @RequestMapping(value = "/clothesMaterialEdit", method = RequestMethod.POST)
    public String saveForm(Model model, ClothesMaterial clothesMaterial) {
        clothesMaterialService.save(clothesMaterial);
        model.addAttribute("clothesMaterialList", clothesMaterialService.findAll());
        return "redirect:/admin/clothesMaterial";
    }

    @RequestMapping(value = "/clothesMaterialDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        clothesMaterialService.delete(id);
        model.addAttribute("clothesMaterialList", clothesMaterialService.findAll());
        return "redirect:/admin/clothesMaterial";
    }

}