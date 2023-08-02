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
//    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/ggwp/src/main/resources/static/img";

    @Resource
    UsersBusinessServiceInterface usersBusinessService;

    @GetMapping(path = "/profile/{username}")
    public String showUserPage(Model model, @PathVariable(name = "username") String username)
    {
//        System.out.println(username);
        UserModel userModel = usersBusinessService.getByUsername(username);

        model.addAttribute("personalProfile", userModel);

        System.out.println(userModel.getImageUrl());

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
        try {
            String originalFilename = imageFile.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            // 获取上传文件的后缀名
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 设置保存文件的目标路径
            File destFile = new File(uploadPath + File.separator + uuid + fileExtension);

//            File destFile = new ClassPathResource("static/user_avatar").getFile();
            // 将上传的文件保存到目标路径
            imageFile.transferTo(destFile);

            String fileName = uuid + fileExtension;
            String path = "/img/user_avatar/" + fileName;

            UserModel userModel = (UserModel) session.getAttribute("loggedInUser");
            userModel.setImageUrl(path);
            usersBusinessService.updateOne(userModel.getUserId(), userModel);

            model.addAttribute("personalProfile", userModel);

            System.out.println(userModel.getImageUrl());

            return "redirect:/profile/major0814";
        } catch (IOException e) {
            e.printStackTrace();
            return "home";
        }
    }
}
