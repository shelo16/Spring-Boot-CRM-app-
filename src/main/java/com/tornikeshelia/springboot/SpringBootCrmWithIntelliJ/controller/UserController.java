package com.tornikeshelia.springboot.SpringBootCrmWithIntelliJ.controller;

import com.tornikeshelia.springboot.SpringBootCrmWithIntelliJ.entity.User;
import com.tornikeshelia.springboot.SpringBootCrmWithIntelliJ.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("userList", userRepository.findAll());
        return "list-page";
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("myUser", user);
        return "form-page";
    }

    @PostMapping("/postAddUser")
    public String postAddUser(@ModelAttribute("myUser")User user){
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser/{id}")
    public String editUser(Model model,@PathVariable(name = "id")String id){
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("editUser",user);
        return "user-update-form";
    }

    @PostMapping("/postUpdateUser")
    public String postEditUser(@ModelAttribute("editUser")User user){
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id")String id){
        userRepository.deleteById(id);
        return "redirect:/";
    }





}
