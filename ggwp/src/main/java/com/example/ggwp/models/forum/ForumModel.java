package com.example.ggwp.models.forum;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForumModel {
    long forumId;
    String forumTitle;
    String type;
    String description;
    String imageURL;
}
