package com.example.ggwp.services.comment;

import com.example.ggwp.models.comment.CommentModel;
import com.example.ggwp.models.user.UserModel;

import java.util.List;

public interface CommentServiceInterface {
    CommentModel getByID(long id);
    List<CommentModel> getComments();
    List<CommentModel> searchComments(String searchTerm);
    long postOne(CommentModel comment, UserModel userModel);
}
