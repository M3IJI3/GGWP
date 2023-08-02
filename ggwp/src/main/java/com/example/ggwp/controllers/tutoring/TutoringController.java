package com.example.ggwp.controllers.tutoring;

import com.example.ggwp.models.game.GameModel;
import com.example.ggwp.models.tutoring.TutorAvailabilityModel;
import com.example.ggwp.models.tutoring.TutoringModel;
import com.example.ggwp.models.user.UserModel;
import com.example.ggwp.services.game.GamesBusinessServiceInterface;
import com.example.ggwp.services.tutorAvailability.TutorAvailabilityBusinessServiceInterface;
import com.example.ggwp.services.tutoring.TutoringBusinessServiceInterface;
import com.example.ggwp.services.user.UsersBusinessService;
import com.example.ggwp.services.user.UsersBusinessServiceInterface;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
    private final TutoringBusinessServiceInterface tutoringBusinessService;
    private final TutorAvailabilityBusinessServiceInterface tutorAvailabilityBusinessService;
    private final UsersBusinessServiceInterface usersBusinessService;
    private final GamesBusinessServiceInterface gamesBusinessService;

    @Autowired // in the constructor to avoid circular dependency issue
    public TutoringController(TutoringBusinessServiceInterface tutoringBusinessService,
                              TutorAvailabilityBusinessServiceInterface tutorAvailabilityBusinessService,
                              UsersBusinessServiceInterface usersBusinessService,
                              GamesBusinessServiceInterface gamesBusinessService) {
        this.tutoringBusinessService = tutoringBusinessService;
        this.tutorAvailabilityBusinessService = tutorAvailabilityBusinessService;
        this.usersBusinessService = usersBusinessService;
        this.gamesBusinessService = gamesBusinessService;
    }

    @GetMapping("/")
    public String showAllTutors(Model model) {
        List<TutoringModel> tutors = tutoringBusinessService.getTutors();

        for (TutoringModel tutor : tutors) {
            UserModel user = usersBusinessService.getById(tutor.getId());
            GameModel game = gamesBusinessService.getById(tutor.getGameId());
            tutor.setAvailabilities(tutorAvailabilityBusinessService.getAllAvailabilities());
            tutor.setTutorName(user.getUserName());
            tutor.setGameName(game.getTitle());

        }

        model.addAttribute("tutors", tutors);

        return "tutors_page";
    }
}

