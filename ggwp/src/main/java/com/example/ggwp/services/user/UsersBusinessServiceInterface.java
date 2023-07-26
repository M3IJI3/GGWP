package com.example.ggwp.services.user;

import com.example.ggwp.models.user.UserModel;

import java.util.List;

public interface UsersBusinessServiceInterface {

    public UserModel getById(long id);
    public List<UserModel> getUsers();
    public List<UserModel> searchUsers(String searchTerm);

    public long addOne(UserModel newUser);

    public boolean deleteOne(long id);

    public UserModel updateOne(long idToUpdate, UserModel updateUser);
}
