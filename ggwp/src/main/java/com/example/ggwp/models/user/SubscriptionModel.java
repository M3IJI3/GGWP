package com.example.ggwp.models.user;

public class SubscriptionModel {
    private SubscriptionPlans freePlan;
    private SubscriptionPlans basicPlan;
    private SubscriptionPlans vipPlan;

    public SubscriptionPlans getFreePlan() {
        return freePlan;
    }

    public void setFreePlan(SubscriptionPlans freePlan) {
        this.freePlan = freePlan;
    }

    public SubscriptionPlans getBasicPlan() {
        return basicPlan;
    }

    public void setBasicPlan(SubscriptionPlans basicPlan) {
        this.basicPlan = basicPlan;
    }

    public SubscriptionPlans getVipPlan() {
        return vipPlan;
    }

    public void setVipPlan(SubscriptionPlans vipPlan) {
        this.vipPlan = vipPlan;
    }

    public SubscriptionModel(SubscriptionPlans freePlan, SubscriptionPlans basicPlan, SubscriptionPlans vipPlan) {
        this.freePlan = freePlan;
        this.basicPlan = basicPlan;
        this.vipPlan = vipPlan;
    }
}


