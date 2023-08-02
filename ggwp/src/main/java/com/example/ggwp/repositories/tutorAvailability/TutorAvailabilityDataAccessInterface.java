package com.example.ggwp.repositories.tutorAvailability;

import java.util.List;

public interface TutorAvailabilityDataAccessInterface<T> {

    public T getAvailabilityById(long id);
    public List<T> getAllAvailabilities();

    public List<T> getAvailabilitiesByTutorId(Long id);

    public long addAvailability(T newAvailability);

    public long deleteAvailability(long id);

    public T updateAvailability(long idToUpdate, T availabilityToUpdate);
}
