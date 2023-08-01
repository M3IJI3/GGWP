package com.example.ggwp.repositories.subcomment;

import com.example.ggwp.models.comment.CommentEntity;
import com.example.ggwp.models.comment.CommentModel;
import com.example.ggwp.models.comment.SubCommentEntity;
import com.example.ggwp.models.comment.SubCommentModel;
import com.example.ggwp.models.user.UserModel;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubCommentRepository implements SubCommentDAOInterface<SubCommentModel>{

    @Resource
    CrudRepository<SubCommentEntity, Long> crudRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public List<SubCommentModel> getAllSubComments() {
        Iterable<SubCommentEntity> subCommentEntities = crudRepository.findAll();
        List<SubCommentModel> subCommentModels = new ArrayList<>();

        for(SubCommentEntity subCommentEntity : subCommentEntities)
        {
            subCommentModels.add(mapper.map(subCommentEntity, SubCommentModel.class));
        }
        return subCommentModels;
    }

    @Override
    public void addOneSubComment(SubCommentModel model) {
        SubCommentEntity entity = mapper.map(model, SubCommentEntity.class);

        crudRepository.save(entity);
    }
}
