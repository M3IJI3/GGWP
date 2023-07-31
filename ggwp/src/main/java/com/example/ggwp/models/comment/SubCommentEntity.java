package com.example.ggwp.models.comment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SUB_COMMENT")
public class SubCommentEntity {
    @Id
    @Column(name = "SUB_COMMENT_ID")
    long sub_comment_id;
    @Column(name = "COMMENT_ID")
    long comment_id;
    @Column(name = "USER_ID")
    long user_id;
    @Column(name = "CONTENT")
    String content;
}
