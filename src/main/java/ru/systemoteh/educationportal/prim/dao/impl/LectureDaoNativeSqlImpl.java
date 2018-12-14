package ru.systemoteh.educationportal.prim.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import ru.systemoteh.educationportal.prim.dao.LectureDao;
import ru.systemoteh.educationportal.prim.model.Lecture;
import ru.systemoteh.educationportal.prim.model.UserLecture;
import ru.systemoteh.educationportal.prim.model.UserTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;


public class LectureDaoNativeSqlImpl implements LectureDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(LectureDaoNativeSqlImpl.class);

    @PersistenceContext(unitName = "edu_portal_prim")
    private EntityManager entityManager;

    // no used
    public Lecture getLectureByLink(String link) {
        Query query = entityManager.createNativeQuery("SELECT * FROM lecture WHERE link = ?", Lecture.class);
        query.setParameter(1, link);
        return (Lecture) query.getSingleResult();
    }

    // no used
    public Lecture getLectureByCourseIdAndLectureLink(Long courseId, String lectureLink) {
        Query query = entityManager.createNativeQuery("SELECT * FROM lecture WHERE course_id = ? AND link = ?  ", Lecture.class);
        query.setParameter(1, courseId);
        query.setParameter(2, lectureLink);
        return (Lecture) query.getSingleResult();
    }

    // no used
    public List<Lecture> getLecturesByCourseId(Long courseId) {
        Query query = entityManager.createNativeQuery("SELECT * FROM lecture WHERE course_id = ?", Lecture.class);
        query.setParameter(1, courseId);
        return query.getResultList();
    }

    // no used
    public List<UserLecture> getUserLectureListByUserId(Long userId) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM user___lecture WHERE user_id = ?",
                UserLecture.class);
        query.setParameter(1, userId);
        return query.getResultList();
    }

    // no used
    public List<UserTest> getUserTestListByUserId(Long userId) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM user___test WHERE user_id = ?",
                UserTest.class);
        query.setParameter(1, userId);
        return query.getResultList();
    }

    // no used
    public UserLecture getUserLectureByUserIdAndLectureId(Long userId, Long lectureId) {
        UserLecture userLecture = (UserLecture) entityManager.createNativeQuery(
                "SELECT * FROM user___lecture " +
                        "WHERE user_id = ? AND lecture_id = ?", UserLecture.class)
                .setParameter(1, userId)
                .setParameter(2, lectureId)
                .getSingleResult();
        List<UserTest> userTestList = entityManager.createNativeQuery(
                "SELECT * FROM user___test ut " +
                        "INNER JOIN test t ON ut.test_id = t.id " +
                        "WHERE user_id = ? AND t.lecture_id = ?", UserTest.class)
                .setParameter(1, userId)
                .setParameter(2, lectureId)
                .getResultList();
        userLecture.setUserTestList(userTestList);
        return userLecture;
    }

    @Transactional(value = "edu_portal_prim")
    public boolean unblockLecture(Long userId, Long lectureId) {
        //  Check whether the database already has such a line
        Query nativeQuerySelect01 = entityManager.createNativeQuery(
                "SELECT 1 FROM user___lecture WHERE user_id = ? AND lecture_id = ?");
        nativeQuerySelect01.setParameter(1, userId);
        nativeQuerySelect01.setParameter(2, lectureId);
        try {
            if (nativeQuerySelect01.getResultList().size() > 0) {
                LOGGER.debug("This lecture is already present in the user database");
                return false;
            }
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }

        //  Check whether the database already has such are lines
        Query nativeQuerySelect02 = entityManager.createNativeQuery(
                "SELECT 1 FROM user___test ut " +
                        "INNER JOIN test t ON ut.test_id = t.id " +
                        "WHERE user_id = ? " +
                        "AND t.lecture_id = ?");
        nativeQuerySelect02.setParameter(1, userId);
        nativeQuerySelect02.setParameter(2, lectureId);
        try {
            if (nativeQuerySelect02.getResultList().size() > 0) {
                LOGGER.debug("There are tests already present in the user database");
                return false;
            }
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }


        Query nativeQuerySelect03 = entityManager.createNativeQuery(
                "SELECT coins FROM user_detail WHERE user_id = ?");
        nativeQuerySelect03.setParameter(1, userId);
        Long coins = Long.valueOf(nativeQuerySelect03.getSingleResult().toString());

        Query nativeQuerySelect04 = entityManager.createNativeQuery(
                "SELECT cost FROM lecture WHERE lecture.id = ?");
        nativeQuerySelect04.setParameter(1, lectureId);
        Long cost = Long.valueOf(nativeQuerySelect04.getSingleResult().toString());


        Query nativeQueryInsert01 = entityManager.createNativeQuery(
                "INSERT INTO user___lecture (user_id, lecture_id) VALUES (?, ?)");
        nativeQueryInsert01.setParameter(1, userId);
        nativeQueryInsert01.setParameter(2, lectureId);
        try {
            nativeQueryInsert01.executeUpdate();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }

        Query nativeQueryInsert02 = entityManager.createNativeQuery(
                "INSERT INTO user___test (user_id, test_id) " +
                        "SELECT ?, id FROM test " +
                        "WHERE test.lecture_id = ?");
        nativeQueryInsert02.setParameter(1, userId);
        nativeQueryInsert02.setParameter(2, lectureId);
        try {
            nativeQueryInsert02.executeUpdate();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }

        Query nativeQueryUpdate = entityManager.createNativeQuery(
                "UPDATE user_detail SET coins = (? - ?) WHERE user_id = ?");
        nativeQueryUpdate.setParameter(1, coins);
        nativeQueryUpdate.setParameter(2, cost);
        nativeQueryUpdate.setParameter(3, userId);
        try {
            return nativeQueryUpdate.executeUpdate() > 0;
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }
    }

    @Override
    public void saveLectureConspectus(String lectureConspectus) {
        // TODO
    }
}
