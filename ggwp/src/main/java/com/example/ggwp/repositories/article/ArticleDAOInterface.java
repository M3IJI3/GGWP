package com.example.ggwp.repositories.article;

import java.util.List;

public interface ArticleDAOInterface<T> {
    List<T> getAllArticlesByForumId(long id);
}
