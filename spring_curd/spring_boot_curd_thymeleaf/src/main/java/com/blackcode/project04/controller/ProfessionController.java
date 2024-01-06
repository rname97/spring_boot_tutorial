package com.blackcode.project04.controller;

import com.blackcode.project04.entity.Profession;
import com.blackcode.project04.service.ProfessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profession")
public class ProfessionController {
    @Autowired
    private ProfessionServiceImpl professionServiceIml;

    @GetMapping
    public String viewProfessionData(Model model){
        model.addAttribute("allProfessionList", professionServiceIml.fetchProfessionList());
        return "ProfessionData";
    }

    @GetMapping("/viewAddProfession")
    public String viewAddProfession(Model model){
        Profession profession = new Profession();
        model.addAttribute("profession", profession);
        return "ProfessionAdd";
    }

    @PostMapping("/save")
    public String saveProfession(@ModelAttribute("profession") Profession profession){
        professionServiceIml.saveProfession(profession);
        return "redirect:/profession";
    }

    @GetMapping("/viewUpdateProfession/{id}")
    public String viewUpdateProfession(@PathVariable("id") Long id, Model model){
        Profession profession = professionServiceIml.getById(id);
        model.addAttribute("profession", profession);
        return "ProfessionEdit";
    }

    @GetMapping("/deleteProfession/{id}")
    public String deleteProfession(@PathVariable("id") Long id){
        professionServiceIml.deleteProfession(id);
        return "redirect:/profession";
    }
}
