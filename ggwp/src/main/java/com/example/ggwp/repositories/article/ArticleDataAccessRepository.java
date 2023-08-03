package com.example.ggwp.repositories.article;

import com.example.ggwp.models.forum.ForumArticleEntity;
import com.example.ggwp.models.forum.ForumArticleModel;
import com.example.ggwp.repositories.forum.ForumEntityRepositoryInterface;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class ArticleDataAccessRepository implements ArticleDAOInterface<ForumArticleModel> {

    @Resource
    ArticleEntityRepositoryInterface articleEntityRepositoryInterface;

    ModelMapper mapper = new ModelMapper();

    @Override
    public List<ForumArticleModel> getAllArticlesByForumId(long id) {
        List<ForumArticleEntity> forumArticleEntities = articleEntityRepositoryInterface.findAllByForumID(id);

        LinkedList<ForumArticleModel> forumArticleModel = new LinkedList<>();

        for(ForumArticleEntity forumArticleEntity : forumArticleEntities)
        {
            forumArticleModel.addFirst(mapper.map(forumArticleEntity, ForumArticleModel.class));
        }
        return forumArticleModel;
    }
}
