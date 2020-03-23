package ru.kpfu.springcontrollers.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.springcontrollers.model.User;
import ru.kpfu.springcontrollers.repo.UserRepo;

@Controller
@RequestMapping("/twig")
public class TwigController {

    @Autowired
    private UserRepo userRepository;

    @RequestMapping("/users")
    public String users(ModelMap map) {
        map.put("users", userRepository.findAll());
        return "twig/for";
    }
}