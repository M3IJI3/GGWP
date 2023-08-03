package com.example.ggwp.models.forum;

import jakarta.persistence.*;

@Entity
@Table(name = "FORUM")
public class ForumEntity {
    @Id
    @Column(name = "FORUM_ID")
    long forum_id;
    @Column(name = "GAME_TITLE")
    String forum_title;
    @Column(name = "TYPE")
    String type;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "IMAGE_URL")
    String image_url;
}
