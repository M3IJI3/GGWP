package com.example.ggwp.services.tutoring;

import com.example.ggwp.models.tutoring.TutoringModel;

import java.util.List;

public interface TutoringBusinessServiceInterface {
    public TutoringModel getTutorById(long id);
    public List<TutoringModel> getTutors();

    public long addTutor(TutoringModel newTutor);

    public long deleteTutor(long id);

    public TutoringModel updateTutor(long idToUpdate, TutoringModel tutorToUpdate);

}
