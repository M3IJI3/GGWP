package com.example.ggwp.repositories.article;

import com.example.ggwp.models.forum.ForumArticleEntity;
import com.example.ggwp.models.forum.ForumEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleEntityRepositoryInterface extends CrudRepository<ForumArticleEntity, Long> {
    List<ForumArticleEntity> findAllByForumID(long id);
}
