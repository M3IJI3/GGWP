package com.example.ggwp.services.comment;

import com.example.ggwp.models.comment.CommentModel;
import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.repositories.comment.CommentDataServiceRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements CommentServiceInterface{

    @Resource
    CommentDataServiceRepository commentDataServiceRepository;

    @Override
    public CommentModel getByID(long id) {
        return commentDataServiceRepository.getByID(id);
    }

    @Override
    public List<CommentModel> getComments() {
        return commentDataServiceRepository.getComments();
    }

    @Override
    public List<CommentModel> searchComments(String searchTerm) {
        return commentDataServiceRepository.searchComments(searchTerm);
    }

    @Override
    public long postOne(CommentModel comment, UserModel userModel) {
        return commentDataServiceRepository.postOne(comment, userModel);
    }

    @Override
    public UserModel getUserByCommentUserId(long commentUserId) {
        return commentDataServiceRepository.getByCommentId(commentUserId);
    }
}
