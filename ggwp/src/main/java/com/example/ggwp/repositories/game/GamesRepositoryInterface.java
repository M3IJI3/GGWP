package com.example.ggwp.repositories.game;

import com.example.ggwp.models.game.GameEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GamesRepositoryInterface extends CrudRepository<GameEntity, Long> {

    List<GameEntity> findByTitleContainingIgnoreCase(String searchTerm);

}
