
package com.store.controller;

        import com.store.service.ClothesService;
        import com.store.service.BrandService;
        import com.store.service.ColorService;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.servlet.ModelAndView;

@Controller

public  class  ClothesController{
    @Autowired
    BrandService brandService;
    @Autowired
    ClothesService сlothesService;
    @Autowired
    ColorService colorService;

    @GetMapping("/admin/Clothes")
    public String greeting(Model model){
        model.addAttribute("acc", сlothesService.findAll());
        return "Clothes";
    }
}