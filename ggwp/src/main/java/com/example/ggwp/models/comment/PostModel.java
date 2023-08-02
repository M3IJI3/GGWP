package com.example.ggwp.models.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostModel {
    long comment_id;
    String game;
    String imageUrl;
    String username;
    String role;
    String vip;
    String content;
    LocalDate date;
    long likesCount;
    long subCommentsCount;
    List<PostSubModel> postSubModelList;

//    public PostModel(String imageUrl, String username)
//    {
//        this.imageUrl = imageUrl;
//        this.username = username;
//    }
}
