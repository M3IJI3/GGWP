package com.example.ggwp.repositories.forum;

import com.example.ggwp.models.user.UserModel;

public interface ForumDAOInterface<T> {
    T getByForumTitle(String name);
}
