package com.example.ggwp.controllers.game;

import com.example.ggwp.models.forum.ForumArticleModel;
import com.example.ggwp.models.forum.ForumModel;
import com.example.ggwp.models.game.GameModel;
import com.example.ggwp.services.article.ArticleServiceInterface;
import com.example.ggwp.services.forum.ForumService;
import com.example.ggwp.services.forum.ForumServiceInterface;
import com.example.ggwp.services.game.GamesBusinessServiceInterface;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/library")
public class GameController {
    @Resource
    GamesBusinessServiceInterface gameBusinessService;

    @Resource
    ForumServiceInterface forumServiceInterface;

    @Resource
    ArticleServiceInterface articleServiceInterface;

    @GetMapping("/")
    public String showAllGames(Model model){
        List<GameModel> games = gameBusinessService.getGames();
        model.addAttribute("games", games);
        System.out.println(games);
        return "library" ;
    }

    @GetMapping("/search/{searchTerm}")
    public List<GameModel> showSearchedGames(@PathVariable(name ="searchTerm") String searchTerm) {
        return gameBusinessService.searchGames(searchTerm);
    }


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

    @GetMapping("/{title}")
    public String showForumPage(Model model, @PathVariable(name = "title") String title)
    {
        ForumModel forumModel = forumServiceInterface.getByForumTitle(title);
        model.addAttribute("forumModel", forumModel);


        List<ForumArticleModel> forumArticleModelList =
                articleServiceInterface.getAllArticlesByForumId(forumModel.getForumId());
        model.addAttribute("forumArticles", forumArticleModelList);


        return "forum";
    }
}
