package com.example.ggwp.repositories.tutorAvailability;

import com.example.ggwp.models.tutoring.TutorAvailabilityEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TutorAvailabilityRepositoryInterface extends CrudRepository<TutorAvailabilityEntity, Long> {

    List<TutorAvailabilityEntity> getTutorAvailabilityEntitiesByTutorId(Long id);
}
