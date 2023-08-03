package com.example.ggwp.models.forum;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FORUM")
public class ForumEntity {
    @Id
    @Column(name = "FORUM_ID")
    long forumId;
    @Column(name = "IMAGE_URL")
    String imageURL;
    @Column(name = "FORUM_TITLE")
    String forumTitle;
    @Column(name = "GAME_TYPE")
    String type;
    @Column(name = "DESCRIPTION")
    String description;
}
