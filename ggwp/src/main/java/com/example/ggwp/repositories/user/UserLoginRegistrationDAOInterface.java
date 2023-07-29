package com.example.ggwp.repositories.user;


import com.example.ggwp.models.user.UserModel;

import java.util.List;

public interface UserLoginRegistrationDAOInterface<T> {

    T getById(long id);
    List<T> getUsers();
    long addOne(T newUser);
}
