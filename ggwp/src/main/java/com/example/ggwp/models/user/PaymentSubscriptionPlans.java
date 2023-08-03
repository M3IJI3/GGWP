package com.example.ggwp.models.user;

public enum PaymentSubscriptionPlans {
    FREE("free", 0.0, 0.0, 0.0, 0.0),
    BASIC("basic", 9.99, 0.69, 0.49, 11.09),
    VIP("vip", 19.99, 1.39, 0.99, 22.37);

    final String name;

    public Double getPst() {
        return pst;
    }

    public Double getGst() {
        return gst;
    }

    public Double getTotal() {
        return total;
    }

    final Double pst;
    final Double gst;
    final Double total;

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    final Double price;

    PaymentSubscriptionPlans(String name, Double price, Double pst, Double gst, Double total) {
        this.name = name;
        this.price = price;
        this.pst = pst;
        this.gst= gst;
        this.total = total;
    }
}
