package com.example.ggwp.models.comment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COMMENT")
public class CommentEntity {
    @Id
    @Column(name = "COMMENT_ID")
    private long commentID;

    @Column(name = "FIELD")
    private String gameField;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "LIKES_COUNT")
    private long likesCount;

    @Column(name = "SUB_COMMENT_COUNT")
    private long subCommentCount;

    @Column(name = "COMMENT_DATE")
    private LocalDate commentDate;
    
    @JoinColumn(name = "USER_ID")
    private long userId;
}
