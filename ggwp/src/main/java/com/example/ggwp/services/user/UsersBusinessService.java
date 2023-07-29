package com.example.ggwp.services.user;

import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.repositories.user.UsersDataAccessInterface;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersBusinessService implements UsersBusinessServiceInterface{
//    @Autowired
    //if explicitly specify the bean name for injection, use @Resource
    @Resource
    UsersDataAccessInterface<UserModel> usersDAO;
    @Override
    public UserModel getById(long id) {
        return usersDAO.getById(id);
    }

    @Override
    public List<UserModel> getUsers() {
        return usersDAO.getUsers();
    }

    @Override
    public List<UserModel> searchUsers(String searchTerm) {
        return usersDAO.searchUsers(searchTerm);
    }

    @Override
    public long addOne(UserModel newUser) {
        return usersDAO.addOne(newUser);
    }

    @Override
    public boolean deleteOne(long id) {
        return usersDAO.deleteOne(id);
    }

    @Override
    public UserModel updateOne(long idToUpdate, UserModel updateUser) {
        return usersDAO.updateOne(idToUpdate, updateUser);
    }
}
