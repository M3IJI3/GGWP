package com.example.ggwp.models.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PaymentModel {
    private Integer userID;

    private String userName;

    private String cardNumber;

    @Size(min = 3, max = 3, message = "CVV must has 3 digits")
    private String cvv;
    private Integer mm;
    private Integer yy;

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @DateTimeFormat(pattern="YYYY-MM")
    private Date expirationDate;


    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getCustormerName() {
        return userName;
    }

    public void setCustormerName(String custormerName) {
        this.userName = custormerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Integer getMm() {
        return mm;
    }

    public void setMm(Integer mm) {
        this.mm = mm;
    }

    public Integer getYy() {
        return yy;
    }

    public void setYy(Integer yy) {
        this.yy = yy;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    private String method;

    public PaymentSubscriptionPlans getSelectedPlan() {
        return selectedPlan;
    }

    public void setSelectedPlan(PaymentSubscriptionPlans selectedPlan) {
        this.selectedPlan = selectedPlan;
    }

    private PaymentSubscriptionPlans selectedPlan;

    public PaymentModel() {
    }

    public PaymentModel(int customerID, String custormerName, String cardNumber, String cvv, int mm, int yy) {
        this.userID = customerID;
        this.userName = custormerName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.mm = mm;
        this.yy = yy;
    }

    @Override
    public String toString() {
        return "PaymentModel{" +
                "customerID='" + userID + '\'' +
                ", custormerName='" + userName + '\'' +
                ", cardNumber=" + cardNumber +
                ", cvv=" + cvv +
                ", mm=" + mm +
                ", yy=" + yy +
                '}';
    }
}


