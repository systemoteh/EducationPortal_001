package ru.systemoteh.educationportal.prim.dao.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.systemoteh.educationportal.prim.dao.LectureDao;
import ru.systemoteh.educationportal.prim.model.Lecture;
import ru.systemoteh.educationportal.prim.model.UserLecture;
import ru.systemoteh.educationportal.prim.model.UserTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.util.List;


public class LectureDaoNativeSqlImpl implements LectureDao {

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

    public List<UserLecture> getUserLectureListByUserId(Long userId) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM user___lecture WHERE user_id = ?",
                UserLecture.class);
        query.setParameter(1, userId);
        return query.getResultList();
    }

    @Override
    public List<UserTest> getUserTestListByUserId(Long userId) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM user___test WHERE user_id = ?",
                UserTest.class
        );
        query.setParameter(1, userId);
        return query.getResultList();
    }

    @Transactional(value = "edu_portal_prim")
    public boolean unblockLecture(Long userId, Long lectureId) {
        //  Check whether the database already has such a line
        Query nativeQuerySelect01 = entityManager.createNativeQuery(
                "SELECT 1 FROM user___lecture WHERE user_id = ? AND lecture_id = ?"
        );
        nativeQuerySelect01.setParameter(1, userId);
        nativeQuerySelect01.setParameter(2, lectureId);
        try {
            if (nativeQuerySelect01.getResultList().size() > 0) {
                return false;
            }
        } catch (PersistenceException e) {
            return false;   // TODO LOGGER
        }

        Query nativeQuerySelect02 = entityManager.createNativeQuery(
                "SELECT coins FROM user_detail WHERE user_id = ?"
        );
        nativeQuerySelect02.setParameter(1, userId);

        Query nativeQuerySelect03 = entityManager.createNativeQuery(
                "SELECT cost FROM lecture WHERE lecture.id = ?"
        );
        nativeQuerySelect03.setParameter(1, lectureId);

        Query nativeQueryUpdate = entityManager.createNativeQuery(
                "UPDATE user_detail SET coins = (? - ?) WHERE user_id = ?"
        );
        nativeQueryUpdate.setParameter(1, nativeQuerySelect02.getSingleResult());
        nativeQueryUpdate.setParameter(2, nativeQuerySelect03.getSingleResult());
        nativeQueryUpdate.setParameter(3, userId);
        try {
            nativeQueryUpdate.executeUpdate();
        } catch (PersistenceException e) {
            return false;   // TODO LOGGER
        }

        String queryInsert = "INSERT INTO user___lecture (user_id, lecture_id) VALUES (?, ?)";
        Query nativeQueryInsert = entityManager.createNativeQuery(queryInsert);
        nativeQueryInsert.setParameter(1, userId);
        nativeQueryInsert.setParameter(2, lectureId);
        try {
            return nativeQueryInsert.executeUpdate() > 0;
        } catch (PersistenceException e) {
            return false;   // TODO LOGGER
        }
    }

}
