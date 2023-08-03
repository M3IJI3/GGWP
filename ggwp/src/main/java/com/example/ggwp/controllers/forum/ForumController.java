package com.example.ggwp.controllers.forum;

import com.example.ggwp.models.forum.ForumModel;
import com.example.ggwp.dtos.forum.ForumPostDTO;
import com.example.ggwp.services.forum.ForumServiceInterface;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/forum")
public class ForumController {

    @Resource
    ForumServiceInterface forumServiceInterface;


    @GetMapping("/{title}")
    public String showForumPage(Model model, @PathVariable(name = "title") String title)
    {
        ForumModel forumModel = forumServiceInterface.getByForumTitle(title);
        model.addAttribute("forumModel", forumModel);
        System.out.println(forumModel);
        return "forum";
    }

    @GetMapping("/{title}/article_editor")
    public String showEditorPage(Model model, @PathVariable(name = "title") String title) {

        return "forum_article_editor";
    }

//    @PostMapping("/createPost")
//    public ResponseEntity<String> createForumPost(@RequestBody ForumPostDTO forumPostDTO) {
//        String content = forumPostDTO.getContent();
//        List<String> splitContent = new ArrayList<>(Arrays.asList(content.split("\n")));
//
//        String postTitle = "Title";
//        for (int i = 0; i < splitContent.size(); i++) {
//            if (splitContent.get(i).contains("h1")) {
//               String postTitleHtml = splitContent.get(i);
//                // Define the regular expression pattern to match the content inside <h1> tag
//                Pattern pattern = Pattern.compile("<h1>(.*?)</h1>");
//                Matcher matcher = pattern.matcher(postTitleHtml);
//
//                if (matcher.find()) {
//                    postTitle = matcher.group(1);
//                    System.out.println(postTitle);
//                } else {
//                    System.out.println("<h1> tag not found or is empty.");
//                }
//            }
//        }
//        return ResponseEntity.ok(content);
//    }
}
