package com.example.ggwp.models.comment;

import com.example.ggwp.models.user.UserModel;
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
}
