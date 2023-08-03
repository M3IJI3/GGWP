package com.example.ggwp.services.forum;

import com.example.ggwp.models.forum.ForumModel;

public interface ForumServiceInterface {
    ForumModel getByForumTitle(String name);
}
