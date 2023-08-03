package com.example.ggwp.controllers.sideBar;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(path = "/side")
@SessionAttributes({"newComment", "subComment"})
public class SideBarController {

    @RequestMapping(path = "/home")
    public String homePage(HttpSession session)
    {
        if(session.getAttribute("loggedInUser") == null)
        {
            return "redirect:login";
        }

        return "home";
    }
}
