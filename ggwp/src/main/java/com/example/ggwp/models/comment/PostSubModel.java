package com.example.ggwp.models.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSubModel {

    long sub_comment_id;
    String content;
    long comment_id;
    long user_id;
    String imageUrl;
    String username;
}
