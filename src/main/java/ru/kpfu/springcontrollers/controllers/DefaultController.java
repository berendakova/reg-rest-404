package ru.kpfu.springcontrollers.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import ru.kpfu.springcontrollers.model.Form;
import ru.kpfu.springcontrollers.model.User;
import ru.kpfu.springcontrollers.repo.UserRepo;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping("/default")

public class DefaultController  {


    @Autowired
    private UserRepo userRepository;



    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationHandler(RedirectAttributes redirectAttributes,
                                      @Valid @ModelAttribute("registrationForm") Form registrationForm,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reg";
        } else {
            User user = new User();
            user.setEmail(registrationForm.getEmail());
            user.setPassword(DigestUtils.md5Hex(registrationForm.getPassword()));
            user.setPasswordConfirm(DigestUtils.md5Hex(registrationForm.getConfirmPassword()));
            user.setCountry(registrationForm.getCountry());
            user.setGender(registrationForm.getGender());
            user.setBirthday(registrationForm.getBirthday());

            try {
                userRepository.save(user);
            } catch (DataIntegrityViolationException d) {
                redirectAttributes.addFlashAttribute("message", "User exist");
                return "redirect:" + MvcUriComponentsBuilder.fromMappingName("DC#registration").build();
            }

            redirectAttributes.addFlashAttribute("message", "Hello,  " + registrationForm.getEmail());
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("DC#registration").build();
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(ModelMap map) {
        map.put("form", new Form());
        return "reg";
    }


    @RequestMapping(value = "/users")
    @ResponseBody
    public String list(ModelMap map) {
        map.put("users", userRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "/error")
    public String get(ModelMap map){
        map.put("a",userRepository.findAll());
        return "error: 404";
    }


}
