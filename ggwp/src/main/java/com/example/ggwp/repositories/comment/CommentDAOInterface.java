package com.example.ggwp.repositories.comment;

import com.example.ggwp.models.user.UserModel;

import java.util.List;

public interface CommentDAOInterface<T> {
    T getByID(long id);
    List<T> getComments();
    List<T> searchComments(String searchTerm);
    long postOne(T comment, UserModel userModel);
}
