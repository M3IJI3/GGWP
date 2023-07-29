package com.example.ggwp.services.user;

import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.repositories.user.UserLoginRegistrationForRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginRegistrationService implements UserLoginRegistrationServiceInterface {

    @Autowired
    UserLoginRegistrationForRepository userLoginRegDAO;

    @Override
    public boolean LoginCheck(String email, String password, List<UserModel> users) {
        for(UserModel user : users)
        {
            if(email.equals(user.getEmail()) && password.equals(user.getPassword()))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean DuplicatedEmailCheck(String email, List<UserModel> users) {
        for(UserModel user : users)
        {
            if(email.equals(user.getEmail()))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean DuplicatedUsernameCheck(String username, List<UserModel> users) {
        for(UserModel user : users)
        {
            if(username.equals(user.getUserName()))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public UserModel getById(long id) {
        return userLoginRegDAO.getById(id);
    }

    @Override
    public List<UserModel> getUsers() {
        return userLoginRegDAO.getUsers();
    }

    @Override
    public long addOne(UserModel newUser) {
        return userLoginRegDAO.addOne(newUser);
    }

}
