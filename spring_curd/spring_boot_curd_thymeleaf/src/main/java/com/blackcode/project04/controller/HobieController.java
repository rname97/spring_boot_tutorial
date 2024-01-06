package com.blackcode.project04.controller;

import com.blackcode.project04.entity.Hobie;
import com.blackcode.project04.service.HobieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hobie")
public class HobieController {

    @Autowired
    private HobieServiceImpl hobieService;

    @GetMapping
    public String viewHobieData(Model model){
        model.addAttribute("allHobieList", hobieService.fetchHobieList());
        return "HobieData";
    }

    @GetMapping("/viewAddHobie")
    public String viewAddHobie(Model model){
        Hobie hobie = new Hobie();
        model.addAttribute("hobie", hobie);
        return "HobieAdd";
    }

    @PostMapping("/save")
    public String saveHobie(@ModelAttribute("hobie") Hobie hobie){
        hobieService.saveHobie(hobie);
        return "redirect:/hobie";
    }

    @GetMapping("/viewUpdateHobie/{id}")
    public String viewUpdateHobie(@PathVariable(value = "id") long id, Model model){
        Hobie hobie = hobieService.getById(id);
        model.addAttribute("hobie", hobie);
        return "HobieEdit";
    }

    @GetMapping("/deleteHobie/{id}")
    public String deleteHobie(@PathVariable(value = "id") long id){
        hobieService.deleteHobie(id);
        return "redirect:/hobie";
    }
}
