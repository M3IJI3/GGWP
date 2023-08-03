package com.example.ggwp.repositories.forum;

import com.example.ggwp.models.forum.ForumEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ForumEntityRepositoryInterface extends CrudRepository<ForumEntity, Long> {
    ForumEntity findByForumTitleIgnoreCase(String title);
//    ForumEntity findByForum_id(long id);

}
