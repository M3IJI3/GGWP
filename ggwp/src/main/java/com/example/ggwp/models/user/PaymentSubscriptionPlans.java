package com.example.ggwp.models.user;

public enum PaymentSubscriptionPlans {
    FREE("free", 0.0),
    BASIC("basic", 9.99),
    VIP("vip", 19.99);

    final String name;

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    final Double price;

    PaymentSubscriptionPlans(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
