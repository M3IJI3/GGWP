package com.example.ggwp.services.forum;

import com.example.ggwp.models.forum.ForumModel;
import com.example.ggwp.repositories.forum.ForumDataAccessRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForumService implements ForumServiceInterface{

    @Resource
    ForumDataAccessRepository forumDataAccessRepository;


    @Override
    public ForumModel getByForumTitle(String name) {

        return forumDataAccessRepository.getByForumTitle(name);
    }
}
