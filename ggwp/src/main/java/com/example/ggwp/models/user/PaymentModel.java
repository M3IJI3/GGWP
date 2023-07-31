package com.example.ggwp.models.user;

public class PaymentModel {
    private Integer userID;

    private String userName;

    private Integer cardNumber;
    private Integer cvv;
    private Integer mm;
    private Integer yy;

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

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
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


    public PaymentModel() {
    }

    public PaymentModel(int customerID, String custormerName, int cardNumber, Integer cvv, int mm, int yy) {
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


