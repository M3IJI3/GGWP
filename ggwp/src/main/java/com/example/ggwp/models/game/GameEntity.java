package com.example.ggwp.models.game;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "GAMES")
public class GameEntity {

    @Id
    @Column(name = "GAME_ID")
    private long gameId;



    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Column(name = "GAME_COVER_IMG_URL")
    private String gameCoverImgUrl;

    public GameEntity() {

    }


    public GameEntity(long gameId, String title, String description, Date releaseDate, String gameCoverImgUrl) {
        this.gameId = gameId;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.gameCoverImgUrl = gameCoverImgUrl;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGameCoverImgUrl() {
        return gameCoverImgUrl;
    }

    public void setGameCoverImgUrl(String gameCoverImgUrl) {
        this.gameCoverImgUrl = gameCoverImgUrl;
    }

}
