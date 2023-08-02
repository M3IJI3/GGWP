package com.example.ggwp.services.subcomment;


import com.example.ggwp.models.comment.CommentModel;
import com.example.ggwp.models.comment.SubCommentModel;
import com.example.ggwp.repositories.subcomment.SubCommentDAOInterface;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCommentService implements SubCommentServiceInterface{

    @Resource
    SubCommentDAOInterface<SubCommentModel> subCommentRepository;

    @Override
    public List<SubCommentModel> getAllSubComments() {
        return subCommentRepository.getAllSubComments();
    }

    @Override
    public List<SubCommentModel> findSubCommentsByParentCommentId(long parentCommentId) {
        List<SubCommentModel> subCommentModels = getAllSubComments();

        List<SubCommentModel> subCommentsWithSameParentCommentId = new ArrayList<>();
        for(int i = 0 ; i < subCommentModels.size() ; i++)
        {
            if(subCommentModels.get(i).getComment_id() == parentCommentId)
            {
                subCommentsWithSameParentCommentId.add(subCommentModels.get(i));
            }
        }
        return subCommentsWithSameParentCommentId;
    }

    @Override
    public long findSubCommentUserId(long subCommentId) {
        
        return 0;
    }

    @Override
    public void addOneSubComment(SubCommentModel model, CommentModel commentModel) {
        subCommentRepository.addOneSubComment(model, commentModel);
    }
}
