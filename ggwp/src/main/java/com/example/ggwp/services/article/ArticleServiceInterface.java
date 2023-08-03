package com.example.ggwp.services.article;

import com.example.ggwp.models.forum.ForumArticleModel;

import java.util.List;

public interface ArticleServiceInterface {
    List<ForumArticleModel> getAllArticlesByForumId(long id);

    long addOne(ForumArticleModel newArticle);
}
