package com.example.ggwp.controllers.user;

import com.example.ggwp.models.comment.CommentModel;
import com.example.ggwp.models.comment.PostModel;
import com.example.ggwp.models.comment.PostSubModel;
import com.example.ggwp.models.comment.SubCommentModel;
import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.services.comment.CommentServiceInterface;
import com.example.ggwp.services.subcomment.SubCommentServiceInterface;
import com.example.ggwp.services.user.UserLoginRegistrationServiceInterface;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping(path = "/")
@SessionAttributes({"newComment", "subComment"})

public class UserLoginRegistrationController {
    @Resource
    UserLoginRegistrationServiceInterface loginRegService;

    @Resource
    CommentServiceInterface commentServiceInterface;

    @Resource
    SubCommentServiceInterface subCommentService;

    @GetMapping(path = "login")
    public String showLoginPage(Model model)
    {
        model.addAttribute("UserModel", new UserModel());
        return "welcome";
    }

    @PostMapping(path = "/")
    public String loginValidation(Model model ,UserModel userModel, HttpSession session){
        List<UserModel> users = loginRegService.getUsers();

        boolean result = loginRegService.LoginCheck(userModel.getEmail(),
                userModel.getPassword(), users);


        if(result)
        {
            // pass current UserModel with full information to home page
            UserModel fullInfoModel = loginRegService.getByEmail(userModel.getEmail(), users);

            // save the user model to session
            session.setAttribute("loggedInUser", fullInfoModel);

            // enter into home page and get latest comments
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

                postModels.addFirst(new PostModel(commentModels.get(i).getGameField(),
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


            return "home";
        }
        else {
            model.addAttribute("info", "Username or password is incorrect!");
            model.addAttribute("UserModel", new UserModel());
            return "welcome";
        }
    }


    @RequestMapping(path = "home")
    public String homePage(HttpSession session)
    {
        if(session.getAttribute("loggedInUser") == null)
        {
            return "redirect:login";
        }

        return "home";
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
        userModel.setRole("/gg");
        userModel.setSubscription("non-vip");

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
