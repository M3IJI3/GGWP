package com.example.ggwp.models.user;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PaypalPaymentModel {
    @NotNull(message="Login email is required")
    @NotEmpty(message="Login email is required")
    private String email;
    @NotNull(message="Password is is required")
    @NotEmpty(message="Password is is required")
    private String password;

    public PaypalPaymentModel() {

        password = null;
        email = null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PaymentSubscriptionPlans getSelectedPlan() {
        return selectedPlan;
    }

    public void setSelectedPlan(PaymentSubscriptionPlans selectedPlan) {
        this.selectedPlan = selectedPlan;
    }

    private PaymentSubscriptionPlans selectedPlan;

    public PaypalPaymentModel(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
