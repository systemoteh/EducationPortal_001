package ru.systemoteh.educationportal.prim.dao.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.systemoteh.educationportal.prim.dao.LectureDao;
import ru.systemoteh.educationportal.prim.dao.UserDao;
import ru.systemoteh.educationportal.prim.model.Lecture;
import ru.systemoteh.educationportal.prim.model.Test;

import javax.persistence.*;
import java.util.List;

public class LectureDaoMySqlImpl implements LectureDao {

    @PersistenceContext(unitName = "edu_portal_prim")
    private EntityManager entityManager;

    private LectureDao lectureDao;

    public void setLectureDao(LectureDao lectureDao) {
        this.lectureDao = lectureDao;
    }

    @Override
    public List<Lecture> getUserLectureListByUserId(Long userId) {
        return lectureDao.getUserLectureListByUserId(userId);
    }

    @Override
    public List<Test> getUserTestListByUserId(Long userId) {
        return lectureDao.getUserTestListByUserId(userId);
    }

    @Override
    @Transactional(value = "edu_portal_prim")
    public boolean unblockLecture(Long userId, int lectureId) {
        StoredProcedureQuery procedureQuery = entityManager.
                createStoredProcedureQuery("unblock_lecture")
                .registerStoredProcedureParameter(1, Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, Boolean.class, ParameterMode.OUT)
                .setParameter(1, userId)
                .setParameter(2, lectureId);
        try {
            procedureQuery.execute();
            return (boolean) procedureQuery.getOutputParameterValue(3);
        } catch (PersistenceException e) {
            return false;   // TODO LOGGER
        }
    }

}
