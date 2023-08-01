package com.example.ggwp.services.tutoring;

import com.example.ggwp.models.tutoring.TutoringModel;
import com.example.ggwp.repositories.tutoring.TutoringDataAccessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutoringBusinessService implements TutoringBusinessServiceInterface {

    @Autowired
    TutoringDataAccessInterface<TutoringModel> tutoringDAO;
    @Override
    public TutoringModel getTutorById(long id) {
        return tutoringDAO.getTutorById(id);
    }

    @Override
    public List<TutoringModel> getTutors() {
        return tutoringDAO.getTutors();
    }

    @Override
    public long addTutor(TutoringModel newTutor) {
        return tutoringDAO.addTutor(newTutor);
    }

    @Override
    public long deleteTutor(long id) {
        return tutoringDAO.deleteTutor(id);
    }

    @Override
    public TutoringModel updateTutor(long idToUpdate, TutoringModel tutorToUpdate) {
        return tutoringDAO.updateTutor(idToUpdate, tutorToUpdate);
    }
}
