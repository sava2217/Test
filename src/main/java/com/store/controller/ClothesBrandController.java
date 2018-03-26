
package com.store.controller;

        import com.store.entity.ClothesBrand;
        import com.store.service.ClothesBrandService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.Optional;

@RestController
@RequestMapping("/ClothesBrand")
public class ClothesBrandController {
    private final ClothesBrandService clothesBrandService;

    @Autowired
    public ClothesBrandController(ClothesBrandService clothesBrandService) {
        this.clothesBrandService = clothesBrandService;

    }

    @GetMapping()
    public Iterable<ClothesBrand> show() {
        return clothesBrandService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ClothesBrand> findClothesBrand(@PathVariable Long id){
        return clothesBrandService.findOne(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClothesBrand(@PathVariable Long id){
        clothesBrandService.delete(id);
    }

}
