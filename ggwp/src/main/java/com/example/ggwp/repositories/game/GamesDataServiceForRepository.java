package com.example.ggwp.repositories.game;

import com.example.ggwp.models.game.GameEntity;
import com.example.ggwp.models.game.GameModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Repository
public class GamesDataServiceForRepository implements GamesDataAccessInterface<GameModel> {

    @Autowired
    GamesRepositoryInterface gamesRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public GamesDataServiceForRepository(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public GameModel getById(long id) {
        GameEntity gameEntity = gamesRepository.findById(id).orElse(null);
        return modelMapper.map(gameEntity, GameModel.class); // Map to model
    }

    @Override
    public List<GameModel> getGames() {
        Iterable<GameEntity> gamesEntities =  gamesRepository.findAll();
        List<GameModel> gameModels = new ArrayList<GameModel>();

        for (GameEntity game: gamesEntities) {
            gameModels.add(modelMapper.map(game, GameModel.class));
        }

        return gameModels;
    }

    @Override
    public List<GameModel> searchGames(String searchTerm) {

        Iterable<GameEntity> gamesEntities = gamesRepository.findByTitleContainingIgnoreCase(searchTerm);
        List<GameModel> gameModels = new ArrayList<GameModel>();

        for (GameEntity game: gamesEntities) {
            gameModels.add(modelMapper.map(game, GameModel.class));
        }

        return gameModels;
    }

    @Override
    public long addOne(GameModel newGame) {
        gamesRepository.save(modelMapper.map(newGame, GameEntity.class));
        return 1;
    }

    @Override
    public long deleteOne(long id) {
        GameEntity entity = gamesRepository.findById(id).orElse(null);
        if (entity != null) {
            gamesRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    @Override
    public GameModel updateOne(long idToUpdate, GameModel gameToUpdate) {
        GameEntity existingGame = gamesRepository.findById(idToUpdate).orElse(null);

        if (existingGame != null) {
            existingGame.setTitle(gameToUpdate.getTitle());
            existingGame.setDescription(gameToUpdate.getDescription());
            existingGame.setReleaseDate(gameToUpdate.getReleaseDate());
            existingGame.setGameCoverImgUrl(gameToUpdate.getGameCoverImgUrl());

            return modelMapper.map(gamesRepository.save(existingGame), GameModel.class);
        }

        return null;
    }
}
