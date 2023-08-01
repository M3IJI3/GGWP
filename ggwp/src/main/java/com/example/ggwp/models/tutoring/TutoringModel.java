package com.example.ggwp.models.tutoring;

import java.util.List;

public class TutoringModel {
    long id;
    long gameId;
    double price;
    long tutorAvailabilityId;
    String rank;
    String contactInfo;

    public TutoringModel() {

    }

    public TutoringModel(long id, long gameId, double price, long tutorAvailabilityId, String rank, String contactInfo, String description, List<TutorAvailabilityModel> availabilities) {
        this.id = id;
        this.gameId = gameId;
        this.price = price;
        this.tutorAvailabilityId = tutorAvailabilityId;
        this.rank = rank;
        this.contactInfo = contactInfo;
        this.description = description;
        this.availabilities = availabilities;
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

    String description;

    List<TutorAvailabilityModel> availabilities;
}
