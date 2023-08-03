package com.example.ggwp.services.article;

import com.example.ggwp.models.forum.ForumArticleModel;
import com.example.ggwp.repositories.article.ArticleDAOInterface;
import com.example.ggwp.repositories.article.ArticleDataAccessRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements ArticleServiceInterface{

    @Resource
    ArticleDAOInterface<ForumArticleModel> articleDAOInterface;

    @Override
    public List<ForumArticleModel> getAllArticlesByForumId(long id) {
        System.out.println("HEREEE");
        return articleDAOInterface.getAllArticlesByForumId(id);

    }
}
