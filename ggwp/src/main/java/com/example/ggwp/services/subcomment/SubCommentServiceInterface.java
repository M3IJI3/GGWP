package com.example.ggwp.services.subcomment;

import com.example.ggwp.models.comment.SubCommentModel;

import java.util.List;

public interface SubCommentServiceInterface {
    List<SubCommentModel> getAllSubComments();

    List<SubCommentModel> findSubCommentsByParentCommentId(long parentCommentId);
    long findSubCommentUserId(long subCommentId);

    void addOneSubComment(SubCommentModel model);
}
