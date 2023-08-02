package com.example.ggwp.services.user;

import com.example.ggwp.models.user.UserModel;

import java.util.List;

public interface UsersBusinessServiceInterface {

     UserModel getById(long id);
     List<UserModel> getUsers();
     List<UserModel> searchUsers(String searchTerm);
     long addOne(UserModel newUser);
     boolean deleteOne(long id);
     UserModel updateOne(long idToUpdate, UserModel updateUser);

     UserModel getByUsername(String username);
}
