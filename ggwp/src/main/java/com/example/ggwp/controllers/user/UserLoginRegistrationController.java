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
        model.addAttribute("NewRegUser", new UserModel());
        return "register";
    }

    @PostMapping(path = "process")
    public String submitRegistration(Model model, UserModel userModel)
    {
        List<UserModel> users = loginRegService.getUsers();

        // initialize some attributes in UserModel
        userModel.setPaymentType("none");
        userModel.setRole("user");
        userModel.setSubscription("regular");

        boolean emailCheck = loginRegService.DuplicatedEmailCheck(userModel.getEmail(), users);
        boolean usernameCheck = loginRegService.DuplicatedUsernameCheck(userModel.getUserName(), users);

        if(!emailCheck && !usernameCheck)
        {
            loginRegService.addOne(userModel);
            model.addAttribute("UserModel", new UserModel());
            return "welcome";
        }
        else {

            model.addAttribute("NewRegUser", new UserModel());

            if(emailCheck)
            {
                model.addAttribute("duplicatedEmail", "This e-mail has been registered!");
            }

            if(usernameCheck)
            {
                model.addAttribute("duplicatedUsername", "The username is not available!");
            }

            return "register";
        }
    }
}
