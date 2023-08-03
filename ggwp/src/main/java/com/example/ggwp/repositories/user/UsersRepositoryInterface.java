package com.example.ggwp.repositories.user;

import com.example.ggwp.models.user.UserEntity;
import com.example.ggwp.models.user.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepositoryInterface extends CrudRepository<UserEntity, Long> {
    //use the CrudRepository class in Spring to do the data operations on mysql

    // already implies that we will use save, findall, findbyid, deletebyid etc. but not search
    List<UserEntity> findByUserNameContainingIgnoreCase(String searchTerm);

    UserEntity findByUserName(String username);



}
