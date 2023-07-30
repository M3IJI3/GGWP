package com.example.ggwp.controllers.comment;

import com.example.ggwp.models.comment.CommentModel;
import com.example.ggwp.services.comment.CommentService;
import com.example.ggwp.services.comment.CommentServiceInterface;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CommentController {
    @Resource
    CommentServiceInterface commentServiceInterface;

//    @GetMapping(path = "/home/")
//    public String showComments(Model model)
//    {
//        List<CommentModel> commentModels = commentServiceInterface.getComments();
//        model.addAttribute("commentModels", commentModels);
//        System.out.println(commentModels);
//        return "redirect:/home";
//    }
}
