package com.example.ggwp.repositories.comment;

import com.example.ggwp.models.comment.CommentEntity;
import com.example.ggwp.models.user.UserEntity;
import com.example.ggwp.models.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentEntityRepositoryInterface extends CrudRepository<CommentEntity, Long> {
}
