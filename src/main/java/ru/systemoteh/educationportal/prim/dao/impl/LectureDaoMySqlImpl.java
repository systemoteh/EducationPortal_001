package ru.systemoteh.educationportal.prim.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import ru.systemoteh.educationportal.prim.dao.LectureDao;
import ru.systemoteh.educationportal.prim.model.Lecture;
import ru.systemoteh.educationportal.prim.model.UserLecture;
import ru.systemoteh.educationportal.prim.model.UserTest;

import javax.persistence.*;
import java.util.List;

public class LectureDaoMySqlImpl implements LectureDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(LectureDaoMySqlImpl.class);

    @PersistenceContext(unitName = "edu_portal_prim")
    private EntityManager entityManager;

    @Override
    @Transactional(value = "edu_portal_prim")
    public boolean unblockLecture(Long userId, Long lectureId) {
        StoredProcedureQuery procedureQuery = entityManager.
                createStoredProcedureQuery("unblock_lecture")
                .registerStoredProcedureParameter(1, Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, Boolean.class, ParameterMode.OUT)
                .setParameter(1, userId)
                .setParameter(2, lectureId);
        try {
            procedureQuery.execute();
            return (boolean) procedureQuery.getOutputParameterValue(3);
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }
    }

    @Override   // TODO Переделать!!!
    @Transactional(value = "edu_portal_prim")
    public void saveLectureConspectus(String lectureConspectus) {
        entityManager.createNativeQuery(
                "UPDATE lecture SET conspectus = ? WHERE id = ?", Lecture.class)
        .setParameter(1, lectureConspectus)
        .setParameter(2, 9)
                .executeUpdate();
    }
}
