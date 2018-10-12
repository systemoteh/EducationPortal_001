package ru.systemoteh.educationportal.dao.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.systemoteh.educationportal.dao.LectureDao;
import ru.systemoteh.educationportal.model.Lecture;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

public class LectureDaoNativeSqlImpl implements LectureDao {

    @PersistenceContext
    private EntityManager entityManager;

    // no used
    public Lecture getLectureByLink(String link) {
        Query query = entityManager.createNativeQuery("SELECT * FROM lecture WHERE link = ?", Lecture.class);
        query.setParameter(1, link);
        return (Lecture) query.getSingleResult();
    }

    // no used
    public Lecture getLectureByCourseIdAndLectureLink(Integer courseId, String lectureLink) {
        Query query = entityManager.createNativeQuery("SELECT * FROM lecture WHERE course_id = ? AND link = ?  ", Lecture.class);
        query.setParameter(1, courseId);
        query.setParameter(2, lectureLink);
        return (Lecture) query.getSingleResult();
    }

    // no used
    public List<Lecture> getLecturesByCourseId(Integer courseId) {
        Query query = entityManager.createNativeQuery("SELECT * FROM lecture WHERE course_id = ?", Lecture.class);
        query.setParameter(1, courseId);
        return query.getResultList();
    }

    // no used
    public List<Lecture> getUserLectureListByUserId(Long userId) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM lecture l " +
                        "INNER JOIN user_lecture ul " +
                        "ON l.id = ul.lecture_id " +
                        "WHERE ul.user_id = ?;"
                , Lecture.class);
        query.setParameter(1, userId);
        return query.getResultList();
    }

    @Transactional
    public boolean unblockLecture(Long userId, int lectureId) {
        //  Check whether the database already has such a line
        String querySelect = "SELECT 1 FROM user___lecture WHERE user_id = ? AND lecture_id = ?";
        Query nativeQuerySelect = entityManager.createNativeQuery(querySelect);
        nativeQuerySelect.setParameter(1, userId);
        nativeQuerySelect.setParameter(2, lectureId);
        try {
            if (nativeQuerySelect.getResultList().size() > 0) {
                return false;
            }
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