package com.example.ggwp.models.user;

import java.time.LocalDate;

public class UserModel {

    private long userId;
    private String userName;
    private String password;
    private String email;
    private LocalDate dateCreated;
    private String subscription;
    private String role;
    private String paymentType;

    public UserModel() {
    }

    public UserModel(long userId, String userName, String password, String email, LocalDate dateCreated, String subscription, String role, String paymentType) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.dateCreated = dateCreated;
        this.subscription = subscription;
        this.role = role;
        this.paymentType = paymentType;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateCreated=" + dateCreated +
                ", subscription='" + subscription + '\'' +
                ", role='" + role + '\'' +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
