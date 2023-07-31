package com.example.ggwp.models.game;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GameModel {
    private long gameId;
    private String title;
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    private String gameCoverImgUrl;

    public GameModel() {

    }

    public GameModel(long gameId, String title, String description, Date releaseDate, String gameCoverImgUrl) {
        this.gameId = gameId;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.gameCoverImgUrl = gameCoverImgUrl;
    }


    public String getGameCoverImgUrl() {
        return gameCoverImgUrl;
    }

    public void setGameCoverImgUrl(String gameCoverImgUrl) {
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
}
