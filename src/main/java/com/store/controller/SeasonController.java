
import com.store.entity.Season;
import com.store.service.SeasonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SeasonController {

    private final SeasonService seasonService;

    @Autowired
    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @RequestMapping(value = "/admin/season",method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("seasonList", seasonService.findAll());
        return "/admin/seasonList";
    }

    @RequestMapping(value = {"/admin/season/seasonEdit", "/admin/season/seasonEdit/{id}"}, method = RequestMethod.GET)
    public String saveAndEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("season", seasonService.findOne(id));
        } else {
            model.addAttribute("season", new Season());
        }
        return "/admin/seasonForm";
    }

    @RequestMapping(value = "/admin/season/seasonEdit", method = RequestMethod.POST)
    public String saveForm(Model model, Season color) {
        seasonService.save(color);
        model.addAttribute("seasonList", seasonService.findAll());
        return "redirect:/admin/season";
    }

    @RequestMapping(value = "/admin/season/seasonDelete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(required = true, name = "id") Long id) {
        seasonService.delete(id);
        model.addAttribute("seasonList", seasonService.findAll());
        return "redirect:/admin/season";
    }

}