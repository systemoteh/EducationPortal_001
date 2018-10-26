package ru.systemoteh.educationportal.prim.dao.impl;

import ru.systemoteh.educationportal.prim.dao.LectureDao;
import ru.systemoteh.educationportal.prim.model.Lecture;
import ru.systemoteh.educationportal.prim.model.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LectureDaoJpaImpl implements LectureDao {

    @PersistenceContext(unitName = "edu_portal_prim")
    private EntityManager entityManager;

    public Lecture getLectureById(Integer id) {
        return entityManager.find(Lecture.class, id);
    }

    @Override
    public List<Lecture> getUserLectureListByUserId(Long userId) {
        // TODO
        return null;
    }

    @Override
    public List<Test> getUserTestListByUserId(Long userId) {
        // TODO
        return null;
    }

    @Override
    public boolean unblockLecture(Long userId, int lectureId) {
        // TODO
        return false;
    }

}
