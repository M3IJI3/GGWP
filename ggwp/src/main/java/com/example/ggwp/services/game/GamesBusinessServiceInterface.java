package com.example.ggwp.services.game;

import com.example.ggwp.models.game.GameModel;

import java.util.List;

public interface GamesBusinessServiceInterface {

    public GameModel getById(long id);
    public List<GameModel> getGames();
    public List<GameModel> searchGames(String searchTerm);

    public long addOne(GameModel newGame);

    public long deleteOne(long id);

    public GameModel updateOne(long idToUpdate, GameModel gameToUpdate);


}
