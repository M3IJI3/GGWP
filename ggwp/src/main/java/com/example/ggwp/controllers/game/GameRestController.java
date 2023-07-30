package com.example.ggwp.controllers.game;

import com.example.ggwp.models.game.GameModel;
import com.example.ggwp.services.game.GamesBusinessServiceInterface;
import jakarta.annotation.Resource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
public class GameRestController {
    @Resource
    GamesBusinessServiceInterface gameBusinessService;

    @GetMapping("/")
    public List<GameModel> showAllGames(Model model){
        return gameBusinessService.getGames();

    }

    @GetMapping("/search/{searchTerm}")
    public List<GameModel> showSearchedGames(@PathVariable(name ="searchTerm") String searchTerm) {
        return gameBusinessService.searchGames(searchTerm);
    }


    //The routes from below all get the model from postman body request

    // Create a new game
    @PostMapping("/create")
    public long addUser(@RequestBody GameModel model) {
        return gameBusinessService.addOne(model);
    }

    // Update an existing game
    @PutMapping("/{id}")
    public GameModel updateGame(@PathVariable Long id, @RequestBody GameModel updatedGame) {
        return gameBusinessService.updateOne(id, updatedGame);
    }

    // Delete a game by ID
    @DeleteMapping("/delete/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameBusinessService.deleteOne(id);
    }

}
