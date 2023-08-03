package com.example.ggwp.repositories.forum;

import com.example.ggwp.models.forum.ForumEntity;
import org.springframework.data.repository.CrudRepository;

public interface ForumEntityRepositoryInterface extends CrudRepository<ForumEntity, Long> {
    ForumEntity findByForum_titleIgnoreCase(String title);
}
