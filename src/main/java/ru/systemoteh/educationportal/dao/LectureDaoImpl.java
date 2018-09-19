package ru.systemoteh.educationportal.dao;

import ru.systemoteh.educationportal.model.Lecture;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class LectureDaoImpl implements LectureDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Lecture getLectureById(Integer id) {
        return entityManager.find(Lecture.class, id);
    }

    @Override
    public Lecture getLectureByNameEng(String nameEng) {
        // TODO
        return null;
    }

    @Override
    public Lecture getLectureByNameRus(String nameRus) {
        // TODO
        return null;
    }

    @Override
    public Lecture getLectureByLink(String link) {
        Query query = entityManager.createNativeQuery("SELECT * FROM lecture WHERE link = ?", Lecture.class);
        query.setParameter(1, link);
        return (Lecture) query.getSingleResult();
    }

    @Override
    public List<Lecture> getAllLectures() {
        // TODO
        return null;
    }

    @Override
    public List<Lecture> getLecturesByCourseId(Integer courseId) {
        Query query = entityManager.createNativeQuery("SELECT * FROM lecture WHERE course_id = ?", Lecture.class);
        query.setParameter(1, courseId);
        return query.getResultList();
    }

}
