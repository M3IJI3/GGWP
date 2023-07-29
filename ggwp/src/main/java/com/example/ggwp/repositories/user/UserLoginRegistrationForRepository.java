package com.example.ggwp.repositories.user;

import com.example.ggwp.models.user.UserEntity;
import com.example.ggwp.models.user.UserModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserLoginRegistrationForRepository implements UserLoginRegistrationDAOInterface<UserModel> {


    @Autowired
    CrudRepository<UserEntity, Long> crudRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserModel getById(long id) {
        UserEntity entity = crudRepository.findById(id).orElse(null);
        UserModel model = modelMapper.map(entity, UserModel.class);
        return model;
    }

    @Override
    public List<UserModel> getUsers() {
        Iterable<UserEntity> userEntities = crudRepository.findAll();
        List<UserModel> models = new ArrayList<>();

        for(UserEntity item : userEntities){
            models.add(modelMapper.map(item, UserModel.class));
        }
        return models;
    }
}
