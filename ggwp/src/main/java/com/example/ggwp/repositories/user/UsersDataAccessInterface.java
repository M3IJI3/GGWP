package com.example.ggwp.repositories.user;

import java.util.List;

public interface UsersDataAccessInterface<T> {
     T getById(long id);
     List<T> getUsers();
     List<T> searchUsers(String searchTerm);
     long addOne(T newUser);
     boolean deleteOne(long id);
     T updateOne(long idToUpdate, T updateUser);

     T getByUsername(String username);
}
