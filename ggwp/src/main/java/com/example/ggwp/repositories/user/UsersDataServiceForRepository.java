package com.example.ggwp.repositories.user;

import com.example.ggwp.models.user.UserEntity;
import com.example.ggwp.models.user.UserModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UsersDataServiceForRepository implements UsersDataAccessInterface<UserModel>{

    @Autowired
    UsersRepositoryInterface usersRepository;

    private JdbcTemplate jdbcTemplate;

    public  UsersDataServiceForRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserModel getById(long id) {
        UserEntity entity = usersRepository.findById(id).orElse(null);

        UserModel model = modelMapper.map(entity, UserModel.class);
        return model;
    }

    @Override
    public List<UserModel> getUsers() {
        Iterable<UserEntity> userEntities = usersRepository.findAll();
        List<UserModel> models = new ArrayList<>();

        for(UserEntity item : userEntities){
            models.add(modelMapper.map(item, UserModel.class));
        }
        return models;
    }

    @Override
    public List<UserModel> searchUsers(String searchTerm) {
        Iterable<UserEntity> userEntities = usersRepository.findByUserNameContainingIgnoreCase(searchTerm);

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
        UserEntity result = usersRepository.save(entity);
        if(result == null){
            return 0;
        }else {
            return result.getUserId();
        }
    }

    @Override
    public boolean deleteOne(long id) {
        UserEntity entity = usersRepository.findById(id).orElse(null);
        if (entity != null) {
            usersRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserModel updateOne(long idToUpdate, UserModel updateUser) {
        // Find the existing entity by its ID
        UserEntity existingEntity = usersRepository.findById(idToUpdate).orElse(null);

        // Check if the entity with the given ID exists
        if (existingEntity == null) {
            return null;
        }

        // Apply updates from the updateUser to the existingEntity
        if(updateUser.getImageUrl() != null){
            existingEntity.setImageUrl(updateUser.getImageUrl());
        }

        if(updateUser.getUserName() != null){
            existingEntity.setUserName(updateUser.getUserName());
        }
        if(updateUser.getPassword() != null){
            existingEntity.setPassword(updateUser.getPassword());
        }
        if(updateUser.getEmail() != null){
            existingEntity.setEmail(updateUser.getEmail());
        }
        if(updateUser.getDateCreated() != null){
            existingEntity.setDateCreated(updateUser.getDateCreated());
        }
        if(updateUser.getSubscription() != null){
            existingEntity.setSubscription(updateUser.getSubscription());
        }
        if(updateUser.getRole() != null){
            existingEntity.setRole(updateUser.getRole());
        }
        if(updateUser.getPaymentType() != null){
            existingEntity.setPaymentType(updateUser.getPaymentType());
        }

        // Save the updated entity back to the database
        UserEntity updatedEntity = usersRepository.save(existingEntity);

        // Map the updated entity back to UserModel and return it
        UserModel updatedUser = modelMapper.map(updatedEntity, UserModel.class);

        return updatedUser;
    }
}
