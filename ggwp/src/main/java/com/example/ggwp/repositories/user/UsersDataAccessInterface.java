package com.example.ggwp.repositories.user;

import java.util.List;

public interface UsersDataAccessInterface<T> {

    public T getById(long id);
    public List<T> getUsers();
    public List<T> searchUsers(String searchTerm);

    public long addOne(T newUser);

    public boolean deleteOne(long id);

    public T updateOne(long idToUpdate, T updateUser);
}
