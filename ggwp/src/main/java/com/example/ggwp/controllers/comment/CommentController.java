package com.example.ggwp.controllers.comment;

import com.example.ggwp.models.comment.CommentModel;
import com.example.ggwp.models.comment.PostModel;
import com.example.ggwp.models.comment.PostSubModel;
import com.example.ggwp.models.comment.SubCommentModel;
import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.services.comment.CommentService;
import com.example.ggwp.services.comment.CommentServiceInterface;
import com.example.ggwp.services.subcomment.SubCommentServiceInterface;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class CommentController {
    @Resource
    CommentServiceInterface commentServiceInterface;

    @Resource
    SubCommentServiceInterface subCommentServiceInterface;

    @Resource
    SubCommentServiceInterface subCommentService;

    @PostMapping("/addNewComment")
    public String addNew(CommentModel commentModel, Model model, HttpSession session) {


        String inputString = commentModel.getContent();
        String[] parts = inputString.split("/");
        // 0:empty string, 1:game, 2:content

        UserModel userModel = (UserModel) session.getAttribute("loggedInUser");
        CommentModel newComment = new CommentModel("/"+parts[1], parts[2], 0, 0, LocalDate.now(), userModel.getUserId());
        commentServiceInterface.postOne(newComment, userModel);



        List<CommentModel> commentModels = commentServiceInterface.getComments();
        session.setAttribute("commentModels", commentModels);

        List<UserModel> commentUsersInfo = new ArrayList<>();

        List<SubCommentModel> subCommentModels =
                subCommentService.findSubCommentsByParentCommentId(commentModels.get(0).getCommentID());


        for(int i = 0 ; i < commentModels.size() ; i++)
        {
            commentUsersInfo.add(commentServiceInterface.getUserByCommentUserId(commentModels.get(i).getCommentID()));
        }


        LinkedList<PostModel> postModels = new LinkedList<>();
        for(int i = 0 ; i < commentModels.size() ; i++)
        {
            List<SubCommentModel> subCommentModelList =
                    subCommentService.findSubCommentsByParentCommentId(commentModels.get(i).getCommentID());

            List<PostSubModel> postSubModelList = new ArrayList<>();
            for(int j = 0; j <subCommentModelList.size(); j++){

                postSubModelList.add(new PostSubModel(subCommentModelList.get(j).getSub_comment_id(),
                        subCommentModelList.get(j).getContent(),
                        subCommentModelList.get(j).getComment_id(),
                        subCommentModelList.get(j).getUser_id(),
                        commentUsersInfo.get(j).getImageUrl(),
                        commentUsersInfo.get(j).getUserName()));
            }

            postModels.addFirst(new PostModel(
                    commentModels.get(i).getCommentID(),
                    commentModels.get(i).getGameField(),
                    commentUsersInfo.get(i).getImageUrl(),
                    commentUsersInfo.get(i).getUserName(),
                    commentUsersInfo.get(i).getRole(),
                    commentUsersInfo.get(i).getSubscription(),
                    commentModels.get(i).getContent(),
                    commentModels.get(i).getCommentDate(),
                    commentModels.get(i).getLikesCount(),
                    commentModels.get(i).getSubCommentCount(),
                    postSubModelList));
        }


        model.addAttribute("newComment", new CommentModel());
        session.setAttribute("postModels", postModels);

        model.addAttribute("subComment", new SubCommentModel());

        return "redirect:home";
    }

    @PostMapping("/addNewSubComment")
    public String addNewSubComment(Model model, SubCommentModel subCommentModel, HttpSession session)
    {
        CommentModel commentModel = commentServiceInterface.getByID(subCommentModel.getComment_id());

        subCommentServiceInterface.addOneSubComment(subCommentModel,commentModel);

        List<CommentModel> commentModels = commentServiceInterface.getComments();
        session.setAttribute("commentModels", commentModels);

        List<UserModel> commentUsersInfo = new ArrayList<>();

        List<SubCommentModel> subCommentModels =
                subCommentService.findSubCommentsByParentCommentId(commentModels.get(0).getCommentID());


        for(int i = 0 ; i < commentModels.size() ; i++)
        {
            commentUsersInfo.add(commentServiceInterface.getUserByCommentUserId(commentModels.get(i).getCommentID()));
        }


        LinkedList<PostModel> postModels = new LinkedList<>();
        for(int i = 0 ; i < commentModels.size() ; i++)
        {
            List<SubCommentModel> subCommentModelList =
                    subCommentService.findSubCommentsByParentCommentId(commentModels.get(i).getCommentID());

            List<PostSubModel> postSubModelList = new ArrayList<>();
            for(int j = 0; j <subCommentModelList.size(); j++){

                postSubModelList.add(new PostSubModel(subCommentModelList.get(j).getSub_comment_id(),
                        subCommentModelList.get(j).getContent(),
                        subCommentModelList.get(j).getComment_id(),
                        subCommentModelList.get(j).getUser_id(),
                        commentUsersInfo.get(j).getImageUrl(),
                        commentUsersInfo.get(j).getUserName()));
            }

            postModels.addFirst(new PostModel(
                    commentModels.get(i).getCommentID(),
                    commentModels.get(i).getGameField(),
                    commentUsersInfo.get(i).getImageUrl(),
                    commentUsersInfo.get(i).getUserName(),
                    commentUsersInfo.get(i).getRole(),
                    commentUsersInfo.get(i).getSubscription(),
                    commentModels.get(i).getContent(),
                    commentModels.get(i).getCommentDate(),
                    commentModels.get(i).getLikesCount(),
                    commentModels.get(i).getSubCommentCount(),
                    postSubModelList));
        }


        model.addAttribute("newComment", new CommentModel());
        session.setAttribute("postModels", postModels);

        model.addAttribute("subComment", new SubCommentModel());

        return "redirect:home";
    }
}
