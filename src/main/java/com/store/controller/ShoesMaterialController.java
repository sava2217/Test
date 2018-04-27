package com.store.controller;

import com.store.entity.ShoesMaterial;
import com.store.filter.SimpleFilter;
import com.store.service.ShoesMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static  org.springframework.data.domain.PageRequest.of;

@Controller
@RequestMapping("/admin/shoesMaterial")
public class ShoesMaterialController {

    private final ShoesMaterialService shoesMaterialService;

    @Autowired
    public ShoesMaterialController(ShoesMaterialService shoesMaterialService) {
        this.shoesMaterialService = shoesMaterialService;
    }

    @ModelAttribute("filter")
    public SimpleFilter getFilter() {
        return new SimpleFilter();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model, @PageableDefault Pageable pageable, @RequestParam(defaultValue = "0") int page, @ModelAttribute("filter") SimpleFilter filter) {
        model.addAttribute("shoesMaterialList", shoesMaterialService.findAll(filter, of(page,4)));
        model.addAttribute("currentPage",page);
        return "/admin/shoesMaterialList";
    }

    @RequestMapping(value = {"/shoesMaterialEdit", "/shoesMaterialEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("shoesMaterial", shoesMaterialService.findById(id));
        } else {
            model.addAttribute("shoesMaterial", new ShoesMaterial());
        }
        return "/admin/shoesMaterialForm";
    }

    @RequestMapping(value = "/shoesMaterialEdit", method = RequestMethod.POST)
    public String saveForm(Model model, ShoesMaterial color) {
        shoesMaterialService.save(color);
        model.addAttribute("shoesMaterialList", shoesMaterialService.findAll());
        return "redirect:/admin/shoesMaterial";
    }

    @RequestMapping(value = "/shoesMaterialDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        shoesMaterialService.delete(id);
        model.addAttribute("shoesMaterialList", shoesMaterialService.findAll());
        return "redirect:/admin/shoesMaterial";
    }

}