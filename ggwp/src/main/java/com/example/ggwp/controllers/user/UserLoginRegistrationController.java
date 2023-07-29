package com.example.ggwp.controllers.user;

import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.services.user.UserLoginRegistrationServiceInterface;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/")
public class UserLoginRegistrationController {

    @Resource
    UserLoginRegistrationServiceInterface loginRegService;

    @GetMapping(path = "login")
    public String showLoginPage(Model model)
    {
        model.addAttribute("UserModel", new UserModel());
        return "welcome";
    }

    @PostMapping(path = "/")
    public String loginValidation(Model model ,UserModel userModel){
        List<UserModel> users = loginRegService.getUsers();

        boolean result = loginRegService.LoginCheck(userModel.getEmail(),
                userModel.getPassword(), users);



        if(result)
        {
            return "home";
        }
        else {
            model.addAttribute("info", "Username or password is incorrect!");
            model.addAttribute("UserModel", new UserModel());
            return "welcome";
        }
    }

    @GetMapping(path = "register")
    public String showRegisterPage(Model model)
    {
        return "register";
    }
}
