package com.example.ggwp.models.user;

import com.example.ggwp.models.comment.CommentModel;
import org.apache.catalina.User;

import java.time.LocalDate;
import java.util.List;

public class UserModel {
    private long userId;
    private String imageUrl;
    private String userName;
    private String password;
    private String email;
    private LocalDate dateCreated;
    private String subscription;
    private String role;
    private String paymentType;

    public UserModel() {
    }

    public UserModel(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public UserModel(String email, String password, String userName)
    {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public UserModel(long userId, String imageUrl, String userName, String password, String email, LocalDate dateCreated, String subscription, String role, String paymentType) {
        this.userId = userId;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
                ", imageUrl='" + imageUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateCreated=" + dateCreated +
                ", subscription='" + subscription + '\'' +
                ", role='" + role + '\'' +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }

    public String removeString(String text)
    {
        String updated = text.replaceAll("<span style='color:#0d6efd;font-weight:bold'>", "");
        return updated.replaceAll("</span>", "");
    }
}
