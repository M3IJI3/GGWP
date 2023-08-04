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
import java.util.regex.Pattern;

@Controller
public class SearchController {

    @Resource
    CommentServiceInterface commentServiceInterface;

    @Resource
    UsersBusinessServiceInterface usersBusinessService;

    @GetMapping("/search")
    public String showSearchResults(Model model,  @RequestParam(name = "keyword") String keyword)
    {
        model.addAttribute("keyword", keyword);

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

            String highlightKeywordInContent = commentSearchResults.get(i).getContent().replaceAll(keyword, "<span style='color:#0d6efd;font-weight:bold'>$0</span>");
            String highlightKeywordInGameField = commentSearchResults.get(i).getGameField().replaceAll(keyword, "<span style='color:#0d6efd;font-weight:bold'>$0</span>");


            searchPostModelResults.get(i).setContent(highlightKeywordInContent);
            searchPostModelResults.get(i).setGame(highlightKeywordInGameField);
        }

        model.addAttribute("searchPostModelResults", searchPostModelResults);


        // find users
        List<UserModel> userSearchResults = usersBusinessService.searchUsers(keyword);

        for(int i = 0 ; i < userSearchResults.size() ; i++)
        {
            String highlightKeywordInUsername = userSearchResults.get(i).getUserName().replaceAll(keyword, "<span style='color:#0d6efd;font-weight:bold'>$0</span>");
            userSearchResults.get(i).setUserName(highlightKeywordInUsername);
        }

        model.addAttribute("userSearchResults", userSearchResults);
        return "search";
    }
}
