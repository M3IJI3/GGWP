package com.example.ggwp.services.tutorAvailability;
import com.example.ggwp.models.tutoring.TutorAvailabilityModel;

import java.util.List;

public interface TutorAvailabilityBusinessServiceInterface {
    public TutorAvailabilityModel getAvailabilityById(long id);
    public List<TutorAvailabilityModel> getAllAvailabilities();

    public List<TutorAvailabilityModel> getAvailabilitiesByTutorId(Long id);

    public long addAvailability(TutorAvailabilityModel newAvailability);

    public long deleteAvailability(long id);

    public TutorAvailabilityModel updateAvailability(long idToUpdate, TutorAvailabilityModel availabilityToUpdate);
}
