package com.example.ggwp.repositories.comment;

import com.example.ggwp.models.comment.CommentEntity;
import com.example.ggwp.models.comment.CommentModel;
import com.example.ggwp.models.user.UserEntity;
import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.repositories.user.UsersDataAccessInterface;
import com.example.ggwp.repositories.user.UsersRepositoryInterface;
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

    @Resource
    UsersDataAccessInterface<UserModel> usersDAO;

    private JdbcTemplate jdbcTemplate;

    ModelMapper mapper = new ModelMapper();

    public CommentDataServiceRepository(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public CommentModel getByID(long id) {
        CommentEntity commentEntity = commentEntityRepositoryInterface.findById(id).orElse(null);
        return mapper.map(commentEntity, CommentModel.class);
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
        List<CommentEntity> commentEntities =
                commentEntityRepositoryInterface.findAllByContentContainingOrGameFieldContainingIgnoreCase(searchTerm, searchTerm);

        List<CommentModel> commentModelList = new ArrayList<>();

        for(CommentEntity commentEntity : commentEntities)
        {
            commentModelList.add(mapper.map(commentEntity, CommentModel.class));
        }
        return commentModelList;
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

    @Override
    public UserModel getByCommentId(long commentId)
    {
        CommentModel commentModel = getByID(commentId);
        return usersDAO.getById(commentModel.getUserId());
    }

}
