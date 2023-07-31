package com.example.ggwp.controllers.user;

import com.example.ggwp.models.user.PaymentModel;
import com.example.ggwp.models.user.SubscriptionModel;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class UserController {
//    @GetMapping(path = "/")
//    public String InitialPage(Model model)
//    {
//        return "welcome";
//    }

//    @GetMapping(path = "/register")
//    public String RegisterPage(Model model)
//    {
//        return "register";
//    }

    @GetMapping(path = "/subscription")
    public String displaySubscription(Model model) {
        SubscriptionModel subModel = new SubscriptionModel(0.0, 9.9, 19.9);
        model.addAttribute("subscriptionModel", subModel);
        return "subscriptionPage";
    }

    @PostMapping(path = "/payment")
    public String displayPaymentForm(PaymentModel paymentModel, Model model, @RequestParam MultiValueMap body) {
        model.addAttribute("paymentModel", new PaymentModel());
        model.addAttribute("price", body.getFirst("plan"));
        return "paymentForm";
    }

    @PostMapping(path = "/finishPayment")
    public String finishPayment(PaymentModel paymentModel, Model model) {
        model.addAttribute("loginModel", paymentModel);
        return "finishPayment";
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

    @RequestMapping("/tutors")
    public String TutorsPage() { return "/tutors_page"; }

    @GetMapping(path = "/forum")
    public String ForumPage(){ return "forum"; }

    @GetMapping(path = "/forum_article_editor")
    public String ForumArticlePage(){ return "forum_article_editor"; }

    @GetMapping("/forum/post")
    public String Post() { return "post_page"; }
}
