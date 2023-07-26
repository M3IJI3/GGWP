package com.example.ggwp.controllers.admin;

import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.services.user.UsersBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UsersBusinessServiceInterface userBusinessService;

    @GetMapping("/")
    public String showAdminPage(Model model){
        List<UserModel> users = userBusinessService.getUsers();
        model.addAttribute("title", "User List");
        model.addAttribute("users", users);
        return "usersAdmin";
    }
}
