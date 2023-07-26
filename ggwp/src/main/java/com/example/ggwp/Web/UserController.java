package com.example.ggwp.Web;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class UserController {
    @GetMapping(path = "/")
    public String InitialPage(Model model)
    {
        return "welcome";
    }

    @GetMapping(path = "/register")
    public String RegisterPage(Model model)
    {
        return "register";
    }

    @GetMapping(path = "/user")
    public String PersonalPage(Model model) {return "/personal_profile" ;}

    @GetMapping(path = "/tutor")
    public String TutorPage(Model model) {return "/tutor_profile" ;}

    @RequestMapping("/library")
    public String LibraryPage(){
        return "library";
    }

//    @GetMapping(path = "/home")
//    public String HomePage(Model model) { return "/home"; }
    @RequestMapping("/home")
    public String HomePage(){
        return "home";
    }

    @RequestMapping("/tutors")
    public String TutorsPage() { return "/tutors_page"; }

    @GetMapping(path = "/forum")
    public String ForumPage(){ return "forum"; }
}
