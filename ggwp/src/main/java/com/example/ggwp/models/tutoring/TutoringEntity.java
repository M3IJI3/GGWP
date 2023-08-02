package com.example.ggwp.models.tutoring;

import jakarta.persistence.*;

@Entity
@Table(name = "tutoring")
public class TutoringEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "price")
    private double price;

    @JoinColumn(name = "tutor_availability_id")
    private long tutorAvailabilityId;

    @Column(name = "rank")
    private String rank;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "description")
    private String description;

    public TutoringEntity() {
    }

    public TutoringEntity(Long id, Long gameId, double price, long tutorAvailabilityId, String rank, String contactInfo, String description) {
        this.id = id;
        this.gameId = gameId;
        this.price = price;
        this.tutorAvailabilityId = tutorAvailabilityId;
        this.rank = rank;
        this.contactInfo = contactInfo;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
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
}
