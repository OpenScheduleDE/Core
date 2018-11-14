package de.openschedule.core.cover;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Cover {

    @Id
    public String id;

    public String hours;
    public String grades;
    public String subject;
    public String teacher;
    public String room;
    public String coverTeacher;
    public String coverSubject;
    public String coverRoom;
    public String reason;
    public LocalDate day = LocalDate.now();

    public void setHours(String hours) {
        this.hours = hours;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setCoverTeacher(String coverTeacher) {
        this.coverTeacher = coverTeacher;
    }

    public void setCoverSubject(String coverSubject) {
        this.coverSubject = coverSubject;
    }

    public void setCoverRoom(String coverRoom) {
        this.coverRoom = coverRoom;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return String.format(
                "Cover[id=%s, hours='%s', grades='%s', subject='%s', teacher='%s', room='%s', coverTeacher='%s', coverSubject='%s', coverRoom='%s', reason='%s', day='%s']",
                this.id,
                this.hours,
                this.grades,
                this.subject,
                this.teacher,
                this.room,
                this.coverTeacher,
                this.coverSubject,
                this.coverRoom,
                this.reason,
                this.day
        );
    }
}
