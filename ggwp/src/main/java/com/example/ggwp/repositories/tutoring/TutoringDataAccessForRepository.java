package com.example.ggwp.repositories.tutoring;

import com.example.ggwp.models.tutoring.TutoringEntity;
import com.example.ggwp.models.tutoring.TutoringModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Repository
public class TutoringDataAccessForRepository implements TutoringDataAccessInterface<TutoringModel> {

    @Autowired
    TutoringRepositoryInterface tutoringRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    ModelMapper modelMapper = new ModelMapper();



    public TutoringDataAccessForRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public TutoringModel getTutorById(long id) {

        TutoringEntity tutoringEntity = tutoringRepository.findById(id).orElse(null);
        return modelMapper.map(tutoringEntity, TutoringModel.class); // Map to model
    }
    @Override
    public List<TutoringModel> getTutors() {
        Iterable<TutoringEntity> tutoringEntities =  tutoringRepository.findAll();
        List<TutoringModel> tutoringModels = new ArrayList<TutoringModel>();

        for (TutoringEntity tutor: tutoringEntities) {
            tutoringModels.add(modelMapper.map(tutor, TutoringModel.class));
        }

        return tutoringModels;
    }

    @Override
    public long addTutor(TutoringModel newTutor) {
        tutoringRepository.save(modelMapper.map(newTutor, TutoringEntity.class));
        return 1;
    }

    @Override
    public long deleteTutor(long id) {
        TutoringEntity entity = tutoringRepository.findById(id).orElse(null);
        if (entity != null) {
            tutoringRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    @Override
    public TutoringModel updateTutor(long idToUpdate, TutoringModel tutorToUpdate) {
        TutoringEntity existingTutor = tutoringRepository.findById(idToUpdate).orElse(null);

        if (existingTutor != null) {
           existingTutor.setDescription(tutorToUpdate.getDescription());
           existingTutor.setGameId(tutorToUpdate.getGameId());
           existingTutor.setPrice(tutorToUpdate.getPrice());
           existingTutor.setTutorAvailabilityId(tutorToUpdate.getTutorAvailabilityId());
           existingTutor.setRank(tutorToUpdate.getRank());

            return modelMapper.map(tutoringRepository.save(existingTutor), TutoringModel.class);
        }

        return null;
    }
}
