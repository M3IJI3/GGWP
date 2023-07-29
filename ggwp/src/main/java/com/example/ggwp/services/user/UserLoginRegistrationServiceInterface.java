package com.example.ggwp.services.user;


import com.example.ggwp.models.user.UserModel;

import java.util.List;

public interface UserLoginRegistrationServiceInterface {
    // for Login use
    boolean LoginCheck(String email, String password, List<UserModel> users);

    // for registration
    boolean Registration(UserModel userModel);

    UserModel getById(long id);

    List<UserModel> getUsers();
}
