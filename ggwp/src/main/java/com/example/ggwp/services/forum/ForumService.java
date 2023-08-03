package com.example.ggwp.services.forum;

import com.example.ggwp.models.forum.ForumModel;
import com.example.ggwp.repositories.forum.ForumDAOInterface;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ForumService implements ForumServiceInterface{
    @Resource
    ForumDAOInterface<ForumModel> forumDAO;

    @Override
    public ForumModel getByForumTitle(String name) {
        return forumDAO.getByForumTitle(name);
    }
}
