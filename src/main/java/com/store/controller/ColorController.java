package com.store.controller;

import com.store.entity.Color;
import com.store.filter.SimpleFilter;
import com.store.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static  org.springframework.data.domain.PageRequest.of;

@Controller
@RequestMapping("/admin/color")
public class ColorController {

    private final ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @ModelAttribute("filter")
    public SimpleFilter getFilter() {
        return new SimpleFilter();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model, @PageableDefault Pageable pageable, @RequestParam(defaultValue = "0") int page, @ModelAttribute("filter") SimpleFilter filter) {
        model.addAttribute("colorList", colorService.findAll(filter, of(page,4)));
        model.addAttribute("currentPage",page);
        return "/admin/colorList";
    }

    @RequestMapping(value = {"/colorEdit", "/colorEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("color", colorService.findById(id));
        } else {
            model.addAttribute("color", new Color());
        }
        return "/admin/colorForm";
    }

    @RequestMapping(value = "/colorEdit", method = RequestMethod.POST)
    public String saveForm(Model model, Color color) {
        colorService.save(color);
        model.addAttribute("colorList", colorService.findAll());
        return "redirect:/admin/color";
    }

    @RequestMapping(value = "/colorDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        colorService.delete(id);
        model.addAttribute("colorList", colorService.findAll());
        return "redirect:/admin/color";
    }

}