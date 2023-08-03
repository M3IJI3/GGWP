package com.example.ggwp.controllers.user;

import com.example.ggwp.models.comment.CommentModel;
import com.example.ggwp.models.comment.PostModel;
import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.services.comment.CommentServiceInterface;
import com.example.ggwp.services.user.UsersBusinessServiceInterface;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Resource
    CommentServiceInterface commentServiceInterface;

    @Resource
    UsersBusinessServiceInterface usersBusinessService;

    @GetMapping("/search")
    public String showSearchResults(Model model,  @RequestParam(name = "keyword") String keyword)
    {
        // find comments
        List<CommentModel> commentSearchResults = commentServiceInterface.searchComments(keyword);

        List<UserModel> commentUserSearchResults = new ArrayList<>();

        for (CommentModel commentSearchResult : commentSearchResults) {
            UserModel userModel = usersBusinessService.getById(commentSearchResult.getUserId());
            commentUserSearchResults.add(userModel);
        }

        List<PostModel> searchPostModelResults = new ArrayList<>();

        for(int i = 0; i < commentSearchResults.size(); i++)
        {
            searchPostModelResults.add(new PostModel(
                    commentSearchResults.get(i).getGameField(),
                    commentUserSearchResults.get(i).getImageUrl(),
                    commentUserSearchResults.get(i).getUserName(),
                    commentSearchResults.get(i).getContent(),
                    commentSearchResults.get(i).getCommentDate()
            ));
        }

        model.addAttribute("searchPostModelResults", searchPostModelResults);


        // find users
        List<UserModel> userSearchResults = usersBusinessService.searchUsers(keyword);
        model.addAttribute("userSearchResults", userSearchResults);

        return "search";
    }
}
