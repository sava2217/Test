package com.store.controller;

import com.store.entity.Brand;
import com.store.filter.SimpleFilter;
import com.store.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static  org.springframework.data.domain.PageRequest.of;

@Controller
@RequestMapping("/admin/brand")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @ModelAttribute("filter")
    public SimpleFilter getFilter() {
        return new SimpleFilter();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model, @PageableDefault Pageable pageable, @RequestParam(defaultValue = "0") int page, @ModelAttribute("filter") SimpleFilter filter) {
        model.addAttribute("brandList", brandService.findAll(filter, of(page,4)));
        model.addAttribute("currentPage",page);
        return "/admin/brandList";
    }

    @RequestMapping(value = {"/brandEdit", "/brandEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("brand", brandService.findById(id));
        } else {
            model.addAttribute("brand", new Brand());
        }
        return "/admin/brandForm";
    }

    @RequestMapping(value = "/brandEdit", method = RequestMethod.POST)
    public String saveForm(Model model, Brand brand) {
        brandService.save(brand);
        model.addAttribute("brandList", brandService.findAll());
        return "redirect:/admin/brand";
    }

    @RequestMapping(value = "/brandDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        brandService.delete(id);
        model.addAttribute("brandList", brandService.findAll());
        return "redirect:/admin/brand";
    }

}