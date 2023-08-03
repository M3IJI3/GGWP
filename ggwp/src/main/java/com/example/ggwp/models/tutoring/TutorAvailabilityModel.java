package com.example.ggwp.models.tutoring;

    import java.time.LocalTime;

public class TutorAvailabilityModel {
    long id;
    long tutorId;
    String dayOfWeek;
    LocalTime startTime;
    LocalTime endTime;

    public TutorAvailabilityModel() {

    }

    public TutorAvailabilityModel(long id, long tutorId, String dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.tutorId = tutorId;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTutorId() {
        return tutorId;
    }

    public void setTutorId(long tutorId) {
        this.tutorId = tutorId;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
