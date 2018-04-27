package com.store.controller;

import com.store.entity.Gender;
import com.store.filter.SimpleFilter;
import com.store.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static  org.springframework.data.domain.PageRequest.of;

@Controller
@RequestMapping("/admin/gender")
public class GenderController {

    private final GenderService genderService;

    @Autowired
    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @ModelAttribute("filter")
    public SimpleFilter getFilter() {
        return new SimpleFilter();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model, @PageableDefault Pageable pageable, @RequestParam(defaultValue = "0") int page, @ModelAttribute("filter") SimpleFilter filter) {
        model.addAttribute("genderList", genderService.findAll(filter, of(page,4)));
        model.addAttribute("currentPage",page);
        return "/admin/genderList";
    }

    @RequestMapping(value = {"/genderEdit", "/genderEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("gender", genderService.findById(id));
        } else {
            model.addAttribute("gender", new Gender());
        }
        return "/admin/genderForm";
    }

    @RequestMapping(value = "/genderEdit", method = RequestMethod.POST)
    public String saveForm(Model model, Gender gender) {
        genderService.save(gender);
        model.addAttribute("genderList", genderService.findAll());
        return "redirect:/admin/gender";
    }

    @RequestMapping(value = "/genderDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        genderService.delete(id);
        model.addAttribute("genderList", genderService.findAll());
        return "redirect:/admin/gender";
    }

}