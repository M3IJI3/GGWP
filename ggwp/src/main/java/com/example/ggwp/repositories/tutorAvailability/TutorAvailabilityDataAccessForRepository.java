package com.example.ggwp.repositories.tutorAvailability;

import com.example.ggwp.models.tutoring.TutorAvailabilityEntity;
import com.example.ggwp.models.tutoring.TutorAvailabilityModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TutorAvailabilityDataAccessForRepository implements TutorAvailabilityDataAccessInterface<TutorAvailabilityModel>{

    @Autowired
    TutorAvailabilityRepositoryInterface tutorAvailabilityRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public TutorAvailabilityDataAccessForRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    ModelMapper modelMapper = new ModelMapper();
    @Override
    public TutorAvailabilityModel getAvailabilityById(long id) {
        return modelMapper.map(tutorAvailabilityRepository.findById(id), TutorAvailabilityModel.class);
    }

    @Override
    public List<TutorAvailabilityModel> getAllAvailabilities() {
        Iterable<TutorAvailabilityEntity> availabilityEntities =  tutorAvailabilityRepository.findAll();
        List<TutorAvailabilityModel> availabilityModels = new ArrayList<TutorAvailabilityModel>();

        for (TutorAvailabilityEntity availability: availabilityEntities) {
            availabilityModels.add(modelMapper.map(availability, TutorAvailabilityModel.class));
        }

        return availabilityModels;
    }

    @Override
    public List<TutorAvailabilityModel> getAvailabilitiesByTutorId(Long id) {
        Iterable<TutorAvailabilityEntity> availabilityEntities =  tutorAvailabilityRepository.getTutorAvailabilityEntitiesByTutorId(id);
        List<TutorAvailabilityModel> availabilityModels = new ArrayList<TutorAvailabilityModel>();

        for (TutorAvailabilityEntity availability: availabilityEntities) {
            availabilityModels.add(modelMapper.map(availability, TutorAvailabilityModel.class));
        }

        return availabilityModels;
    }

    @Override
    public long addAvailability(TutorAvailabilityModel newAvailability) {
        tutorAvailabilityRepository.save(modelMapper.map(newAvailability, TutorAvailabilityEntity.class));
        return 1;
    }

    @Override
    public long deleteAvailability(long id) {
        TutorAvailabilityEntity entity = tutorAvailabilityRepository.findById(id).orElse(null);
        if (entity != null) {
            tutorAvailabilityRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    @Override
    public TutorAvailabilityModel updateAvailability(long idToUpdate, TutorAvailabilityModel availabilityToUpdate) {
        TutorAvailabilityEntity existingAvailability = tutorAvailabilityRepository.findById(idToUpdate).orElse(null);

        if (existingAvailability != null) {
            existingAvailability.setDayOfWeek(availabilityToUpdate.getDayOfWeek());
            existingAvailability.setStartTime(availabilityToUpdate.getStartTime());
            existingAvailability.setEndTime(availabilityToUpdate.getEndTime());

            return modelMapper.map(tutorAvailabilityRepository.save(existingAvailability), TutorAvailabilityModel.class);
        }

        return null;
    }
}
