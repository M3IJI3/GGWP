package com.example.ggwp.models.forum;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForumModel {
    long forum_id;
    String forum_title;
    String type;
    String description;
    String image_url;
}
