package ru.systemoteh.educationportal.dao.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.systemoteh.educationportal.dao.LectureDao;

import javax.persistence.*;

public class LectureDaoMySqlImpl implements LectureDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
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
