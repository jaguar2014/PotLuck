package com.ashu.demo.controller;

import com.ashu.demo.model.AppUser;
import com.ashu.demo.model.PotLuck;
import com.ashu.demo.repository.AppRoleRepository;
import com.ashu.demo.repository.AppUserRepository;
import com.ashu.demo.repository.PotLuckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    AppRoleRepository roleRepository;

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    PotLuckRepository potLuckRepository;

    @GetMapping("/")
    public String showIndex(Model model,Authentication auth) {

        Iterable<PotLuck> potLucks  = potLuckRepository.findAll();
        model.addAttribute("newPots", potLucks);
        return "index";

    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String registerUser(Model model)
    {
        model.addAttribute("newuser",new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@Valid @ModelAttribute("newuser") AppUser user, BindingResult result, HttpServletRequest request)
    {
        if(result.hasErrors())
        {
            return "register";
        }


        user.addRole(roleRepository.findAppRoleByRoleName("USER"));
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/addpotluck")
    private String addPotluck(Model model){

        model.addAttribute("potluck", new PotLuck());

        return "potluckform";
    }

    @PostMapping("/addpotluck")
    public String addPotLuckInfo(@Valid @ModelAttribute("potluck") PotLuck potLuck, Model model,BindingResult result, Authentication auth) {
        if (result.hasErrors()) {
            return "potluckform";
        }
       AppUser appUser=  userRepository.findAppUserByUsername(auth.getName());
       potLuck.addAppUser(appUser);

       potLuckRepository.save(potLuck);




        return "redirect:/listpotluck";
    }

    @GetMapping("/listpotluck")
    public String showPotLuckInfo(Model model,Authentication auth) {

        AppUser appUser=  userRepository.findAppUserByUsername(auth.getName());

        List<PotLuck> potLucks = potLuckRepository.findByAppUsers(appUser);
       // List<PotLuck> potLucks  = potLuckRepository.findPotLucksByAppUsersIn(Arrays.asList(appUser));
        model.addAttribute("newPots", potLucks);
        return "listpotluckform";
    }
    @GetMapping("/editpotluck/{id}")
    public String editPotluck(@PathVariable("id") long id, Model model,Authentication auth){
        PotLuck potLuck = potLuckRepository.findOne(id);
        model.addAttribute("potluck", potLuck);

        return "potluckform";


    }
}
