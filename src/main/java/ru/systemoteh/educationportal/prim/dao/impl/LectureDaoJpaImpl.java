package ru.systemoteh.educationportal.prim.dao.impl;

import ru.systemoteh.educationportal.prim.dao.LectureDao;
import ru.systemoteh.educationportal.prim.model.Lecture;
import ru.systemoteh.educationportal.prim.model.UserLecture;
import ru.systemoteh.educationportal.prim.model.UserTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LectureDaoJpaImpl implements LectureDao {

    @PersistenceContext(unitName = "edu_portal_prim")
    private EntityManager entityManager;


    @Override
    public boolean unblockLecture(Long userId, Long lectureId) {
        // TODO
        return false;
    }

    @Override
    public void saveLectureConspectus(String lectureConspectus) {
        // TODO
    }
}
