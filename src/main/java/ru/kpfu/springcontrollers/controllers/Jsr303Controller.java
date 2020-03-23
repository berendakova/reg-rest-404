package ru.kpfu.springcontrollers.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.springcontrollers.model.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/jsr303")
public class Jsr303Controller {

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String jsr303Handler(
            RedirectAttributes redirectAttributes,
            @Valid @ModelAttribute("user") User user,
            BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            System.out.println(user.toString());
            redirectAttributes.addFlashAttribute("message", "Hello, " + user.getEmail());
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("JC#addUser").build();
        }
    }

    @RequestMapping(value = "add-user", method = RequestMethod.GET)
    public String addUser(ModelMap map) {
        map.put("user", new User());
        return "reg";
    }

    @RequestMapping(value = "/error")
    public String get(ModelMap map){
        map.put("a",1);
        return "error: 404";
    }
}
