package com.example.ggwp.repositories.game;

import com.example.ggwp.models.game.GameModel;

import java.util.List;

public interface GamesDataAccessInterface <T> {

    public T getById(long id);
    public List<T> getGames();
    public List<T> searchGames(String searchTerm);

    public long addOne(T newGame);

    public long deleteOne(long id);

    public T updateOne(long idToUpdate, T gameToUpdate);
}
