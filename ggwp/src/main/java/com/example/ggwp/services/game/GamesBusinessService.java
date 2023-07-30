package com.example.ggwp.services.game;


import com.example.ggwp.models.game.GameModel;
import com.example.ggwp.repositories.game.GamesDataAccessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesBusinessService implements GamesBusinessServiceInterface {

    @Autowired
    GamesDataAccessInterface<GameModel> gamesDAO;


    @Override
    public GameModel getById(long id) {
        return gamesDAO.getById(id);
    }

    @Override
    public List<GameModel> getGames() {
        return gamesDAO.getGames();
    }

    @Override
    public List<GameModel> searchGames(String searchTerm) {
        return gamesDAO.searchGames(searchTerm);
    }

    @Override
    public long addOne(GameModel newGame) {
        return gamesDAO.addOne(newGame);
    }

    @Override
    public long deleteOne(long id) {
        return gamesDAO.deleteOne(id);
    }

    @Override
    public GameModel updateOne(long idToUpdate, GameModel gameToUpdate) {
        return gamesDAO.updateOne(idToUpdate, gameToUpdate);
    }
}
