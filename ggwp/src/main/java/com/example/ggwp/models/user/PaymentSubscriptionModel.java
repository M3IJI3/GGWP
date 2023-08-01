package com.example.ggwp.models.user;

public class PaymentSubscriptionModel {
    private PaymentSubscriptionPlans freePlan;
    private PaymentSubscriptionPlans basicPlan;
    private PaymentSubscriptionPlans vipPlan;

    public PaymentSubscriptionPlans getFreePlan() {
        return freePlan;
    }

    public void setFreePlan(PaymentSubscriptionPlans freePlan) {
        this.freePlan = freePlan;
    }

    public PaymentSubscriptionPlans getBasicPlan() {
        return basicPlan;
    }

    public void setBasicPlan(PaymentSubscriptionPlans basicPlan) {
        this.basicPlan = basicPlan;
    }

    public PaymentSubscriptionPlans getVipPlan() {
        return vipPlan;
    }

    public void setVipPlan(PaymentSubscriptionPlans vipPlan) {
        this.vipPlan = vipPlan;
    }

    public PaymentSubscriptionModel(PaymentSubscriptionPlans freePlan, PaymentSubscriptionPlans basicPlan, PaymentSubscriptionPlans vipPlan) {
        this.freePlan = freePlan;
        this.basicPlan = basicPlan;
        this.vipPlan = vipPlan;
    }
}


