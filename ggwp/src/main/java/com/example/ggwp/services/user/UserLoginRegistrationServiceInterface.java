package com.example.ggwp.services.user;


import com.example.ggwp.models.user.UserModel;

import java.util.List;

public interface UserLoginRegistrationServiceInterface {
    // for Login use
    boolean LoginCheck(String email, String password, List<UserModel> users);

    // for registration
    boolean DuplicatedEmailCheck(String email, List<UserModel> users);

    boolean DuplicatedUsernameCheck(String username, List<UserModel> users);

    UserModel getById(long id);

    List<UserModel> getUsers();

    long addOne(UserModel newUser);

    UserModel getByEmail(String param, List<UserModel> objects);
}
