package com.example.ggwp.models.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentModel {
    private long commentID;
    private String gameField;
    private String content;
    private long likesCount;
    private long subCommentCount;
    private LocalDate commentDate;
    private long userId;

    public CommentModel(String gameField, String content, long likesCount, long subCommentCount, LocalDate commentDate, long userId) {
        this.gameField = gameField;
        this.content = content;
        this.likesCount = likesCount;
        this.subCommentCount = subCommentCount;
        this.commentDate = commentDate;
        this.userId = userId;
    }
}
