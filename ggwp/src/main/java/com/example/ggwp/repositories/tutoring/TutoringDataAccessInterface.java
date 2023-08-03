package com.example.ggwp.repositories.tutoring;

import java.util.List;

public interface TutoringDataAccessInterface <T> {

    public T getTutorById(long id);
    public List<T> getTutors();

    public long addTutor(T newTutor);

    public long deleteTutor(long id);

    public T updateTutor(long idToUpdate, T tutorToUpdate);

}
