package com.example.ggwp.controllers.user;

import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.services.user.UsersBusinessServiceInterface;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

//    @Autowired
    @Resource
    UsersBusinessServiceInterface userBusinessService;

    @GetMapping("/")
    public List<UserModel> showAllUsers(Model model){
        List<UserModel> users = userBusinessService.getUsers();

        return users;
    }

    @GetMapping("/search/{searchTerm}")
    public List<UserModel> searchUsers(@PathVariable(name="searchTerm") String searchTerm){
        List<UserModel> users = userBusinessService.searchUsers(searchTerm);

        return users;
    }

    @PostMapping("/")
    // model is passed from postman by the @RequestBody
    public long addUser(@RequestBody UserModel model) {
        return userBusinessService.addOne(model);
    }

    @GetMapping("/{id}")
    public UserModel getById(@PathVariable(name="id") long id){

        return userBusinessService.getById(id);
    }

    @PostMapping("/delete/{id}")
    public boolean deleteOne(@PathVariable("id") long id){

        return userBusinessService.deleteOne(id);
    }

    @PutMapping("/update/{id}")
    public UserModel update(@RequestBody UserModel model, @PathVariable("id") long id) {
        return userBusinessService.updateOne(id, model);
    }
}
