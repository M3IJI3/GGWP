package com.example.ggwp.models.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCommentModel {
    long sub_comment_id;
    String content;
    long comment_id;
    long user_id;

    public SubCommentModel(String content, long user_id)
    {
        this.content = content;
        this.user_id = user_id;
    }

}
