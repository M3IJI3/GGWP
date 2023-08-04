package com.example.ggwp.models.tutoring;

import java.util.List;

public class TutoringModel {
    private long id;

    private String tutorName;
    private long gameId;
    private String gameName;
    private double price;
    private long tutorAvailabilityId;
    private String rank;
    private String contactInfo;
    private String description;
    private List<TutorAvailabilityModel> availabilities;

    private String avatarImgUrl;

    private String leftSideGameImgUrl;

    public TutoringModel() {

    }

    public TutoringModel(long id, String tutorName, long gameId, String gameName, double price, long tutorAvailabilityId, String rank, String contactInfo, String description, List<TutorAvailabilityModel> availabilities) {
        this.id = id;
        this.tutorName = tutorName;
        this.gameId = gameId;
        this.gameName = gameName;
        this.price = price;
        this.tutorAvailabilityId = tutorAvailabilityId;
        this.rank = rank;
        this.contactInfo = contactInfo;
        this.description = description;
        this.availabilities = availabilities;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getTutorAvailabilityId() {
        return tutorAvailabilityId;
    }

    public void setTutorAvailabilityId(long tutorAvailabilityId) {
        this.tutorAvailabilityId = tutorAvailabilityId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TutorAvailabilityModel> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<TutorAvailabilityModel> availabilities) {
        this.availabilities = availabilities;
    }

    public String getAvatarImgUrl() {
        return avatarImgUrl;
    }

    public void setAvatarImgUrl(String avatarImgUrl) {
        this.avatarImgUrl = avatarImgUrl;
    }

    public String getLeftSideGameImgUrl() {
        return leftSideGameImgUrl;
    }

    public void setLeftSideGameImgUrl(String leftSideGameImgUrl) {
        this.leftSideGameImgUrl = leftSideGameImgUrl;
    }
}
