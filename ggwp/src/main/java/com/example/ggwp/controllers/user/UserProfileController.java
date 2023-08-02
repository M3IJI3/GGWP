package com.example.ggwp.controllers.user;

import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.services.user.UsersBusinessServiceInterface;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UserProfileController {

    private String uploadPath = "./user_avatar";
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
    public ResponseEntity<String> uploadImage(@RequestParam("imageFile") MultipartFile imageFile)
    {
        System.out.println(imageFile);
        if (imageFile.isEmpty()) {
            return new ResponseEntity<>("The image is empty.", HttpStatus.BAD_REQUEST);
        }

        try {
            // 获取上传文件的原始文件名
            String originalFilename = imageFile.getOriginalFilename();
            // 生成UUID作为文件名
            String uuid = UUID.randomUUID().toString();
            // 获取上传文件的后缀名
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 设置保存文件的目标路径
            File destFile = new File(uploadPath + File.separator + uuid + fileExtension);

//            File destFile = new ClassPathResource("static/user_avatar").getFile();
            // 将上传的文件保存到目标路径
            imageFile.transferTo(destFile);

            return new ResponseEntity<>("文件上传成功", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("文件上传失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
