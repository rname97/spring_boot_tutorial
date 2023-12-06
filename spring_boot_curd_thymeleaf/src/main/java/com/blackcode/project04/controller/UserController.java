package com.blackcode.project04.controller;

import com.blackcode.project04.entity.User;
import com.blackcode.project04.repository.UserRepository;
import com.blackcode.project04.service.HobieServiceImpl;
import com.blackcode.project04.service.ProfessionServiceImpl;
import com.blackcode.project04.service.UserService;
import com.blackcode.project04.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserService userService;
    @Autowired
    private HobieServiceImpl hobieServiceImpl;

    @Autowired
    private ProfessionServiceImpl professionServiceImpl;

    @GetMapping
    public String viewUserData(Model model){
        List<User> listUser = userServiceImpl.fetchUserList();
        model.addAttribute("allUserList", listUser);
        return "UserData";
    }

    @GetMapping("/test")
    public String viewUserDatax(Model model){
        List<User> listUser = userService.fetchUserList();
        model.addAttribute("allUserList", listUser);
        return "UserData";
    }

    @GetMapping("/viewAddUser")
    public String viewUserAdd(Model model){
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("allHobieList", hobieServiceImpl.fetchHobieList());
        model.addAttribute("allProfessionList", professionServiceImpl.fetchProfessionList());
        return "UserAdd";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user){
        userServiceImpl.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/viewUpdateUser/{id}")
    public String viewUserUpdate(@PathVariable(value = "id") long id, Model model){
        User user = userServiceImpl.getById(id);
        model.addAttribute("user",user);
        model.addAttribute("allHobieList", hobieServiceImpl.fetchHobieList());
        model.addAttribute("allProfessionList", professionServiceImpl.fetchProfessionList());
        return "UserEdit";

    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id){
        userServiceImpl.deleteUserById(id);
        return "redirect:/user";
    }

}
