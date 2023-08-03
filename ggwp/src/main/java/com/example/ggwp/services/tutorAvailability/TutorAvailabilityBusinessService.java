package com.example.ggwp.services.tutorAvailability;

import com.example.ggwp.models.tutoring.TutorAvailabilityModel;
import com.example.ggwp.repositories.tutorAvailability.TutorAvailabilityDataAccessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorAvailabilityBusinessService implements TutorAvailabilityBusinessServiceInterface {

    private final TutorAvailabilityDataAccessInterface tutorAvailabilityDAO;

    @Autowired
    public TutorAvailabilityBusinessService(TutorAvailabilityDataAccessInterface tutorAvailabilityDAO) {
        this.tutorAvailabilityDAO = tutorAvailabilityDAO;
    }

    @Override
    public TutorAvailabilityModel getAvailabilityById(long id) {
        return (TutorAvailabilityModel) tutorAvailabilityDAO.getAvailabilityById(id);
    }

    @Override
    public List<TutorAvailabilityModel> getAllAvailabilities() {
        return tutorAvailabilityDAO.getAllAvailabilities();
    }

    @Override
    public List<TutorAvailabilityModel> getAvailabilitiesByTutorId(Long id) {
        return tutorAvailabilityDAO.getAvailabilitiesByTutorId(id);
    }

    @Override
    public long addAvailability(TutorAvailabilityModel newAvailability) {
        return tutorAvailabilityDAO.addAvailability(newAvailability);
    }

    @Override
    public long deleteAvailability(long id) {
        return tutorAvailabilityDAO.deleteAvailability(id);
    }

    @Override
    public TutorAvailabilityModel updateAvailability(long idToUpdate, TutorAvailabilityModel availabilityToUpdate) {
        return (TutorAvailabilityModel) tutorAvailabilityDAO.updateAvailability(idToUpdate, availabilityToUpdate);
    }
}


