package com.example.ggwp.controllers.admin;

import com.example.ggwp.models.SearchModel;
import com.example.ggwp.models.game.GameModel;
import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.services.game.GamesBusinessServiceInterface;
import com.example.ggwp.services.user.UsersBusinessServiceInterface;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

//    @Autowired
    @Resource
    UsersBusinessServiceInterface userBusinessService;

    @Resource
    GamesBusinessServiceInterface gameBusinessService;

    @GetMapping("/")
    public String showAdminPage(Model model) {
        List<UserModel> users = userBusinessService.getUsers();
        model.addAttribute("title", "User List");
        model.addAttribute("users", users);
//        SearchModel searchModel = new SearchModel(); // Create a new instance of the SearchModel
//        model.addAttribute("searchModel", searchModel); // Add the searchModel to the model
        return "admin_users";
    }

    @GetMapping("/showSearchForm")
    public String showSearchForm(Model model){

        model.addAttribute("searchModel", new SearchModel());
        return "admin_searchForm";
    }

    @PostMapping("/search")
    public String search(SearchModel searchModel, Model model) {
        String searchTerm = searchModel.getSearchTerm();

        List<UserModel> users = userBusinessService.searchUsers(searchTerm);

        model.addAttribute("users", users);

        return "admin_users";
    }

    @GetMapping("/showNewUserForm")
    public String showNewForm(Model model) {

        // pass in an empty UserModel except default timestamp to the form
        UserModel newUser = new UserModel();
        newUser.setDateCreated(LocalDate.now());
        model.addAttribute("user", newUser);

        return "admin_addNewUserForm";
    }

    @PostMapping("/addNew")
    public String addNew(UserModel newUser, Model model) {

        // add to the db
        userBusinessService.addOne(newUser);
        // get all orders from db
        List<UserModel> users = userBusinessService.getUsers();
        // show all orders page

        model.addAttribute("users", users);

        return "admin_users";
    }

    // for editing
    @PostMapping("/editForm")
    public String displayEditForm(UserModel userModel, Model model) {

        model.addAttribute("title", "Edit user");
        model.addAttribute("userModel", userModel);
        return "admin_editForm";
    }

    @PostMapping("/doUpdate")
    public String updateOrder(UserModel userModel, Model model) {

        // Check if the imageUrl is blank or null, then set the default value
        if (userModel.getImageUrl() == null || userModel.getImageUrl().trim().isEmpty()) {
            userModel.setImageUrl("https://cdn-icons-png.flaticon.com/512/3177/3177440.png");
        }
        userBusinessService.updateOne(userModel.getUserId(), userModel);

        List<UserModel> users = userBusinessService.getUsers();

        model.addAttribute("users", users);

        return "admin_users";
    }

    @PostMapping("/delete")
    public String deleteUser(UserModel userModel, Model model) {
        userBusinessService.deleteOne(userModel.getUserId());

        List<UserModel> users = userBusinessService.getUsers();

        model.addAttribute("users", users);

        return "admin_users";
    }


    // Games ADMIN methods

    @GetMapping("/games")
    public String showAllGames(Model model){
        List<GameModel> games = gameBusinessService.getGames();
        model.addAttribute("games", games);
        return "admin_games" ;
    }

    @GetMapping("/games/addForm")
    public String showAddForm(Model model) {
        GameModel newGame = new GameModel();
//        newGame.setReleaseDate(new Date());
        model.addAttribute("game", newGame);
        return "admin_addNewGame" ;
    }


    @PostMapping("/games/add")
    public String addGame(@ModelAttribute GameModel newGame,  Model model) {


        // Convert the string date to a Date object using @DateTimeFormat
        Date releaseDate = newGame.getReleaseDate();
        model.addAttribute("releaseDate", releaseDate);

        newGame.setGameCoverImgUrl("/img/game-covers/celeste-cover.png"); // Celeste pic default for now, while we still figure out files uploads.

        // add to the db
        gameBusinessService.addOne(newGame);

        // get all games from db
        List<GameModel> games = gameBusinessService.getGames();

        // show all games page
        model.addAttribute("games", games);

        return "admin_games";
    }


    // Delete a game by ID
    @PostMapping("games/delete")
    public String deleteGame(Model model, GameModel game) {
        gameBusinessService.deleteOne(game.getGameId()  );
        List<GameModel> games = gameBusinessService.getGames();

        model.addAttribute("games", games);

        return "admin_games";
    }

}
