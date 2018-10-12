package ru.systemoteh.educationportal.dao.impl;

import ru.systemoteh.educationportal.dao.LectureDao;
import ru.systemoteh.educationportal.model.Lecture;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class LectureDaoJpaImpl implements LectureDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Lecture getLectureById(Integer id) {
        return entityManager.find(Lecture.class, id);
    }

    @Override
    public boolean unblockLecture(Long userId, int lectureId) {
        // TODO
        return false;
    }
}
