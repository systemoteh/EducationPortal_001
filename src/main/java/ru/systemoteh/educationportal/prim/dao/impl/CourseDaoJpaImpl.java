package ru.systemoteh.educationportal.prim.dao.impl;

import ru.systemoteh.educationportal.prim.dao.CourseDao;
import ru.systemoteh.educationportal.prim.model.Course;
import ru.systemoteh.educationportal.prim.model.UserCourse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CourseDaoJpaImpl implements CourseDao {

    CourseDao courseDao;
    @PersistenceContext(unitName = "edu_portal_prim")
    private EntityManager entityManager;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    // no used
    public Course getCourseById(Long id) {
        return entityManager.find(Course.class, id);
    }

    // no used
    public List<UserCourse> getUserCourseListByUserId(Long userId) {
        return entityManager.createQuery("select uc from UserCourse uc where uc.userId = :userId",
                UserCourse.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<Course> getAllCourses() {
        return entityManager.createQuery("from Course ").getResultList();
    }

    @Override // TODO on JPQL
    public UserCourse getUserCourseByUserIdAndCourseId(Long userId, Long courseId) {
        return courseDao.getUserCourseByUserIdAndCourseId(userId, courseId);
    }

}
