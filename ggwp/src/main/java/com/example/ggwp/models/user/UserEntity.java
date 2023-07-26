package com.example.ggwp.models.user;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @jakarta.persistence.Column(name = "USER_ID")
    private long userId;

    @jakarta.persistence.Column(name = "IMAGE_URL")
    private String imageUrl;

    @jakarta.persistence.Column(name = "USER_NAME")
    private String userName;

    @jakarta.persistence.Column(name = "PASSWORD")
    private String password;

    @jakarta.persistence.Column(name = "EMAIL")
    private String email;

    @jakarta.persistence.Column(name = "DATE_CREATED")
    private LocalDate dateCreated;

    @jakarta.persistence.Column(name = "SUBSCRIPTION")
    private String subscription;

    @jakarta.persistence.Column(name = "ROLE")
    private String role;

    @jakarta.persistence.Column(name = "PAYMENT_TYPE")
    private String paymentType;

    public UserEntity() {
    }

    public UserEntity(long userId, String imageUrl, String userName, String password, String email, LocalDate dateCreated, String subscription, String role, String paymentType) {
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
        return "UserEntity{" +
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
}
