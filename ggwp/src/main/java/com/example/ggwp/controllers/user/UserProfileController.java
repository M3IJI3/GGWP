package com.example.ggwp.controllers.user;

import com.example.ggwp.models.comment.PostModel;
import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.services.user.UsersBusinessServiceInterface;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class UserProfileController {

    private String uploadPath = System.getProperty("user.dir") + "/ggwp/src/main/resources/static/img/user_avatar";
//    private String uploadPath = "https://github.com/M3IJI3/GGWP/tree/main/user_avatar";

    @Resource
    UsersBusinessServiceInterface usersBusinessService;

    @GetMapping(path = "/profile/{username}")
    public String showUserPage(Model model, @PathVariable(name = "username") String username)
    {
//        System.out.println(username);
        UserModel userModel = usersBusinessService.getByUsername(username);

        model.addAttribute("personalProfile", userModel);


        if(userModel.getRole().equals("/gg"))
        {
            return "personal_profile";
        }
        else
        {
            return "tutor_profile";
        }
    }

    @PostMapping("/uploadImage")
    public String uploadImage(Model model, @RequestParam("imageFile") MultipartFile imageFile, HttpSession session)
    {
        UserModel userModel = (UserModel) session.getAttribute("loggedInUser");

        if (imageFile.isEmpty()) {
            return "redirect:/profile/" + userModel.getUserName();
        }

        try {
            String originalFilename = imageFile.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();

            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));

            File destFile = new File(uploadPath + File.separator + uuid + fileExtension);

            imageFile.transferTo(destFile);

            String fileName = uuid + fileExtension;
            String path = "/img/user_avatar/" + fileName;

            userModel.setImageUrl(path);
            usersBusinessService.updateOne(userModel.getUserId(), userModel);


            return "redirect:/profile/";
        } catch (IOException e) {
            e.printStackTrace();
            return "home";
        }
    }

    @GetMapping("/profile/")
    public String updateProfile(Model model, HttpSession session)
    {
        UserModel userModel = (UserModel) session.getAttribute("loggedInUser");

        UserModel updatedModel = usersBusinessService.getByUsername(userModel.getUserName());

        session.setAttribute("loggedInUser", updatedModel);

        System.out.println(updatedModel.getImageUrl());

        return "redirect:/profile/" + userModel.getUserName();
    }
}
