package com.example.ggwp.repositories.subcomment;

import com.example.ggwp.models.comment.CommentModel;
import com.example.ggwp.models.comment.SubCommentModel;

import java.util.List;

public interface SubCommentDAOInterface<T> {
    List<T> getAllSubComments();

    void addOneSubComment(SubCommentModel model, CommentModel commentModel);
}
