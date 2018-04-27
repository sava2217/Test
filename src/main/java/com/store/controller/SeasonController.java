package com.store.controller;

import com.store.entity.Season;
import com.store.filter.SimpleFilter;
import com.store.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static  org.springframework.data.domain.PageRequest.of;

@Controller
@RequestMapping("/admin/season")
public class SeasonController {

    private final SeasonService seasonService;

    @Autowired
    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @ModelAttribute("filter")
    public SimpleFilter getFilter() {
        return new SimpleFilter();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model, @PageableDefault Pageable pageable, @RequestParam(defaultValue = "0") int page, @ModelAttribute("filter") SimpleFilter filter) {
        model.addAttribute("seasonList", seasonService.findAll(filter, of(page,4)));
        model.addAttribute("currentPage",page);
        return "/admin/seasonList";
    }

    @RequestMapping(value = {"/seasonEdit", "/seasonEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("season", seasonService.findById(id));
        } else {
            model.addAttribute("season", new Season());
        }
        return "/admin/seasonForm";
    }

    @RequestMapping(value = "/seasonEdit", method = RequestMethod.POST)
    public String saveForm(Model model, Season season) {
        seasonService.save(season);
        model.addAttribute("seasonList", seasonService.findAll());
        return "redirect:/admin/season";
    }

    @RequestMapping(value = "/seasonDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        seasonService.delete(id);
        model.addAttribute("seasonList", seasonService.findAll());
        return "redirect:/admin/season";
    }

}