package ru.systemoteh.educationportal.prim.dao.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.systemoteh.educationportal.prim.dao.CourseDao;
import ru.systemoteh.educationportal.prim.model.Course;
import ru.systemoteh.educationportal.prim.model.UserCourse;
import ru.systemoteh.educationportal.prim.model.UserLecture;
import ru.systemoteh.educationportal.prim.model.UserTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import java.util.List;

public class CourseDaoJpaImpl implements CourseDao {

    @PersistenceContext(unitName = "edu_portal_prim")
    private EntityManager entityManager;

    @Override
    public Course getCourseById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> getAllCourses() {
        return entityManager.createQuery("from Course ").getResultList();
    }

    @Override
    public List<UserCourse> getUserCourseListByUserId(Long userId) {
        return entityManager.createQuery("select uc from UserCourse uc where uc.userId = :userId",
                UserCourse.class).setParameter("userId", userId).getResultList();
    }

    @Override   // TODO refactor велосипед. Выбрать все userLecture со всеми своими userTest по courseId
    @Transactional(value = "edu_portal_prim")
    public UserCourse getUserCourseByUserIdAndCourseId(Long userId, Long courseId) {
        try {
            UserCourse userCourse = entityManager.createQuery("select uc from UserCourse uc " +
                    "where uc.userId = :userId and uc.courseId = :courseId", UserCourse.class)
                    .setParameter("userId", userId)
                    .setParameter("courseId", courseId)
                    .getSingleResult();

            // TODO refactor to JPQL
            List<UserLecture> userLectureList = entityManager.createNativeQuery(
                    "SELECT * FROM user___lecture ul " +
                            "INNER JOIN lecture l ON ul.lecture_id = l.id " +
                            "WHERE ul.user_id = ? AND l.course_id = ?", UserLecture.class)
                    .setParameter(1, userId)
                    .setParameter(2, courseId)
                    .getResultList();
            userCourse.setUserLectureList(userLectureList);
            return userCourse;
        } catch (javax.persistence.NoResultException e) {
            entityManager.createNativeQuery(
                    "INSERT INTO user___course (user_id, course_id) VALUES (?, ?)")
                    .setParameter(1, userId)
                    .setParameter(2, courseId)
                    .executeUpdate();
            return getUserCourseByUserIdAndCourseId(userId, courseId);
        }
    }

}
