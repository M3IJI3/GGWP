package com.example.ggwp.controllers.tutoring;

import com.example.ggwp.models.game.GameModel;
import com.example.ggwp.models.tutoring.TutorAvailabilityModel;
import com.example.ggwp.models.tutoring.TutoringModel;
import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.services.game.GamesBusinessServiceInterface;
import com.example.ggwp.services.tutoring.TutoringBusinessServiceInterface;
import com.example.ggwp.services.user.UsersBusinessService;
import com.example.ggwp.services.user.UsersBusinessServiceInterface;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tutors")
public class TutoringController {
    @Resource
    TutoringBusinessServiceInterface tutoringBusinessService;

    @Resource
    UsersBusinessServiceInterface usersBusinessService;

    @Resource
    GamesBusinessServiceInterface gamesBusinessService;

    @GetMapping("/")
    public String showAllTutors(Model model) {
        List<TutoringModel> tutors = tutoringBusinessService.getTutors();



        List<TutorAvailabilityModel> availabilities = new ArrayList<>();
        availabilities.add(new TutorAvailabilityModel(0, 38, "Wednesday", LocalTime.now(), LocalTime.now()));
        availabilities.add(new TutorAvailabilityModel(2, 38, "Friday", LocalTime.now(), LocalTime.now()));
        availabilities.add(new TutorAvailabilityModel(3, 36, "Saturday", LocalTime.now(), LocalTime.now()));
        availabilities.add(new TutorAvailabilityModel(3, 36, "Sunday", LocalTime.now(), LocalTime.now()));


        for (TutoringModel tutor : tutors) {
            UserModel user = usersBusinessService.getById(tutor.getId());
            GameModel game = gamesBusinessService.getById(tutor.getGameId());
            tutor.setAvailabilities(availabilities);
            tutor.setTutorName(user.getUserName());
            tutor.setGameName(game.getTitle());

        }

        model.addAttribute("tutors",tutors);

        return "tutors_page";
    }
}
