package com.example.ggwp.repositories.article;

import java.util.List;

public interface ArticleDAOInterface<T> {
    List<T> getAllArticlesByForumId(long id);

    public long addOne(T newArticle);

    public T getArticleById(long id);
}
