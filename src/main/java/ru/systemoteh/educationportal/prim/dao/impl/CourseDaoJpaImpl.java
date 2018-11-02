package ru.systemoteh.educationportal.prim.dao.impl;

import ru.systemoteh.educationportal.prim.dao.CourseDao;
import ru.systemoteh.educationportal.prim.model.Course;
import ru.systemoteh.educationportal.prim.model.UserCourse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @Override
    public UserCourse getUserCourseByUserIdAndCourseId(Long userId, Long courseId) {
        UserCourse userCourse = entityManager.createQuery("select uc from UserCourse uc " +
                        "where uc.userId = :userId and uc.courseId = :courseId",
                UserCourse.class).setParameter("userId", userId)
                .setParameter("courseId", courseId).getSingleResult();

        userCourse.setUserLectureList(null); // TODO запрос на userLectureListByUserIdAndCourseId
        return userCourse;
    }

}
