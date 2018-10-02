package ru.systemoteh.educationportal.dao;

import org.springframework.transaction.annotation.Transactional;
import ru.systemoteh.educationportal.model.Lecture;

import javax.persistence.*;
import java.util.List;

public class LectureDaoImpl implements LectureDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Lecture getLectureById(Integer id) {
        return entityManager.find(Lecture.class, id);
    }

    @Override
    public Lecture getLectureByLink(String link) {
        Query query = entityManager.createNativeQuery("SELECT * FROM lecture WHERE link = ?", Lecture.class);
        query.setParameter(1, link);
        return (Lecture) query.getSingleResult();
    }

    @Override   // no used
    public Lecture getLectureByCourseIdAndLectureLink(Integer courseId, String lectureLink) {
        Query query = entityManager.createNativeQuery("SELECT * FROM lecture WHERE course_id = ? AND link = ?  ", Lecture.class);
        query.setParameter(1, courseId);
        query.setParameter(2, lectureLink);
        return (Lecture) query.getSingleResult();
    }

    @Override
    public List<Lecture> getLecturesByCourseId(Integer courseId) {
        Query query = entityManager.createNativeQuery("SELECT * FROM lecture WHERE course_id = ?", Lecture.class);
        query.setParameter(1, courseId);
        return query.getResultList();
    }

    @Override   // no used
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

    @Override
    @Transactional
    public boolean unblockLecture(Long userId, int lectureId) {
        Boolean result = false;

        // TODO Сделать Хранимую Процедуру
        // TODO Проверка достаточно ли монет для списания. Сделать списание монет
        // TODO Проверка = нельзя дважды разблокировать одну лецию, PK = 2 ячейки TRY CATCH в процедуре

        StoredProcedureQuery procedureQuery = entityManager.
                createStoredProcedureQuery("unblock_lecture")
                .registerStoredProcedureParameter(1, Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, Boolean.class, ParameterMode.OUT)
                .setParameter(1, userId)
                .setParameter(2, lectureId);

        procedureQuery.execute();
        result = (Boolean) procedureQuery.getOutputParameterValue(3);
        return result;
    }

    @Override
    @Transactional  // no used
    public boolean unblockLectureWithoutCoins(Long userId, int lectureId) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO user___lecture (user_id, lecture_id) VALUES (?, ?)");
        query.setParameter(1, userId);
        query.setParameter(2, lectureId);
        int result = query.executeUpdate();
        return result > 0;
    }

}
