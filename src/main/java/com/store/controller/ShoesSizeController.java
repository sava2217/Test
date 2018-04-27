package com.store.controller;

import com.store.entity.ShoesSize;
import com.store.filter.SimpleFilter;
import com.store.service.ShoesSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static  org.springframework.data.domain.PageRequest.of;

@Controller
@RequestMapping("/admin/shoesSize")
public class ShoesSizeController {

    private final ShoesSizeService shoesSizeService;

    @Autowired
    public ShoesSizeController(ShoesSizeService shoesSizeService) {
        this.shoesSizeService = shoesSizeService;
    }

    @ModelAttribute("filter")
    public SimpleFilter getFilter() {
        return new SimpleFilter();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model, @PageableDefault Pageable pageable, @RequestParam(defaultValue = "0") int page, @ModelAttribute("filter") SimpleFilter filter) {
        model.addAttribute("shoesSizeList", shoesSizeService.findAll(filter, of(page,4)));
        model.addAttribute("currentPage",page);
        return "/admin/shoesSizeList";
    }

    @RequestMapping(value = {"/shoesSizeEdit", "/shoesSizeEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("shoesSize", shoesSizeService.findById(id));
        } else {
            model.addAttribute("shoesSize", new ShoesSize());
        }
        return "/admin/shoesSizeForm";
    }

    @RequestMapping(value = "/shoesSizeEdit", method = RequestMethod.POST)
    public String saveForm(Model model, ShoesSize shoesSize) {
        shoesSizeService.save(shoesSize);
        model.addAttribute("shoesSizeList", shoesSizeService.findAll());
        return "redirect:/admin/shoesSize";
    }

    @RequestMapping(value = "/shoesSizeDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        shoesSizeService.delete(id);
        model.addAttribute("shoesSizeList", shoesSizeService.findAll());
        return "redirect:/admin/shoesSize";
    }

}