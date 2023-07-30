package com.example.ggwp.repositories.comment;

import com.example.ggwp.models.comment.CommentEntity;
import com.example.ggwp.models.comment.CommentModel;
import com.example.ggwp.models.user.UserModel;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentDataServiceRepository implements CommentDAOInterface<CommentModel> {
    @Resource
    CommentEntityRepositoryInterface commentEntityRepositoryInterface;

    private JdbcTemplate jdbcTemplate;

    ModelMapper mapper = new ModelMapper();

    public CommentDataServiceRepository(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public CommentModel getByID(long id) {
        CommentEntity commentEntity = commentEntityRepositoryInterface.findById(id).orElse(null);
        CommentModel commentModel = mapper.map(commentEntity, CommentModel.class);
        return commentModel;
    }

    @Override
    public List<CommentModel> getComments() {
        Iterable<CommentEntity> commentEntities = commentEntityRepositoryInterface.findAll();
        List<CommentModel> commentModels = new ArrayList<>();

        for(CommentEntity entity : commentEntities)
        {
            commentModels.add(mapper.map(entity, CommentModel.class));
        }
        return commentModels;
    }

    @Override
    public List<CommentModel> searchComments(String searchTerm) {

        return null;
    }

    @Override
    public long postOne(CommentModel comment, UserModel userModel) {
        CommentEntity commentEntity = mapper.map(comment, CommentEntity.class);

        commentEntity.setUserId(userModel.getUserId());

        CommentEntity result = commentEntityRepositoryInterface.save(commentEntity);

        if(result == null)
        {
            return 0;
        }
        else {
            return result.getCommentID();
        }
    }
}
