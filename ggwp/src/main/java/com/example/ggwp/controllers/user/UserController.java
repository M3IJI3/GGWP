package com.example.ggwp.controllers.user;

import com.example.ggwp.models.user.PaymentModel;
import com.example.ggwp.models.user.PaymentSubscriptionModel;
import com.example.ggwp.models.user.PaymentSubscriptionPlans;
import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.services.user.UsersBusinessServiceInterface;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class UserController {
    @Resource
    UsersBusinessServiceInterface userBusinessService;


    @GetMapping(path = "/subscription")
    public String displaySubscription(Model model) {
        PaymentSubscriptionModel subModel = new PaymentSubscriptionModel(PaymentSubscriptionPlans.FREE, PaymentSubscriptionPlans.BASIC, PaymentSubscriptionPlans.VIP);
        model.addAttribute("subscriptionModel", subModel);
        return "PaymentsubscriptionPage";
    }

    @PostMapping(path = "/payment")
    public String displayPaymentForm(Model model, @RequestParam MultiValueMap body) {
        model.addAttribute("paymentModel", new PaymentModel());
        model.addAttribute("plan", body.getFirst("plan"));
        return "payment-paymentForm";
    }

    @PostMapping(path = "/finishPayment")
    public String finishPayment(@Valid PaymentModel paymentModel,
                                BindingResult bindingResult,
                                Model model,
                                HttpSession session,
                                @RequestParam MultiValueMap body) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("paymentModel", paymentModel);
            return "payment-paymentForm";
        }

        UserModel userModel = (UserModel) session.getAttribute("loggedInUser");
        String plan = (String) body.getFirst("plan");
        userModel.setSubscription(plan);
        userBusinessService.updateOne(userModel.getUserId(), userModel);

        model.addAttribute("paymentModel", paymentModel);
        model.addAttribute("updatedUser", userModel);

        return "payment-finishPayment";
    }

    @GetMapping(path = "/user")
    public String PersonalPage(Model model) {return "/personal_profile" ;}

    @GetMapping(path = "/tutor")
    public String TutorPage(Model model) {return "/tutor_profile" ;}

//    @RequestMapping("/library")
//    public String LibraryPage(){
//        return "library";
//    }

//    @GetMapping(path = "/home")
//    public String HomePage(Model model) { return "/home"; }
//    @RequestMapping("/home")
//    public String HomePage(){
//        return "home";
//    }

//    @RequestMapping("/tutors")
//    public String TutorsPage() { return "/tutors_page"; }

    @GetMapping(path = "/forum")
    public String ForumPage(){ return "forum"; }

    @GetMapping(path = "/forum_article_editor")
    public String ForumArticlePage(){ return "forum_article_editor"; }

    @GetMapping("/forum/post")
    public String Post() { return "post_page"; }
}
