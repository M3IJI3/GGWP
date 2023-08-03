package com.example.ggwp.controllers.user;

import com.example.ggwp.models.user.*;
import com.example.ggwp.services.user.PaymentServiceInterface;
import com.example.ggwp.services.user.UsersBusinessServiceInterface;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class UserController {
    @Resource
    UsersBusinessServiceInterface userBusinessService;

    @Resource
    PaymentServiceInterface paymentService;

//    @GetMapping(path = "/")
//    public String InitialPage(Model model)
//    {
//        return "welcome";
//    }


    @GetMapping(path = "/subscription")
    public String displaySubscription(Model model) {
        PaymentSubscriptionModel subModel = new PaymentSubscriptionModel(PaymentSubscriptionPlans.FREE, PaymentSubscriptionPlans.BASIC, PaymentSubscriptionPlans.VIP);
        model.addAttribute("subscriptionModel", subModel);
        return "PaymentsubscriptionPage";
    }

    @PostMapping(path = "/payment")
    public String displayPayment(@ModelAttribute("subscriptionModel") PaymentSubscriptionModel subscriptionModel, Model model, @RequestParam MultiValueMap body) {
//        PaymentSubscriptionPlans plan = subscriptionModel.getSelectedPlan();
        String method = (String) body.getFirst("method");

        if (method.equals("cc")) {
            PaymentModel paymentModel = new PaymentModel();
            paymentModel.setSelectedPlan(subscriptionModel.getSelectedPlan());
            model.addAttribute("paymentModel", paymentModel);
            return "payment-creditCard";
        }

        PaypalPaymentModel paymentModel = new PaypalPaymentModel();
        paymentModel.setSelectedPlan(subscriptionModel.getSelectedPlan());
        model.addAttribute("paymentModel", paymentModel);
        return "payment-Paypal";
    }

    @PostMapping(path = "/finishPaypalPayment")
    public String finishPaypalPayment(@Valid PaypalPaymentModel paymentModel,
                                      BindingResult bindingResult,
                                      Model model,
                                      HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("paymentModel", paymentModel);
            return "payment-Paypal";
        }

        UserModel userModel = (UserModel) session.getAttribute("loggedInUser");
        String newPlan = paymentModel.getSelectedPlan().getName();
        userModel.setSubscription(newPlan);
        userBusinessService.updateOne(userModel.getUserId(), userModel);

        model.addAttribute("paymentModel", paymentModel);
        model.addAttribute("updatedUser", userModel);

        return "payment-finishPayment";
    }

    @PostMapping(path = "/finishPayment")
    public String finishPayment(@Valid PaymentModel paymentModel,
                                BindingResult bindingResult,
                                Model model,
                                HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("paymentModel", paymentModel);
            return "payment-creditCard";
        }

        // validate card
        Boolean cardIsValid = paymentService.validateCreditCard(paymentModel.getCardNumber());
        if (!cardIsValid) {
            model.addAttribute("paymentModel", paymentModel);
            bindingResult.addError(new FieldError("cardNumber", "cardNumber", "Invalid credit card number" ));
            return "payment-creditCard";
        }

        UserModel userModel = (UserModel) session.getAttribute("loggedInUser");
        String newPlan = paymentModel.getSelectedPlan().getName();
        userModel.setSubscription(newPlan);
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

//    @GetMapping(path = "/forum")
//    public String ForumPage(){ return "forum"; }

    @GetMapping(path = "/forum_article_editor")
    public String ForumArticlePage(){ return "forum_article_editor"; }

    @GetMapping("/forum/post")
    public String Post() { return "post_page"; }
}
