package com.example.ggwp.repositories.user;

import com.example.ggwp.models.user.UserEntity;
import com.example.ggwp.models.user.UserModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    @Override
    public long addOne(UserModel newUser) {
        UserEntity entity = modelMapper.map(newUser, UserEntity.class);
        if (entity.getImageUrl() == null || entity.getImageUrl().isEmpty()) {
            // Set the default image URL
            entity.setImageUrl("https://cdn-icons-png.flaticon.com/512/3177/3177440.png");
        }
        // Set the dateCreated field with the current timestamp
        entity.setDateCreated(LocalDate.now());
        UserEntity result = crudRepository.save(entity);
        if(result == null){
            return 0;
        }else {
            return result.getUserId();
        }
    }

    @Override
    public UserModel getByEmail(String param, List<UserModel> objects) {
        for(UserModel user : objects)
        {
            if(param.equals(user.getEmail()))
            {
                return user;
            }
        }
        return null;
    }
}
