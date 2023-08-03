package com.example.ggwp.repositories.forum;

import com.example.ggwp.models.forum.ForumEntity;
import com.example.ggwp.models.forum.ForumModel;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ForumDataAccessRepository implements ForumDAOInterface<ForumModel>{

    @Resource
    ForumEntityRepositoryInterface forumEntityLongForumEntityRepository;

    ModelMapper mapper = new ModelMapper();

    private JdbcTemplate jdbcTemplate;

    public ForumDataAccessRepository(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public ForumModel getByForumTitle(String name) {
        ForumEntity entity = forumEntityLongForumEntityRepository.findByForumTitleIgnoreCase(name);
        return mapper.map(entity, ForumModel.class);
    }
}
